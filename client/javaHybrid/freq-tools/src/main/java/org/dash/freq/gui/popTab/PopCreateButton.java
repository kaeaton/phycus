package org.dash.freq.gui.popTab;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.dash.freq.exceptions.*;
import org.dash.freq.uploadData.Population;
import org.dash.freq.utilities.AppendText;
import org.dash.freq.utilities.FindParentFrame;

import io.swagger.client.model.PopulationData;

public class PopCreateButton {
	
	private JButton popCreateButton = new JButton("Create");

	private PopTabClassInstantiations popTabClassInstantiations = PopTabClassInstantiations.getPopTabClassInstantiationsInstance();

	private JTextField popSearchTextField = popTabClassInstantiations.getPopSearchTextFieldInstance();
	private JTextPane popResultsTextPane = popTabClassInstantiations.getPopResultsTextPaneInstance();
	private JTextPane popNotificationsTextPane = popTabClassInstantiations.getPopNotificationsTextPaneInstance();
	private UpdatePopulationList updatePopulationList = popTabClassInstantiations.getUpdatePopulationListInstance();

	private Population populationClass = popTabClassInstantiations.getPopulationClassInstance();
	private List<PopulationData> populationsData;
	private List<PopulationData> filteredPopulationsData;

	private JPanel parentPanel;
	private Frame parentFrame;

	public PopCreateButton() { }

	public JButton getPopCreateButton() {

		popCreateButton.setPreferredSize(new Dimension(90, 30));
		popCreateButton.addActionListener(popCreateListener);

		return popCreateButton;
	}

	private ActionListener popCreateListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {

			System.out.println("PopCreateButton activated");
			String popSearchName = popSearchTextField.getText();
			String popSearchDescription = "";
			boolean popFlag = true;

			parentPanel = (JPanel)((JButton)evt.getSource()).getParent(); 
			parentFrame = FindParentFrame.getParentFrame(parentPanel);
			
			filteredPopulationsData = updatePopulationList.getFilteredPopulationData();
			List<String> popNames = populationClass.getPopulationNames(filteredPopulationsData);
			System.out.println("pop Name: " + popSearchName);
			
			// does this name already exist?		
			if (popNames.contains(popSearchName)) {
				popFlag = false;
				
				nameAlreadyExists(parentFrame, popSearchName);
			}
			
			// is the name blank?
			else if (popSearchName == null || popSearchName.equals("")) {
				popFlag = false;
				nameFieldIsEmpty(parentFrame);
			}
			
			// if name does not exist ask for a description
			else {

				// popup for description
				popSearchDescription = JOptionPane.showInputDialog(this, "Please enter a brief description of your population:");
				
				// if description is empty
				if(popSearchDescription == null || popSearchDescription.equals("")) {
					popFlag = false;
					
					descriptionFieldIsEmpty(parentFrame);
				}
			}

			System.out.println("pop Desc: " + popSearchDescription);

			// upload pop name / description
			if (popFlag) {
				try { 
					// create new population in db
					populationClass.createNewPopulation(popSearchName, popSearchDescription);

				} catch (Exception ex) {

					System.out.println(ex);
					popFlag = false;
					
					// JOptionPane.showMessageDialog(this,
					JOptionPane.showMessageDialog(parentFrame,
						("The population was not created\n" + ex),
						"Houston, we have a problem",
						JOptionPane.ERROR_MESSAGE);
				}

				// if the population was successfully created
				if (popFlag) {

					// notify that new pop has been created
					AppendText.appendToPane(popNotificationsTextPane, ("Population " + popSearchName + " created."), Color.BLACK);
					AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);

					// clear pop textpane
					// popResultsTextPane.setText("");

					// redownload db in background
					// new Thread(getPops).start();
					updatePopulationList.downloadAllPopulations();

					// clear search bar
					popSearchTextField.setText("");
				}
			} else {
				// notify that new pop has not been created
				AppendText.appendToPane(popNotificationsTextPane, ("No population created."), Color.BLACK);
				AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);
			}

			// refresh population list
			updatePopulationList.updatePopulationsDisplayed("");
		}
	};

	private void nameAlreadyExists(Frame parentFrame, String popSearchName) {

		AppendText.appendToPane(popNotificationsTextPane, "The population name already exists", Color.RED);
		AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);
		
		JOptionPane.showMessageDialog(parentFrame,
			("The population " + popSearchName + " already exists"),
			"This population already exists",
			JOptionPane.ERROR_MESSAGE);
	}

	private void nameFieldIsEmpty(Frame parentFrame) {
		AppendText.appendToPane(popNotificationsTextPane, "The population name cannot be blank", Color.RED);
		AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);
			
		JOptionPane.showMessageDialog(parentFrame,
			("The population name cannot be blank"),
			 "Houston, we have a problem",
			 JOptionPane.ERROR_MESSAGE);
	}

	private void descriptionFieldIsEmpty(Frame parentFrame) {
		AppendText.appendToPane(popNotificationsTextPane, "The population description cannot be blank", Color.RED);
		AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);

		JOptionPane.showMessageDialog(parentFrame,
			("The population description cannot be blank"),
			 "Houston, we have a problem",
			 JOptionPane.ERROR_MESSAGE);
	}
}