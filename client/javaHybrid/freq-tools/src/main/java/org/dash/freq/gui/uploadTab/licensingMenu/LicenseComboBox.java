package org.dash.freq.gui.uploadTab.licensingMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import org.dash.freq.gui.uploadTab.UploadTabClassInstantiations;
import org.dash.freq.utilities.Prefs;


public class LicenseComboBox {

	private final String[] licenseOptions = { 
							"CC0 - No rights reserved",
							"BY - Attribution",
							"BY_SA - Attribution - ShareAlike",
							"BY_ND - Attribution - NoDerivatives",
							"BY_NC - Attribution - NonCommercial",
							"BY_NC_SA - Attribution - NonCommercial - ShareAlike",
							"BY_NC_ND - Attribution - NonCommercial - NoDerivatives" };

	private JComboBox licenseComboBox = new JComboBox(licenseOptions);

	// private UploadTabClassInstantiations uploadTabClassInstantiations = UploadTabClassInstantiations.getUploadTabClassInstantiationsInstance();

	public LicenseComboBox() { }

	public JComboBox getLicenseComboBox() {

		licenseComboBox.setSelectedIndex(Prefs.getLicensingSelected());
		licenseComboBox.addActionListener(licenseComboBoxListener);

		return licenseComboBox;
	}

	public ActionListener licenseComboBoxListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int licenseComboBoxSelection = licenseComboBox.getSelectedIndex();
			Prefs.setLicensingSelected(licenseComboBoxSelection);
		}
	};

	public String getSelectedLicenseCode() {
		// JComboBox licenseComboBoxInstance = uploadTabClassInstantiations.getUploadLicenseComboBoxInstance();
		String licenseSelection = licenseComboBox.getSelectedItem().toString();
		String licenseCode = licenseSelection.split(" ")[0];

		System.out.println("Selected license code = " + licenseCode);

		return licenseCode;

	}
}
