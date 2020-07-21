// /*
//  *
//  */
// package org.dash.freq.utilities;

// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileWriter;
// import java.time.format.DateTimeFormatter;
// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.util.prefs.Preferences;

// import org.apache.commons.io.FileUtils;

// /**
//  *
//  * @author katrinaeaton
//  */
// public class CreateReceipt 
// {
	
// 	// access to prefs
// 	// public Preferences prefs = Preferences.userNodeForPackage(PhycusGui.class);
	
// 	public CreateReceipt(){ }
	
// 	public String fileName(String fileName) 
//     {
//         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH-mm-ss");

//         LocalDate dateStamp = LocalDate.now();
//         String timeStamp = LocalTime.now().format(dtf).toString();
		
// 		// create receipt file name from source file name
//         String receiptFileName = fileName.substring(0, (fileName.length()-3)) + "txt";

//         System.out.println(receiptFileName);
        
//         return fileName;
//     }
    
//     public void writeToFile(String fileName)
//     {
// 		if (prefs.getBoolean("PHY_RECEIPT", true))
// 		{
			
// 		}
		
		
		
		
		
//         try {
// //            String text = whichTextArea.get(dataType).getText();
// //            String filePath = fileName(locus, dataType);

// //            File destinationFile = new File(fileName(locus, version, dataType));

//             // if file doesnt exists, then create it
// //            if (!destinationFile.exists()) {
// //                destinationFile.createNewFile();
// //            }

// //            FileWriter fw = new FileWriter(destinationFile.getAbsoluteFile());
// //            BufferedWriter bw = new BufferedWriter(fw);
// //
// //            bw.write(text);
// //            bw.close();
//         } catch (Exception ex) {
//             System.out.println(ex);
//         }
//     }
// }
