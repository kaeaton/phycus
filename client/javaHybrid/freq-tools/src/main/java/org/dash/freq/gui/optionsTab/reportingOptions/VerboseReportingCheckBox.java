package org.dash.freq.gui.optionsTab.reportingOptions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.dash.freq.utilities.Prefs;

public class VerboseReportingCheckBox {

	private JCheckBox verboseReportingCheckBox = new JCheckBox();

	public VerboseReportingCheckBox() { }

	public JCheckBox getVerboseReportingCheckBox() {
		verboseReportingCheckBox.setText("Verbose Reporting");
		verboseReportingCheckBox.setSelected(Prefs.getVerboseReportingSetting());
		verboseReportingCheckBox.addItemListener(verboseReportingListener);

		return verboseReportingCheckBox;
	}

	public ItemListener verboseReportingListener = new ItemListener() {
		public void itemStateChanged(ItemEvent evt) {
			Prefs.setVerboseReportingSetting(verboseReportingCheckBox.isSelected());
		}
	};
}
