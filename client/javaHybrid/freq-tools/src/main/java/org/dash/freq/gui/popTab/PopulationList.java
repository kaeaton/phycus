package org.dash.freq.gui.popTab;

import io.swagger.client.model.PopulationData;
import java.awt.Color;
import java.util.List;

import javax.swing.JTextPane;

import org.dash.freq.utilities.AppendText;

/**
 *
 * @author katrinaeaton
 */
public class PopulationList {

	private PopTabClassInstantiations popTabClassInstantiations = PopTabClassInstantiations.getPopTabClassInstantiationsInstance();
	private JTextPane popResultsTextPane = popTabClassInstantiations.getPopResultsTextPaneInstance();

	public PopulationList() { }
	
	public void updatePopulation (String searchTerms, List<PopulationData> pops)
	{
		// clear text pane
		popResultsTextPane.setText("");
		
		// list the populations
		for (PopulationData pop : pops) {
			AppendText.appendToPane(popResultsTextPane, (String.format("%-25s", pop.getName())), Color.BLACK);
			AppendText.appendToPane(popResultsTextPane, pop.getDescription(), Color.BLACK);
			AppendText.appendToPane(popResultsTextPane, System.lineSeparator(), Color.BLACK);
		}
	}
}
