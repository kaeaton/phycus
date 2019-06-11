/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dash.freq.view;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextPane;
import org.dash.freq.controller.UploadTextManager;

/**
 *
 * @author katrinaeaton
 */
public class MainTextObserver implements java.util.Observer{
	public MainTextObserver(UploadTextManager sub)
	{

	}
	
	@Override
	public void update(Observable sub, Object arg) {
		List text = new ArrayList();
		text = (List) arg;
		
		Color color;
		try {
			Field field = Class.forName("java.awt.Color").getField(text.get(1).toString());
			color = (Color)field.get(null);
		} catch (Exception e) {
			color = null; // Not defined
		}
		
		AppendText.appendToPane(PhycusGui.outputTextPane, text.get(0).toString(), color);
		AppendText.appendToPane(PhycusGui.outputTextPane, System.lineSeparator(), Color.BLACK);
	}
}
