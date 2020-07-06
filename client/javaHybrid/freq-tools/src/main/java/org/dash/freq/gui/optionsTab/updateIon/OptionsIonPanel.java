package org.dash.freq.gui.optionsTab.updateIon;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.dash.freq.utilities.StyleGuide;

public class OptionsIonPanel {

	private JButton resetIonButton = new ResetIonButton().getResetIonButton();
	private JButton updateIonButton = new UpdateIonButton().getUpdateIonButton();
	private TitledBorder ionBorder = BorderFactory.createTitledBorder(StyleGuide.TITLED_BORDER_OUTLINE, "Reset Issuing Organization Number (ION)");
	private Border paddingBorder = StyleGuide.EMPTY_BORDER_MARGIN_VERTICAL;
	private JPanel ionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	public OptionsIonPanel() { }

	public JPanel getOptionsIonPanel() {
		ionPanel.setPreferredSize(new Dimension(500, 80));
		ionPanel.add(resetIonButton);
		ionPanel.add(updateIonButton);
		ionPanel.setBorder(new CompoundBorder(paddingBorder, ionBorder));

		return ionPanel;
	}
}
