package org.dash.freq.validations;

// import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.dash.freq.validations.IonCheck;
 
class IonTest{

	private final IonCheck ionCheck = new IonCheck();
	private final String[] ionPositiveTestArray = {"3553", "NMDP-National Marrow Donor Program/Be The Match"};
	private final String[] ionNegativeTestArray = {"", ""};
	
	@Test
	@DisplayName("IonCheck positive test")
	void objectReturnsArrayOnMatch() {
 		// assertEquals(2, ionCheck.checkIon("3553").length, "NMDP ION match array length");
 		// assertArrayEquals(ionPositiveTestArray, ionCheck.checkIon("3553"), "Found NMDP ION match array");
 		// assertEquals("3553", ionCheck.checkIon("3553")[0], "Found NMDP ION match");
 		// assertEquals("NMDP-National Marrow Donor Program/Be The Match", ionCheck.checkIon("3553")[1], "Found NMDP name match");
	}

	@Test
	@DisplayName("IonCheck negative test")
	void objectReturnsNullOnMatch() {
 		// assertArrayEquals(ionNegativeTestArray, ionCheck.checkIon("0000"), "Found NMDP Ion Match Array");
 		// assertEquals("", ionCheck.checkIon("0000")[0], "Returned empty ION on bad data");
 		// assertEquals("", ionCheck.checkIon("0000")[1], "Returned empty name on bad data");
	}
}

