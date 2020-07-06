package org.dash.freq.gui.optionsTab.advanced.databaseLocationPopup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.JTextField;

// import org.dash.freq.gui.optionsTab.OptionsTabClassInstantiations;
// import org.dash.freq.gui.optionsTab.updateIon.updateIonPopup.UpdateIonPopup;
import org.dash.freq.utilities.Prefs;

public class DatabaseSetUrlButton {
	
	private JButton databaseSetUrlButton = new JButton("Update Database");

	// private OptionsTabClassInstantiations optionsTabClassInstantiations = OptionsTabClassInstantiations.getOptionsTabClassInstantiationsInstance();
	// private JTextField updateIonPopupFrame = optionsTabClassInstantiations.getUpdateIonPopupInstance();

	public DatabaseSetUrlButton() { }

	public JButton getDatabaseSetUrlButton() {

		databaseSetUrlButton.addActionListener(databaseSetUrlListener);

		return databaseSetUrlButton;
	}

	private ActionListener databaseSetUrlListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {

		}
	};
}

