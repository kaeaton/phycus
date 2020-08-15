package org.dash.freq.gui.popTab;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import javax.swing.JTextPane;

import org.dash.freq.uploadData.Population;
import org.dash.freq.utilities.AppendText;

import io.swagger.client.model.PopulationData;


/**
 * Provides the functions for populating and updating the populations
 * listed in the Populations tab. This does not include talking to the
 * database (That's the Population class in uploadData.)
 *
 * @author katrinaeaton
 */
public class UpdatePopulationList {

	private Population populationClass;

	private volatile List<PopulationData> populationsData;
	private List<PopulationData> filteredPopulationsData = new ArrayList();
	private JTextPane popResultsTextPane;
	// private static volatile boolean exit = false;

	public UpdatePopulationList(JTextPane popResultsTP, Population popClass) {
		this.popResultsTextPane = popResultsTP;
		this.populationClass = popClass;
	}
	
	public void updatePopulationsDisplayed (String searchTerm) {
		// clear text pane
		popResultsTextPane.setText("");
		
		filteredPopulationsData = filterPopulationData(searchTerm, populationsData);

		if(filteredPopulationsData.isEmpty()) { //|| filteredPopulationsData == null) {

			AppendText.appendToPane(popResultsTextPane, "There are no populations", Color.BLACK);

		} else {

			// list the populations
			for (PopulationData pop : filteredPopulationsData) {
				AppendText.appendToPane(popResultsTextPane, (String.format("%-25s", pop.getName())), Color.BLACK);
				AppendText.appendToPane(popResultsTextPane, pop.getDescription(), Color.BLACK);
				AppendText.appendToPane(popResultsTextPane, System.lineSeparator(), Color.BLACK);
			}
		}
	}

	public void downloadAllPopulations() {

		Runnable getPopulations = new Runnable() {
			public void run() {

				popResultsTextPane.setText("");
				popResultsTextPane.setText("Please wait...");
				
				try { populationsData = populationClass.getPopulationsFromDB(); 
				updatePopulationsDisplayed("");
				}
				catch (Exception ex) {
					popResultsTextPane.setText("Population.java: problem downloading data: " + ex);
					System.out.println("Population.java: problem downloading data: " + ex);
					ex.printStackTrace(); 
				}


				// end the thread
				return;
			}
		};

		new Thread(getPopulations).start();
	}

	private List<PopulationData> filterPopulationData (String searchTerm, List<PopulationData> filteredPopsData) {
		// filter names by search term
		List<PopulationData> matchingPopList = new ArrayList();
		
		Pattern p = Pattern.compile(searchTerm.toUpperCase());
		
		if (filteredPopsData != null && !filteredPopsData.isEmpty()) {

			// search through the list for matches
			for(PopulationData population:filteredPopsData) {
				// check name
				Matcher m = p.matcher(population.getName().toUpperCase());
				if (m.find()) matchingPopList.add(population);
				else {
					// check description
					m = p.matcher(population.getDescription().toUpperCase());
					if (m.find()) matchingPopList.add(population);
				}
			}
		}
		// filteredPopsData = searched populationsData
		return matchingPopList;
	}

	public List<PopulationData> getDownloadedPopulationsData() {
		return populationsData;
	}
}