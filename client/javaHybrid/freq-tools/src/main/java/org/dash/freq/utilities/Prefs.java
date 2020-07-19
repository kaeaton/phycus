package org.dash.freq.utilities;

import java.util.prefs.Preferences;

public class Prefs {

	private static final Preferences preferences = Preferences.userNodeForPackage(Prefs.class);

	private static final String DEFAULT_DOCS_PATH = (System.getProperty("user.home") 
				+ System.getProperty("file.separator") + "Documents"); 
	private static final String DEFAULT_DB_URL = "http://localhost:8080";



	public Prefs() { }

	/* for which tab is open in the GUI */
	public static int getCurrentTab() {
		System.out.println("Get current tab: which tab are we storing? " 
							+ preferences.getInt("PHY_SELECTED_TAB", 0));
		return preferences.getInt("PHY_SELECTED_TAB", 0);
		
	}

	public static void setCurrentTab(int currentTab) {
		preferences.putInt("PHY_SELECTED_TAB", currentTab);
		System.out.println("Set current tab: which tab is selected? " 
							+ preferences.getInt("PHY_SELECTED_TAB", 0));
	}

	/* for custom save paths */
	// most recent upload folder
	public static String getUploadPath() {
		String uploadPath = preferences.get("PHY_INPUT_DIR", DEFAULT_DOCS_PATH);
		return uploadPath;
	}

	public static void setUploadPath(String newDocsPath) {
		preferences.put("PHY_INPUT_DIR", newDocsPath);
	}

	// custom receipt folder
	public static String getCustomReceiptPath() {
		String receiptPath = preferences.get("PHY_RECEIPT_CUSTOM_FOLDER", DEFAULT_DOCS_PATH);
		return receiptPath;
	}

	public static void setCustomReceiptPath(String newReceiptsPath) {
		preferences.put("PHY_RECEIPT_CUSTOM_FOLDER", newReceiptsPath);
		preferences.putBoolean("PHY_RECEIPT_CUSTOM", true);

		System.out.println("Set custom receipt path: Is there a custom receipt path? " 
							+ preferences.getBoolean("PHY_RECEIPT_CUSTOM", false));
	}

	public static void resetCustomReceiptPath() {
		try {
			preferences.remove("PHY_RECEIPT_CUSTOM_FOLDER");
		} catch(Exception ex) { System.out.println("Error deleting the custom receipt node: " + ex); }

		preferences.putBoolean("PHY_RECEIPT_CUSTOM", false);
		System.out.println("Reset custom receipt path: Is there a custom receipt path? " 
							+ preferences.getBoolean("PHY_RECEIPT_CUSTOM", false));

	}

	// sanity check so program knows which path to use
	public static Boolean isThereACustomReceiptPath() {
		Boolean customReceipt = preferences.getBoolean("PHY_RECEIPT_CUSTOM", false);

		System.out.println("Is there a custom receipt path? " + customReceipt);
		return customReceipt;
	}

	/* for which licensing option is selected */
	public static int getLicensingSelected() {
		int uploadPath = preferences.getInt("PHY_LICENSE", 0);
		return uploadPath;
	}

	public static void setLicensingSelected(int selectedItemLocation) {
		preferences.putInt("PHY_LICENSE", selectedItemLocation);
	}

	/* for what, if any, ION assigned to the facility */
	// ION facility number
	public static String getIonNumber() {
		String ionNumber = preferences.get("PHY_ION_NUMBER", "");
		return ionNumber;
	}

	public static void setIonNumber(String ionNumber) {
		preferences.put("PHY_ION_NUMBER", ionNumber);
		preferences.putBoolean("PHY_ION", true);
		System.out.println("Setting an ION: Is there an ION? (This should return true): " 
							+ preferences.getBoolean("PHY_ION", false));
	}

	// ION facility name
	public static String getIonFacility() {
		String ionNumber = preferences.get("PHY_ION_NAME", "");
		return ionNumber;
	}

	public static void setIonFacility(String ionName) {
		preferences.put("PHY_ION_NAME", ionName);
	}

	public static void resetIon() {
		try {
			preferences.remove("PHY_ION_NUMBER");
			preferences.remove("PHY_ION_NAME");
		} catch(Exception ex) { System.out.println("Error deleting the ION nodes: " + ex); }

		// update is there an ION
		preferences.putBoolean("PHY_ION", false);
		System.out.println("Reset ION: Is there an ION? (This should return false): " 
							+ preferences.getBoolean("PHY_ION", true));
	}

	/* for reporting options */
	public static Boolean getVerboseReportingSetting() {
		Boolean verboseReporting = preferences.getBoolean("PHY_VERBOSE_REPORTING", false);
		return verboseReporting;
	}

	public static void setVerboseReportingSetting(Boolean verboseReporting) {
		preferences.putBoolean("PHY_VERBOSE_REPORTING", verboseReporting);
		System.out.println("Verbose Reporting Setting: " + preferences.getBoolean("PHY_VERBOSE_REPORTING", false));
	}

	/* for advanced database settings */
	public static String getDatabaseUrl() {
		String databaseUrl = preferences.get("PHY_DB_URL", DEFAULT_DB_URL);
		return databaseUrl;
	}

	public static void setDatabaseUrl(String newDatabaseUrl) {
		preferences.put("PHY_DB_URL", newDatabaseUrl);
	}

	public static void resetDatabaseUrl() {
		try {
			preferences.remove("PHY_DB_URL");
		} catch(Exception ex) { System.out.println("Error deleting the custom DB URL node: " + ex); }
	}
}