package org.bridgetimer;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsPanel extends JPanel implements ChangeListener{
	
	public static final int DEFAULT_ROUND_TIME = 10 * 60;
	public static final int DEFAULT_WARNING_TIME = 2 * 60;
	public static final int MAX_ROUND_TIME = 60 * 60;
	
	
	
	public SettingsPanel(Settings settings) {
		super();
		//SpinnerDateModel lengthOfRoundModel = new SpinnerDateModel(0l, new Date(0l), new Date(MAX_ROUND_TIME * 1000), Calendar.MINUTE);
		
		//JSpinner lengthOfRoundSpinner = new JSpinner(lengthOfRoundModel);
		
	}



	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
