package org.dash.freq.gui;

import java.awt.Dimension;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.dash.freq.gui.doiTab.*;
import org.dash.freq.gui.helpTab.*;
import org.dash.freq.gui.labelTab.*;
import org.dash.freq.gui.optionsTab.*;
import org.dash.freq.gui.popTab.*;
import org.dash.freq.gui.uploadTab.*;
import org.dash.freq.utilities.Prefs;

public class Gui extends JFrame {

	public static JTabbedPane parentTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

	public Gui() {
		// jFrame settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(560, 800));
		this.add(parentTabbedPane);

		parentTabbedPane.addChangeListener(whichTabListener);

		// upload tab
		UploadTab uploadTab = new UploadTab();
		parentTabbedPane.addTab("Upload Files", null, uploadTab, "Upload filed to the database");
		
		// population tab
		PopTab popTab = new PopTab();
		parentTabbedPane.addTab("Populations", null, popTab, "Search available populations");
		
		// label tab
		LabelTab labelTab = new LabelTab();
		parentTabbedPane.addTab("Labels", null, labelTab, "Search available labels");
		
		// DOI converter tab
		DoiTab doiTab = new DoiTab();
		parentTabbedPane.addTab("DOI converter", null, doiTab, "Convert publication IDs");
		
		// options tab
		OptionsTab optionsTab = new OptionsTab();
		parentTabbedPane.addTab("Options", null, optionsTab, "Program options");
		
		// help tab
		HelpTab helpTab = new HelpTab();
		parentTabbedPane.addTab("Help", null, helpTab, "Help");
		


		this.pack();
		this.setLocationRelativeTo(null);

		// parentTabbedPane.setSelectedIndex(Prefs.getCurrentTab());

	}

	private ChangeListener whichTabListener = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent evt) {
			int selectedIndex = parentTabbedPane.getSelectedIndex();
			Prefs.setCurrentTab(selectedIndex);
		}
	};

	private void startPopTab(int selectedIndex) {
		int popTabIndex = 1;

		if (selectedIndex == popTabIndex) {
			// clear pop textpane
			// popResultsTextPane.setText("");
			// AppendText.appendToPane(PhycusGui.popResultsTextPane, "Please wait", Color.BLACK);
			// AppendText.appendToPane(PhycusGui.popResultsTextPane, System.lineSeparator(), Color.BLACK);

			// populate text pane
			// new Thread(getPops).start();
		}
	}

	private void startLabelTab(int selectedIndex) {
		int labelTabIndex = 2;

		if (selectedIndex == labelTabIndex) {
			// clear pop textpane
			// popResultsTextPane.setText("");
			// AppendText.appendToPane(PhycusGui.popResultsTextPane, "Please wait", Color.BLACK);
			// AppendText.appendToPane(PhycusGui.popResultsTextPane, System.lineSeparator(), Color.BLACK);

			// populate text pane
			// new Thread(getPops).start();
		}
	}
}