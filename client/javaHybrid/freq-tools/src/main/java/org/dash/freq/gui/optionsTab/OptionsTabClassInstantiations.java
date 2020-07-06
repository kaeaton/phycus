package org.dash.freq.gui.optionsTab;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.dash.freq.gui.optionsTab.advanced.databaseLocationPopup.*;
import org.dash.freq.gui.optionsTab.customReceiptPath.*;
import org.dash.freq.gui.optionsTab.updateIon.updateIonPopup.*;

// import org.dash.freq.gui.ExitButton;

/**
 * Provides a central hub to access the instances of all components
 * that are part of the Options tab that need to be accessed by other 
 * classes within the program.
 *
 * @author Katrina Eaton
 * 
 */

public class OptionsTabClassInstantiations {

	// static variable single_instance of type Singleton 
	private static OptionsTabClassInstantiations single_instance = null;

	// instantiate components
	private JTextArea receiptPathTextArea = new ReceiptPathTextArea().getReceiptPathTextArea();
	private JFileChooser receiptPathChooser = new ReceiptPathChooser().getReceiptPathChooser();
	private DatabaseLocationPopup databaseLocationPopup = new DatabaseLocationPopup();
	private SubmitNewIonButton submitNewIonButton = new SubmitNewIonButton();

	// passing on the listener from the submit button so pressing enter will submit
	private UpdateIonTextField updateIonTextFieldClass = new UpdateIonTextField(submitNewIonButton.submitNewIonListener);

	// this textfield is not accessed directly, but passed on to the Update Ion panel
	private JTextField updateIonTextField = updateIonTextFieldClass.getUpdateIonTextField();

	// this panel is not accessed directly, but passed on to the Update Ion popup
	private JPanel updateIonPanel = new UpdateIonPanel(updateIonTextField).getUpdateIonPanel();
	private UpdateIonPopup updateIonPopup = new UpdateIonPopup(updateIonPanel);

	private OptionsTabClassInstantiations() { }

	// static method to create instance of Singleton class 
	public static OptionsTabClassInstantiations getOptionsTabClassInstantiationsInstance() { 
		if (single_instance == null) 
			single_instance = new OptionsTabClassInstantiations(); 

		return single_instance; 
	}

	public JTextArea getReceiptPathTextAreaInstance() {
		return receiptPathTextArea;
	}

	public UpdateIonTextField getUpdateIonTextFieldClassInstance() {
		return updateIonTextFieldClass;
	}

	public JFileChooser getReceiptPathChooserInstance() {
		return receiptPathChooser;
	}

	public DatabaseLocationPopup getDatabaseLocationPopupInstance() {
		return databaseLocationPopup;
	}

	public UpdateIonPopup getUpdateIonPopupInstance() {
		return updateIonPopup;
	}
}