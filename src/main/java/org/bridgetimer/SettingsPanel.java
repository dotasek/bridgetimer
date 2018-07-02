package org.bridgetimer;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

public class SettingsPanel extends JPanel {
	
	public static final int DEFAULT_ROUND_TIME = 10 * 60;
	public static final int DEFAULT_WARNING_TIME = 2 * 60;
	public static final int MAX_ROUND_TIME = 60 * 60;
	
	public SettingsPanel() {
		super();
		
		
		
		SpinnerNumberModel model = new SpinnerNumberModel(DEFAULT_ROUND_TIME , 0, MAX_ROUND_TIME, 1);
	}
}
