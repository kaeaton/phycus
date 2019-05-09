
package org.dash.freq.controller;

import org.dash.freq.model.Population;

import io.swagger.client.ApiException;
import io.swagger.client.model.PopulationData;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.dash.freq.view.AppendText;
import org.dash.freq.view.PhycusGui;

/**
 *
 * @author kaeaton
 */
public class HeaderProcessor {

	// license types as designated by the API
	private final String[] licenseTypes = {"CC0", "BY", "BY_SA", "BY_ND", "BY_NC", "BY_NC_SA", "BY_NC_ND"};
	private final Set<String> licenses;
	
	// resolution types as designated by the API
	private final String[] resolutionTypes = {"G", "P", "gNMDP", "gDKMS", "1-Field", "2-Field", "3-Field", "4-Field", "Serology"};
	private final Set<String> resolutions;
	
	// populations
	private List<String> populationNames = new ArrayList();
	
	// printing titles
	HashMap<String, String> fullHeaderTitles = new  HashMap();

	public HeaderProcessor()
	{
		// set for accepted license and resolution types
		this.licenses = new HashSet(Arrays.asList(licenseTypes));
		this.resolutions = new HashSet(Arrays.asList(resolutionTypes));
		
		// set of populations pulled from db
		Population population = new Population();
		
		try 
		{
			List<PopulationData> populations = population.getPopulationsFromDB(); 
			this.populationNames = population.getPopulationNames(populations);
		}
		catch (Exception ex) { ex.printStackTrace(); }
		
		// full header titles for printing
		this.fullHeaderTitles.put("pop", "Population: ");
		this.fullHeaderTitles.put("cohort", "Cohort: ");
		this.fullHeaderTitles.put("license", "License: ");
		this.fullHeaderTitles.put("resolution", "Resolution: ");
		this.fullHeaderTitles.put("genotyping", "Genotyping group: ");
		this.fullHeaderTitles.put("haplotyping", "Haplotyping group: ");
	}
	
	public TreeMap<String, String> readHeader(BufferedReader reader,
												List<Integer> errorCodeList)
			throws IOException, ApiException 
	{
		// header variables
		String header;
		String[] attributes;
		TreeMap<String, String> headerContent = new TreeMap<>();
		
		// flags - Set of flags for all attributes
		Set<String> flags = new HashSet<>();
		boolean flag = true;
		
		// read first line
		// first line sample: pop=US_CAU,license=CC0,resolution=G,cohort="Proto test"
		header = reader.readLine();
		attributes = header.split(",");
		
		// break down the header
		for (int i = 0; i < attributes.length; i++)
		{
			// regex break
			String[] parsedAtt = parseAttribute(attributes[i]);
			
			// store all the attributes in the treemap
			headerContent.put(parsedAtt[0], parsedAtt[1]);
		}
		
		// check for population - mandatory
		if (headerContent.containsKey("pop")) 
		{
			// added .toString() because it's pulling unquoted text from the header
			// and checkPop doesn't read the values as strings
			flags.add(checkPop(headerContent.get("pop").toString(), errorCodeList));
		}
		else errorCodeList.add(4);
			
		// check for cohort - mandatory
		if (headerContent.containsKey("cohort")) 
		{
			flags.add(checkCohort(headerContent.get("cohort"), errorCodeList));
		}
		else errorCodeList.add(5);
		
		// check header for license type if present
		if (headerContent.containsKey("license"))
		{
			System.out.println("license: " + headerContent.get("license"));
			flags.add(checkLicenseType(headerContent.get("license")
				.toString(), errorCodeList));
		}
		
		// check header for resolution type if present
		if (headerContent.containsKey("resolution")) 
		{
			System.out.println("resolution: " + headerContent.get("resolution"));
			flags.add(checkResolutionType(headerContent.get("resolution")
				.toString(), errorCodeList));
		}
		
		// if any of the headers have errors, set flag to false
		if (flags.contains("false")) flag = false;
		
		// add flag to header content TreeMap so that DataChecks.java knows
		// if it needs to print out errors
		headerContent.put("flag", String.valueOf(flag));
		
		
		
		return headerContent;
	}
	
	private String[] parseAttribute(String att)
	{
		// pattern to match and string to check
		String[] parsedAttribute = new String[2];
		Pattern p = Pattern.compile("^([a-zA-Z]+)=(.+)$");
		Matcher m = p.matcher(att);
		
		// if match is found
		if (m.find())
		{
			parsedAttribute[0] = m.group(1);
			parsedAttribute[1] = m.group(2);
		}
		
		return parsedAttribute;
	}
	
	private String checkPop(String popValue, List<Integer> errorCodeList)
	{
		boolean flag = false;
		
		// does the population already exist in the db?
		if (populationNames.contains(popValue)) flag = true;
		else errorCodeList.add(3);
		
		printHeader("pop", popValue, flag);
		
		return String.valueOf(flag);
	}
	
	private String checkCohort(String cohortValue, List<Integer> errorCodeList)
	{
		boolean flag = true;
		
		// make sure the cohort data will fit in the database
		if (cohortValue.length() >= 255) 
		{
			errorCodeList.add(6); 
			flag = false;
		}
		
		return String.valueOf(flag);
	}
	
	private String checkLicenseType(String selectedLicense, List<Integer> errorCodeList)
	{
		boolean flag = false;
		
		// does the license match one of the accepted license types?
		if (licenses.contains(selectedLicense)) flag = true;
		else errorCodeList.add(7);
		
		return String.valueOf(flag);
	}
	
	private String checkResolutionType(String selectedResolution, List<Integer> errorCodeList)
	{
		boolean flag = false;
		
		// does the resolution match one of the accepted resolution types?
		if (resolutions.contains(selectedResolution)) flag = true;
		else errorCodeList.add(8);
		
		return String.valueOf(flag);
	}
	
	// verbose option, one line per element
	private void printHeader(String header, String headerValue, boolean valid)
	{
		AppendText.appendToPane(PhycusGui.outputTextPane, fullHeaderTitles.get(header), Color.BLACK);
		if (valid)
		{
			AppendText.appendToPane(PhycusGui.outputTextPane, headerValue, Color.BLACK);
		}
		else
		{
			AppendText.appendToPane(PhycusGui.outputTextPane, headerValue, Color.RED);
		}
		AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);

	}
}
