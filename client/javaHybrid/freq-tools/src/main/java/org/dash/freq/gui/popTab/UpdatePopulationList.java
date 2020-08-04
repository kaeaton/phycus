package org.dash.freq.gui.popTab;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;

import org.dash.freq.uploadData.Population;
import org.dash.freq.utilities.AppendText;

import io.swagger.client.model.PopulationData;


/**
 *
 * @author katrinaeaton
 */
public class UpdatePopulationList {

	private Population populationClass;

	private List<PopulationData> populationsData;
	private List<PopulationData> filteredPopulationsData = new ArrayList();
	private JTextPane popResultsTextPane;

	public UpdatePopulationList(JTextPane popResultsTP, Population popClass) {
		this.popResultsTextPane = popResultsTP;
		this.populationClass = popClass;
	}
	
	public void updatePopulationsDisplayed (String searchTerm) {
		// clear text pane
		popResultsTextPane.setText("");
		
		// filteredPopulationsData = filterPopulationData(searchTerm, populationsData);

		if(filteredPopulationsData.isEmpty() || filteredPopulationsData == null) {

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

				popResultsTextPane.setText("Please wait...");
				
				try { populationsData = populationClass.getPopulationsFromDB(); }
				catch (Exception ex) {
					System.out.println("Population.java: problem downloading data: " + ex);
					ex.printStackTrace(); }

				updatePopulationsDisplayed("");
			}
		};

		new Thread(getPopulations).start();
	}

	private List<PopulationData> filterPopulationData (String searchTerm, List<PopulationData> filteredPopsData) {
		// filter names by search term

		// filteredPopsData = searched populationsData
		return filteredPopsData;

	}

	public List<PopulationData> getFilteredPopulationData() {

		if(filteredPopulationsData.isEmpty() || filteredPopulationsData == null) {

			filteredPopulationsData = populationsData;

			return filteredPopulationsData;

		} else {

			return filteredPopulationsData;
		}
	}
}