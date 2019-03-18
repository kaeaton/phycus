/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dash.freq.view;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.dash.freq.controller.BatchUploader;
import org.dash.freq.model.PostPopulationFrequencies;

/**
 *
 * @author katrinaeaton
 */
public class PhycusGui extends javax.swing.JFrame {
	
	File selectedFile;
	private String gtRegistry;
	private String estEntity;
	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());
	private URL url;
	private boolean folder = false;
	/**
	 * Creates new form PhycusGui
	 */
	public PhycusGui() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooserUpload = new javax.swing.JFileChooser(prefs.get("LAST_OUTPUT_DIR", (System.getProperty("user.home")+ System.getProperty("file.separator") + "Documents")));
        fileOrFolder = new javax.swing.ButtonGroup();
        GTRegistryPopupFrame = new javax.swing.JFrame();
        GTResgistryTextField = new javax.swing.JTextField();
        GTRegistryEnterButton = new javax.swing.JButton();
        GTRegistryCloseButton = new javax.swing.JButton();
        GTRegistryInstructions1 = new javax.swing.JLabel();
        GTRegistryInstructions2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        UploadFilesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileLocationTextArea = new javax.swing.JTextArea();
        uploadButton = new javax.swing.JButton();
        CsvNotificationLabel = new javax.swing.JLabel();
        SelectFilePanel = new javax.swing.JPanel();
        fileOpenButton = new javax.swing.JButton();
        jRBFile = new javax.swing.JRadioButton();
        jRBFolder = new javax.swing.JRadioButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        cancelButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextPane = new javax.swing.JTextPane();
        licenseComboBox = new javax.swing.JComboBox<>();
        licenseLabel = new javax.swing.JLabel();
        licenseHelpIcon = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        SettingsPanel = new javax.swing.JPanel();
        HelpPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        helpTextPane = new javax.swing.JTextArea();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values file", "csv");
        fileChooserUpload.setFileFilter(filter);

        GTRegistryPopupFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        GTRegistryPopupFrame.setTitle("Genotyping Registry");
        GTRegistryPopupFrame.setAlwaysOnTop(true);
        GTRegistryPopupFrame.setEnabled(prefs.getBoolean("GTReg", true)
        );

        GTRegistryEnterButton.setText("Enter");

        GTRegistryCloseButton.setText("Close");
        GTRegistryCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GTRegistryCloseButtonActionPerformed(evt);
            }
        });

        GTRegistryInstructions1.setText("Please enter the ION or other facility identification ");

        GTRegistryInstructions2.setText("of the entity performing the genotyping:");

        javax.swing.GroupLayout GTRegistryPopupFrameLayout = new javax.swing.GroupLayout(GTRegistryPopupFrame.getContentPane());
        GTRegistryPopupFrame.getContentPane().setLayout(GTRegistryPopupFrameLayout);
        GTRegistryPopupFrameLayout.setHorizontalGroup(
            GTRegistryPopupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GTRegistryPopupFrameLayout.createSequentialGroup()
                .addGroup(GTRegistryPopupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GTRegistryPopupFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(GTRegistryPopupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(GTRegistryInstructions1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GTRegistryInstructions2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(GTRegistryPopupFrameLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(GTResgistryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GTRegistryPopupFrameLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(GTRegistryEnterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GTRegistryCloseButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GTRegistryPopupFrameLayout.setVerticalGroup(
            GTRegistryPopupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GTRegistryPopupFrameLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(GTRegistryInstructions1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GTRegistryInstructions2)
                .addGap(18, 18, 18)
                .addComponent(GTResgistryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(GTRegistryPopupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GTRegistryEnterButton)
                    .addComponent(GTRegistryCloseButton))
                .addGap(18, 18, 18))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phycus Upload Interface");
        setLocationByPlatform(true);

        jScrollPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setOpaque(false);

        fileLocationTextArea.setEditable(false);
        fileLocationTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        fileLocationTextArea.setColumns(20);
        fileLocationTextArea.setLineWrap(true);
        fileLocationTextArea.setRows(5);
        fileLocationTextArea.setFocusable(false);
        fileLocationTextArea.setOpaque(false);
        jScrollPane1.setViewportView(fileLocationTextArea);

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        CsvNotificationLabel.setText("CSV files only.");

        SelectFilePanel.setLayout(new java.awt.GridBagLayout());

        fileOpenButton.setText("Select File");
        fileOpenButton.setMaximumSize(new java.awt.Dimension(100, 23));
        fileOpenButton.setMinimumSize(new java.awt.Dimension(100, 23));
        fileOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        SelectFilePanel.add(fileOpenButton, gridBagConstraints);

        fileOrFolder.add(jRBFile);
        jRBFile.setText("File");
        jRBFile.setName("file"); // NOI18N
        if (prefs.getBoolean("FILE_OR_FOLDER", true)){
            setFile();
            jRBFile.setSelected(true);
        } else {
            setFolder();
            jRBFolder.setSelected(true);
        }
        jRBFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        SelectFilePanel.add(jRBFile, gridBagConstraints);

        fileOrFolder.add(jRBFolder);
        if (!prefs.getBoolean("FILE_OR_FOLDER", true)){
            jRBFolder.isSelected();
        }
        jRBFolder.setText("Folder");
        jRBFolder.setName("folder"); // NOI18N
        jRBFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBFolderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        SelectFilePanel.add(jRBFolder, gridBagConstraints);
        SelectFilePanel.add(filler1, new java.awt.GridBagConstraints());

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(outputTextPane);

        licenseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC0 - No rights reserved", "BY - Attribution", "BY_SA - Attribution - ShareAlike", "BY_ND - Attribution - NoDerivatives", "BY_NC - Attribution - NonCommercial", "BY_NC_SA - Attribution - NonCommercial - ShareAlike", "BY_NC_ND - Attribution - NonCommercial - NoDerivatives" }));
        licenseComboBox.setToolTipText("");
        licenseComboBox.setSelectedIndex(prefs.getInt("LICENSE", 0));
        licenseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenseComboBoxActionPerformed(evt);
            }
        });

        licenseLabel.setText("Licensing type:");

        licenseHelpIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/37171Small.png"))); // NOI18N
        licenseHelpIcon.setLabelFor(licenseLabel);
        licenseHelpIcon.setToolTipText("A link to a description of the different licensing types");
        licenseHelpIcon.setAlignmentY(0.1F);
        licenseHelpIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                licenseHelpIconMouseClicked(evt);
            }
        });

        warningLabel.setText("Warnings will not prevent a file from being uploaded. Errors will.");

        javax.swing.GroupLayout UploadFilesPanelLayout = new javax.swing.GroupLayout(UploadFilesPanel);
        UploadFilesPanel.setLayout(UploadFilesPanelLayout);
        UploadFilesPanelLayout.setHorizontalGroup(
            UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UploadFilesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UploadFilesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UploadFilesPanelLayout.createSequentialGroup()
                                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UploadFilesPanelLayout.createSequentialGroup()
                                .addGroup(UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(licenseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(UploadFilesPanelLayout.createSequentialGroup()
                                        .addComponent(licenseLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(licenseHelpIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(185, 185, 185))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UploadFilesPanelLayout.createSequentialGroup()
                        .addGroup(UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(warningLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(UploadFilesPanelLayout.createSequentialGroup()
                                .addComponent(SelectFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CsvNotificationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        UploadFilesPanelLayout.setVerticalGroup(
            UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UploadFilesPanelLayout.createSequentialGroup()
                .addGroup(UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UploadFilesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SelectFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CsvNotificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(licenseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(licenseHelpIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(licenseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(warningLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UploadFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(uploadButton))
                .addGap(9, 9, 9))
        );

        jTabbedPane1.addTab("Upload Files", UploadFilesPanel);

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Preferences", SettingsPanel);

        helpTextPane.setEditable(false);
        helpTextPane.setColumns(20);
        helpTextPane.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        helpTextPane.setLineWrap(true);
        helpTextPane.setRows(5);
        helpTextPane.setWrapStyleWord(true);
        try { helpTextPane.setText(Help.getHelpText()); }
        catch (Exception ex) { System.out.println(ex); }
        jScrollPane3.setViewportView(helpTextPane);

        javax.swing.GroupLayout HelpPanelLayout = new javax.swing.GroupLayout(HelpPanel);
        HelpPanel.setLayout(HelpPanelLayout);
        HelpPanelLayout.setHorizontalGroup(
            HelpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        HelpPanelLayout.setVerticalGroup(
            HelpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Help", HelpPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenButtonActionPerformed
        fileChooserUpload.setVisible(rootPaneCheckingEnabled);
        int returnValue = fileChooserUpload.showOpenDialog(null);
        if (returnValue == fileChooserUpload.APPROVE_OPTION)
        {
            selectedFile = fileChooserUpload.getSelectedFile();
            System.out.println(selectedFile.getName());
            String absolutePath = selectedFile.getAbsolutePath();
            fileLocationTextArea.setText( absolutePath );
			prefs.put("LAST_OUTPUT_DIR", absolutePath);
        }
    }//GEN-LAST:event_fileOpenButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        try
        {	
			if (folder == false)
			{
				PostPopulationFrequencies ppf = new PostPopulationFrequencies(
						gtRegistry, estEntity, null);
				ppf.setFile(selectedFile);
				ppf.call();
			}
			else if (folder == true)
			{
				BatchUploader.uploadFiles(selectedFile.toString());
			}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_uploadButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jRBFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBFileActionPerformed
		setFile();   // see below
    }//GEN-LAST:event_jRBFileActionPerformed

    private void jRBFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBFolderActionPerformed
		setFolder(); // see below
    }//GEN-LAST:event_jRBFolderActionPerformed

    private void licenseHelpIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_licenseHelpIconMouseClicked
		try {
			URI licenseTypes = new URI("https://creativecommons.org/share-your-work/licensing-types-examples/");
			openWebpage(licenseTypes);
		} catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_licenseHelpIconMouseClicked

    private void licenseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenseComboBoxActionPerformed
		prefs.putInt("LICENSE", licenseComboBox.getSelectedIndex());
    }//GEN-LAST:event_licenseComboBoxActionPerformed

    private void GTRegistryCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GTRegistryCloseButtonActionPerformed
        dispose();
    }//GEN-LAST:event_GTRegistryCloseButtonActionPerformed

	// open links for help buttons
	public static void openWebpage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// settings for uploading a file, used in custom code for jRBFile
	public void setFile() {
		// set file selection
		fileChooserUpload.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		// visual cues
		fileOpenButton.setText("Select File");
		CsvNotificationLabel.setText("CSV files only.");
		
		// save choice to preferences
		prefs.putBoolean("FILE_OR_FOLDER", true);
		
		// so uploader function knows whether it's a file or folder
		folder = false;
	}
	
	// settings for uploading a folder, used in custom code for jRBFile
	public void setFolder() {
		// set folder selection
		fileChooserUpload.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		// visual cues
		fileOpenButton.setText("Select Folder");
		CsvNotificationLabel.setText("Only CSV files will be processed, other files and subfolders will be ignored.");
		
		// save choice to preferences
		prefs.putBoolean("FILE_OR_FOLDER", false);
		
		// so uploader function knows whether it's a file or folder
		folder = true;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PhycusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PhycusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PhycusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PhycusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PhycusGui().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CsvNotificationLabel;
    private javax.swing.JButton GTRegistryCloseButton;
    private javax.swing.JButton GTRegistryEnterButton;
    private javax.swing.JLabel GTRegistryInstructions1;
    private javax.swing.JLabel GTRegistryInstructions2;
    private javax.swing.JFrame GTRegistryPopupFrame;
    private javax.swing.JTextField GTResgistryTextField;
    private javax.swing.JPanel HelpPanel;
    private javax.swing.JPanel SelectFilePanel;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JPanel UploadFilesPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JFileChooser fileChooserUpload;
    private javax.swing.JTextArea fileLocationTextArea;
    private javax.swing.JButton fileOpenButton;
    private javax.swing.ButtonGroup fileOrFolder;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextArea helpTextPane;
    private javax.swing.JRadioButton jRBFile;
    private javax.swing.JRadioButton jRBFolder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JComboBox<String> licenseComboBox;
    private javax.swing.JLabel licenseHelpIcon;
    private javax.swing.JLabel licenseLabel;
    public static javax.swing.JTextPane outputTextPane;
    private javax.swing.JButton uploadButton;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
