package org.dash.freq.gui.uploadTab.selectFile;

// import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import org.dash.freq.gui.uploadTab.UploadTabClassInstantiations;
import org.dash.freq.utilities.Prefs;

public class SelectFileButton {

	private JFileChooser uploadFileChooser = new UploadFileChooser().getUploadFileChooser();
	private JTextArea fileUploadTextArea;
	private File selectedFile = null;
	private String absolutePath, parentFolder, fileName;

	public SelectFileButton(JTextArea fileUpTextArea) {
		this.fileUploadTextArea = fileUpTextArea;
	}

	public JButton getSelectFileButton() {

		JButton selectFileButton = new JButton("Select File(s)");

		selectFileButton.addActionListener(selectFileListener);

		return selectFileButton;
	}

	private ActionListener selectFileListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			uploadFileChooser.setVisible(true);
			int returnValue = uploadFileChooser.showOpenDialog(null);
			if (returnValue == uploadFileChooser.APPROVE_OPTION) {
				// set the file, get the names necessary
				selectedFile = uploadFileChooser.getSelectedFile();
				absolutePath = selectedFile.getAbsolutePath();
				parentFolder = selectedFile.getParent();
				fileName = selectedFile.getName();
				System.out.println(fileName);
				
				// fileLocationTextArea.setText( absolutePath );
				// prefs.put("PHY_INPUT_DIR", absolutePath);
				// System.out.println(parentFolder);

				Prefs.setUploadPath(absolutePath);
				uploadFileChooser.setCurrentDirectory(new File(Prefs.getUploadPath()));

				// JTextArea fileUploadTextArea = uploadTabClassInstantiations.getUploadFilesTextAreaInstance();
				fileUploadTextArea.setText(absolutePath);
				// save parent folder location for receipt if individual file selected
				// if (selectedFile.isFile()) {
				//	 prefs.put("PHY_DEFAULT_RECEIPT_FOLDER", parentFolder);
				// }
				// // save absolute path for receipt if folder selected
				// else {
				//	 prefs.put("PHY_DEFAULT_RECEIPT_FOLDER", absolutePath);
				// }

				// if saving receipts to default location, update the textarea
				// listing where the receipts are being saved
				// if (defaultUploadReceiptCheckBox.isSelected())
				// {
				//	 uploadReceiptTextArea.setText(prefs.get("PHY_DEFAULT_RECEIPT_FOLDER", userDocumentsPath));
				// }
			}
		}
	};

	public File getTheSelectedFile() {
		try{
			return selectedFile;
		} catch(Exception ex) {
			System.out.println("SelectFileButton: getTheSelectedFile: " + ex);
		}
		return null;
	}
}