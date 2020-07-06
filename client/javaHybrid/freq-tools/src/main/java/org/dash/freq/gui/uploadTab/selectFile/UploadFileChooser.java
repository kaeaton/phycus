package org.dash.freq.gui.uploadTab.selectFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;

import org.dash.freq.utilities.Prefs;

public class UploadFileChooser {
	private JFileChooser uploadFileChooser = new JFileChooser(Prefs.getUploadPath());

	public UploadFileChooser() { }

	public JFileChooser getUploadFileChooser() {
		uploadFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		return uploadFileChooser;
	}
}







