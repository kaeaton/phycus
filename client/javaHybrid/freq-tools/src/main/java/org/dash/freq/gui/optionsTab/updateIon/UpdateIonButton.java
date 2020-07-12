package org.dash.freq.gui.optionsTab.updateIon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

// import org.dash.freq.gui.optionsTab.OptionsTabClassInstantiations;
// import org.dash.freq.gui.optionsTab.updateIon.updateIonPopup.UpdateIonPopup;
// import org.dash.freq.utilities.Prefs;

public class UpdateIonButton {
	
	private JButton updateIonButton = new JButton("Update Ion");
	private UpdateIonPopup updateIonPopup;

	// private OptionsTabClassInstantiations optionsTabClassInstantiations = OptionsTabClassInstantiations.getOptionsTabClassInstantiationsInstance();
	// private UpdateIonPopup updateIonPopup = optionsTabClassInstantiations.getUpdateIonPopupInstance();

	// private JDialog updateIonPopup = new UpdateIonPopup("updateIonPanel");


	public UpdateIonButton(UpdateIonPopup updateIonPU) {
		this.updateIonPopup = updateIonPU;
	}

	public JButton getUpdateIonButton() {

		updateIonButton.addActionListener(updateIonListener);

		return updateIonButton;
	}

	private ActionListener updateIonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			// updateIonPopupFrame.setVisible(true);
			updateIonPopup.setVisible(true);

			// load ION xml in background
		}
	};
}

