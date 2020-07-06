package org.dash.freq.gui.optionsTab.updateIon.updateIonPopup;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SubmitNewIonButton {

	private JButton submitNewIonButton = new JButton();

	public SubmitNewIonButton() { }

	public JButton getSubmitNewIonButton() {
		submitNewIonButton.setPreferredSize(new Dimension(90, 30));
		submitNewIonButton.addActionListener(submitNewIonListener);

		return submitNewIonButton;
	}

	public ActionListener submitNewIonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {

			System.out.println("The submit new ION listener was triggered.");
			// refresh main page with new or no ION
			// uploadTabIonPanel.updateIonPanel();
		}
	};
}