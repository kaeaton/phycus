/*

    Copyright (c) 2014-2015 National Marrow Donor Program (NMDP)

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.gnu.org/licenses/lgpl.html

 */
package org.dash.freq.controller;

import io.swagger.client.ApiException;
import io.swagger.client.model.HaplotypeFrequencyData;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.dash.freq.view.AppendText;
import org.dash.freq.view.PhycusGui;

public class DataChecks {

	public BigDecimal freqTotal;

	public DataChecks() {

	}
	
	// are all the population names the same?
	public boolean raceCheck(String raceFirst, String race, List<Integer> errorCodes) {
		boolean flag = true;

		if (!race.equals(raceFirst)) {
			flag = false;
			errorCodes.add(3);
		}
		return flag;
	}

	public boolean populationDataCheck(BufferedReader reader, 
										List<Integer> errorCodeList,
										List<Integer> warningCodeList
										) throws IOException, ApiException {
		// while loop variables
		String row;
		String[] columns;
		boolean flag = true;

		// skip header line
		row = reader.readLine();
		System.out.println(row);
		
		// read second line
		row = reader.readLine();
		System.out.println(row);

		columns = row.split(",");

		// list to collect error codes
//		List<Integer> errorCodeList = new ArrayList<>();

		// frequency totals up to 1.0000
		freqTotal = new BigDecimal(columns[1]);
		
		// resolution of the total frequencies & target frequency
		int scale = 4;
		BigDecimal targetFrequency = new BigDecimal(1)
				.setScale(scale, BigDecimal.ROUND_HALF_UP);

		// confirm populations are all the same
//		String raceFirst = columns[0];

		// read through the file, consolodate the data for checking
		while ((row = reader.readLine()) != null) 
		{
			// break the row down into useable pieces
			columns = row.split(",");
//			String race = columns[0];
			String haplotype = columns[0];
			BigDecimal frequency = new BigDecimal(columns[1]);

			// run the population check only while flag equals true
			// This is so it only adds one mismatch to the errorCode list
//			if (flag == true)
//			{
//				flag = raceCheck(raceFirst, race, errorCodeList);
//			}

			// add the current line's frequency to the total frequency
			freqTotal = frequency.add(freqTotal);
//			System.out.println("While-loop frequency total: " + freqTotal);
		}
		
		// does the frequency fall withing the target range?
		System.out.println("Frequency total: " 
				+ freqTotal.setScale(scale, BigDecimal.ROUND_HALF_UP));
		if (!freqTotal.setScale(scale, BigDecimal.ROUND_HALF_UP)
				.equals(targetFrequency)) 
		{
//			flag = false;
			warningCodeList.add(2);
		}
		
		// if there are warnings, print out the warnings to the gui
		if (!warningCodeList.isEmpty()) 
		{
			for (int x:warningCodeList)
			{
				System.out.println("* " + ErrorCodes.WarningList().get(x));
				AppendText.appendToPane(PhycusGui.outputTextPane, "Warnings: ", Color.BLACK);
				AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
				AppendText.appendToPane(PhycusGui.outputTextPane, "* " + ErrorCodes.WarningList().get(x), Color.BLACK);
				AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
				if (x == 2)
				{
					AppendText.appendToPane(PhycusGui.outputTextPane, ("  - Frequency total: " + freqTotal), Color.BLACK);
					AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
AppendText.appendToPane(PhycusGui.outputTextPane, ("  - Frequency sum will be normalized to 1.0"), Color.BLACK);
					AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
				}
			}
		}
		
		// if there are errors, print out the errors to the gui
		if (!errorCodeList.isEmpty()) 
		{
			for (int x:errorCodeList)
			{
				System.out.println("* " + ErrorCodes.ErrorList().get(x));
				AppendText.appendToPane(PhycusGui.outputTextPane, "Errors: ", Color.RED);
				AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
				AppendText.appendToPane(PhycusGui.outputTextPane, "* " + ErrorCodes.ErrorList().get(x), Color.RED);
				AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
//				if (x == 2)
//				{
//					AppendText.appendToPane(PhycusGui.outputTextPane, ("  - Frequency totals: " + freqTotal), Color.RED);
//					AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
//
//				}
			}
		}

		return flag;
	}
	
	public BigDecimal getTotal ()
	{
		return freqTotal;
	}
}
