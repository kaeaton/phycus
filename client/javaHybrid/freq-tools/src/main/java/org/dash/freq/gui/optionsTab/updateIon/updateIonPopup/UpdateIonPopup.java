package org.dash.freq.gui.optionsTab.updateIon.updateIonPopup;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

// import org.dash.freq.gui.optionsTab.OptionsTabClassInstantiations;

public class UpdateIonPopup extends JFrame {

	// private JPanel updateIonPanel = new UpdateIonPanel().getUpdateIonPanel();
	// private OptionsTabClassInstantiations optionsTabClassInstantiations = OptionsTabClassInstantiations.getOptionsTabClassInstantiationsInstance();
	// private DatabaseLocationPopup databaseLocationPopupFrame = optionsTabClassInstantiations.getDatabaseLocationPopupInstance();

	public UpdateIonPopup(JPanel updateIonPanel) {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setPreferredSize(new Dimension(360, 300));
		this.add(updateIonPanel);
		this.setAlwaysOnTop(true);
		this.setVisible(false);

		this.pack();
		this.setLocationRelativeTo(null);
	}
}