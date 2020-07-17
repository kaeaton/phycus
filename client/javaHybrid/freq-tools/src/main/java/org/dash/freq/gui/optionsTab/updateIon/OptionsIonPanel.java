package org.dash.freq.gui.optionsTab.updateIon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dash.freq.utilities.Prefs;
import org.dash.freq.utilities.StyleGuide;

public class OptionsIonPanel extends JPanel {

	private JLabel ionLabel = new JLabel("test");
	private JButton resetIonButton = new ResetIonButton(ionLabel).getResetIonButton();
	private JButton updateIonButton = new JButton("Update Ion");
	private TitledBorder ionBorder = BorderFactory.createTitledBorder(StyleGuide.TITLED_BORDER_OUTLINE, "Reset Issuing Organization Number (ION)");
	private Border paddingBorder = StyleGuide.EMPTY_BORDER_MARGIN_VERTICAL;
	private JPanel ionPanel = new JPanel();
	private JPanel ionButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel ionLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	private Frame ionParentFrame = findParentFrame(this);
	private UpdateIonPopup updateIonPopup;
	// private UpdateIonPopup updateIonPopup = new UpdateIonPopup(ionParentFrame, "test", ionPanel);

	public OptionsIonPanel() { }

	public JPanel getOptionsIonPanel() {

		updateIonButton.addActionListener(updateIonListener);

		ionLabelPanel.setPreferredSize(new Dimension(500, 30));
		ionLabelPanel.add(ionLabel);
		ionLabelPanel.setBorder(StyleGuide.EMPTY_BORDER_ZERO);

		ionButtonPanel.setPreferredSize(new Dimension(500, 30));
		ionButtonPanel.add(resetIonButton);
		ionButtonPanel.add(updateIonButton);
		ionButtonPanel.setBorder(StyleGuide.EMPTY_BORDER_ZERO);


		// this.setPreferredSize(new Dimension(500, 160));
		// this.add(ionLabelPanel);
		// this.add(ionButtonPanel);

		// layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		// c.weightx = 0.5;
		
		// line 0
		c.gridx = 0;
		c.gridy = 0;
		this.add(ionLabelPanel, c);
		
		// line 1
		c.gridy = 1;
		this.add(ionButtonPanel, c);

		// border
		this.setBorder(new CompoundBorder(paddingBorder, ionBorder));

		return this;
	}

	private ActionListener updateIonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			updateIonPopup = new UpdateIonPopup(ionParentFrame, ionPanel);
			updateIonPopup.setVisible(true);

			// load ION xml in background
		}
	};

	private Frame findParentFrame(JPanel childPanel) {
		Window parentWindow = SwingUtilities.windowForComponent(childPanel); 

		// or pass 'this' if you are inside the panel
		Frame parentFrame = null;
		if (parentWindow instanceof Frame) {
		    parentFrame = (Frame)parentWindow;
		}

		return parentFrame;
	}

	public void updateOptionsTabIonPanel() {
		Component[] components = ionLabelPanel.getComponents();
		ionLabelPanel.remove(components[0]);

		ionLabel.setText("Test again");
		ionLabelPanel.add(ionLabel).revalidate();
		ionLabelPanel.repaint();

		if(Prefs.getIonNumber().equals("")) ionLabel.setText("No ION set");
	}
}
