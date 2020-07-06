package org.dash.freq.gui.optionsTab.updateIon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// import org.dash.freq.gui.optionsTab.OptionsTabClassInstantiations;
import org.dash.freq.gui.uploadTab.*;
import org.dash.freq.utilities.Prefs;

public class ResetIonButton {
	
	private JButton resetIonButton = new JButton("Reset Ion");

	private UploadTabClassInstantiations uploadTabClassInstantiations = UploadTabClassInstantiations.getUploadTabClassInstantiationsInstance();
	private IonPanel uploadTabIonPanel = uploadTabClassInstantiations.getIonPanelInstance();


	public ResetIonButton() { }

	public JButton getResetIonButton() {

		resetIonButton.addActionListener(resetIonListener);

		return resetIonButton;
	}

	private ActionListener resetIonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			Prefs.resetIon();

			// refresh main page with new or no ION
			uploadTabIonPanel.updateIonPanel();
		}
	};
}

