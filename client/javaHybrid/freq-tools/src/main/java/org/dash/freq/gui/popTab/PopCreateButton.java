package org.dash.freq.gui.popTab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.dash.freq.exceptions.*;
import org.dash.freq.uploadData.Population;
import org.dash.freq.utilities.AppendText;

public class PopCreateButton {
	
	private JButton popCreateButton = new JButton("Create");

	private PopTabClassInstantiations popTabClassInstantiations = PopTabClassInstantiations.getPopTabClassInstantiationsInstance();

	private JTextField popSearchTextField = popTabClassInstantiations.getPopSearchTextFieldInstance();
	private JTextPane popNotificationsTextPane = popTabClassInstantiations.getPopNotificationsTextPaneInstance();

	public JButton getPopCreateButton() {

		popCreateButton.setPreferredSize(new Dimension(90, 30));
		popCreateButton.addActionListener(popCreateListener);

		return popCreateButton;
	}

	private ActionListener popCreateListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {

			System.out.println("PopCreateButton activated");
			// String popSearchName = popSearchTextField.getText();
			// String popSearchDescription = "";
			// boolean popFlag = true;
			
			// List<String> popNames = population.getPopulationNames(populations);
			// System.out.println("pop Name: " + popSearchName);
			
			// // does this name already exist?		
			// if (popNames.contains(popSearchName))
			// {
			// 	popFlag = false;
				
			// 	AppendText.appendToPane(popNotificationsTextPane, "The population name already exists", Color.RED);
			// 	AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);
				
			// 	JOptionPane.showMessageDialog(this,
			// 		("The population " + popSearchName + " already exists"),
			// 		"This population already exists",
			// 		JOptionPane.ERROR_MESSAGE);
			// }
			
			// // is the name blank?
			// else if (popSearchName == null || popSearchName.equals(""))
			// {
			// 	popFlag = false;
				
			// 	AppendText.appendToPane(popNotificationsTextPane, "The population name cannot be blank", Color.RED);
			// 	AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);
					
			// 	JOptionPane.showMessageDialog(this,
			// 		("The population name cannot be blank"),
			// 		 "Houston, we have a problem",
			// 		 JOptionPane.ERROR_MESSAGE);
			// }
			
			// // if name does not exist ask for a description
			// else
			// {
			// 	// popup for description
			// 	popSearchDescription = JOptionPane.showInputDialog(this, "Please enter a brief description of your population:");
				
			// 	// if description is empty
			// 	if(popSearchDescription == null || popSearchDescription.equals(""))
			// 	{
			// 		popFlag = false;
					
			// 		AppendText.appendToPane(popNotificationsTextPane, "The population description cannot be blank", Color.RED);
			// 		AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);

			// 		JOptionPane.showMessageDialog(this,
			// 			("The population description cannot be blank"),
			// 			 "Houston, we have a problem",
			// 			 JOptionPane.ERROR_MESSAGE);
			// 	}
			// }

			// System.out.println("pop Desc: " + popSearchDescription);

			// // upload pop name / description
			// if (popFlag)
			// {
			// 	try 
			// 	{ 
			// 		// create new population in db
			// 		population.createNewPopulation(popSearchName, popSearchDescription);
			// 	} 
			// 	catch (Exception ex) 
			// 	{
			// 		System.out.println(ex);
			// 		popFlag = false;
					
			// 		JOptionPane.showMessageDialog(this,
			// 			("The population was not created\n" + ex),
			// 			"Houston, we have a problem",
			// 			JOptionPane.ERROR_MESSAGE);
			// 	}
			// 	if (popFlag)
			// 	{
			// 		// notify that new pop has been created
			// 		AppendText.appendToPane(popNotificationsTextPane, ("Population " + popSearchName + " created."), Color.BLACK);
			// 		AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);

			// 		// clear pop textpane
			// 		popResultsTextPane.setText("");

			// 		// redownload db in background
			// 		new Thread(getPops).start();

			// 		// clear search bar
			// 		popSearchTextField.setText("");
			// 	}
			// }
			// else
			// {
			// 	// notify that new pop has not been created
			// 	AppendText.appendToPane(popNotificationsTextPane, ("No population created."), Color.BLACK);
			// 	AppendText.appendToPane(popNotificationsTextPane, System.lineSeparator(), Color.BLACK);
			// }

			// refresh population list
		}
	};
}