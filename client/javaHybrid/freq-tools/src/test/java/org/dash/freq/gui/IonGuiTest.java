package org.dash.freq.gui;

import javax.swing.*;

import manifold.ext.rt.api.Jailbreak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import org.dash.freq.gui.uploadTab.*;
import org.dash.freq.utilities.Prefs;
 
class IonGuiTest{

	String noIonUploadLabel = ("<html><body>Issuing Organization Number (ION) not set.<br>"
								+ "If you have one, it may be set in options.</body></html>");

	@Disabled
	@Test
    public void shouldReturnGivenValueUsingBDDSemantics() {

		@Jailbreak IonPanel uploadIonPanel = new IonPanel();

		//given
		Prefs prefsMock = mock(Prefs.class);
		given(prefsMock.getIonNumber()).willReturn("");
		given(prefsMock.getIonFacility()).willReturn("");
		// given(prefsMock.getIonNumber().willReturn("3553"));
		// given(prefsMock.getIonNumber().willReturn("3553"));

		//when
		String emptyIonResponse = uploadIonPanel.whichLabel().getText();

		//then
		assertEquals(emptyIonResponse, noIonUploadLabel);
		// assertEquals(emptyIonResponse, prefsMock.getIonFacility());
	}

	// private final IonCheck ionCheck = new IonCheck();
	private final String[] ionPositiveTestArray = {"3553", "NMDP-National Marrow Donor Program/Be The Match"};
	private final String[] ionNegativeTestArray = {"", ""};
	
	@Test
	@DisplayName("IonCheck.java positive test - requires internet to test")
	void objectReturnsArrayOnMatch() {
		// IonPanel uploadIonPanel = new IonPanel();
		// String emptyIonResponse = uploadIonPanel.jailbreak().whichLabel().getText();


 		// assertEquals(2, ionCheck.checkIon("3553").length, "NMDP ION match array length");
 		// assertArrayEquals(ionPositiveTestArray, ionCheck.checkIon("3553"), "Found NMDP ION match array");
 		// assertEquals("3553", ionCheck.checkIon("3553")[0], "Found NMDP ION match");
 		// assertEquals("NMDP-National Marrow Donor Program/Be The Match", ionCheck.checkIon("3553")[1], "Found NMDP name match");
	}

	@Test
	@DisplayName("IonCheck.java negative test -  require internet to test")
	void objectReturnsNullOnMatch() {
 		// assertArrayEquals(ionNegativeTestArray, ionCheck.checkIon("0000"), "Found NMDP Ion Match Array");
 		// assertEquals("", ionCheck.checkIon("0000")[0], "Returned empty ION on bad data");
 		// assertEquals("", ionCheck.checkIon("0000")[1], "Returned empty name on bad data");
	}
}

