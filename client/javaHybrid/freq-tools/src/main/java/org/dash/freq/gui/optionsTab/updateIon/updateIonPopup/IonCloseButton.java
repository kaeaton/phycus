package org.dash.freq.gui.optionsTab.updateIon.updateIonPopup;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.dash.freq.gui.optionsTab.OptionsTabClassInstantiations;

public class IonCloseButton {

	private JButton closeButton = new JButton("Close");

	// private OptionsTabClassInstantiations optionsTabClassInstantiations = OptionsTabClassInstantiations.getOptionsTabClassInstantiationsInstance();
	// private UpdateIonPopup updateIonPopup = optionsTabClassInstantiations.getUpdateIonPopupInstance();

	public IonCloseButton() { }

	public JButton getCloseButton() {
		// JButton closeButton = new JButton("Close");
		closeButton.setPreferredSize(new Dimension(90, 30));

		closeButton.addActionListener(closeListener);

		return closeButton;
	}

	public ActionListener closeListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			// super.setVisible(false);
		}
	};
}
