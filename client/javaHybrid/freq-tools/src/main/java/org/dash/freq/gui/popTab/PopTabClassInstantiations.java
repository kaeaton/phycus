package org.dash.freq.gui.popTab;

import javax.swing.JTextField;
import javax.swing.JTextPane;

// import org.dash.freq.gui.ExitButton;

/**
 * Provides a central hub to access the instances of all components of 
 * the PopTab that need to be accessed by any not-PopTab portions of the program. 
 *
 * @author Katrina Eaton
 * 
 */

public class PopTabClassInstantiations {

	// static variable single_instance of type Singleton 
	private static PopTabClassInstantiations single_instance = null;

	private JTextField popSearchTextField = new PopSearchTextField().getPopSearchTextField();
	private JTextPane popResultsTextPane =  new PopResultsTextPane().getPopResultsTextPane();
	private JTextPane popNotificationsTextPane =  new PopNotificationsTextPane().getPopNotificationsTextPane();

	private PopTabClassInstantiations() { }

	// static method to create instance of Singleton class 
	public static PopTabClassInstantiations getPopTabClassInstantiationsInstance() { 
		if (single_instance == null) 
			single_instance = new PopTabClassInstantiations(); 

		return single_instance; 
	}


	public JTextField getPopSearchTextFieldInstance() {
		return popSearchTextField;
	}

	public JTextPane getPopResultsTextPaneInstance() {
		return popResultsTextPane;
	}

	public JTextPane getPopNotificationsTextPaneInstance() {
		return popNotificationsTextPane;
	}
}