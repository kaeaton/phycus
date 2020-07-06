package org.dash.freq.gui.optionsTab.updateIon.updateIonPopup;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class UpdateIonTextField {
	
	private JTextField updateIonTextField = new JTextField();
	private ActionListener submitNewIonListener;
	
	public UpdateIonTextField(ActionListener submitNewIonListen) {
		this.submitNewIonListener = submitNewIonListen;
	}

	public JTextField getUpdateIonTextField() {
		updateIonTextField.setFocusable(true);
		updateIonTextField.setColumns(26);

		updateIonTextField.addActionListener(submitNewIonListener);


		return updateIonTextField;
	}

	public String getUpdateIonTextFieldValue() {
		String updateIonTextFieldContents = updateIonTextField.getText();

		return updateIonTextFieldContents;
	}
}