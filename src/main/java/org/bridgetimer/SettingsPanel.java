package org.bridgetimer;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsPanel extends JPanel implements ChangeListener{
	
	public static final int DEFAULT_ROUND_TIME = 10 * 60;
	public static final int DEFAULT_WARNING_TIME = 2 * 60;
	public static final int MAX_ROUND_TIME = 60 * 60;
	
	Settings settings;
	
	JSpinner lengthOfRoundSpinner;
	
	public SettingsPanel(Settings settings) {
		super();
		this.settings = settings;
		Date minDate = new Date(0);
		Date maxDate = new Date(MAX_ROUND_TIME * 1000);
		Date defaultDate = new Date(DEFAULT_ROUND_TIME * 1000);
		BridgeTimerDateModel lengthOfRoundModel = new BridgeTimerDateModel(defaultDate, minDate, maxDate,  Calendar.MINUTE);
		lengthOfRoundSpinner = new JSpinner(lengthOfRoundModel);
		//  ((DateEditor) lengthOfRoundSpinner.getEditor()).getFormat().applyPattern("mm:ss");
		lengthOfRoundSpinner.addChangeListener(this);
		this.add(lengthOfRoundSpinner);
	}



	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == lengthOfRoundSpinner) {
			this.settings.lengthOfRound = ((Date)lengthOfRoundSpinner.getValue()).getTime();
		}
	}
}
