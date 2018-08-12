package org.bridgetimer;

import java.time.Duration;
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
		Date minDate = new Date(Duration.ofHours(5).toMillis() + Duration.ofMinutes(1).toMillis());
		//System.out.println(minDate.getTime());
		
		Date maxDate = new Date(Duration.ofHours(6).toMillis());
		//System.out.println(maxDate.getTime());
		//Date defaultDate = new Date(DEFAULT_ROUND_TIME * 1000);
		
		Date date = new Date(Duration.ofHours(5).toMillis() + DEFAULT_ROUND_TIME * 1000); 
		//System.out.println(date.getTime());
		
		
		SpinnerDateModel sm = new SpinnerDateModel(date, minDate, maxDate, Calendar.MINUTE); 
		//sm.setStart(minDate);
		lengthOfRoundSpinner = new javax.swing.JSpinner(sm); JSpinner.DateEditor de = new
		JSpinner.DateEditor(lengthOfRoundSpinner, "mm:ss"); lengthOfRoundSpinner.setEditor(de);
		System.out.println("Model time: " + ((Date)lengthOfRoundSpinner.getValue()).getTime());
		
		//BridgeTimerDateModel lengthOfRoundModel = new BridgeTimerDateModel(defaultDate, minDate, maxDate,  Calendar.MINUTE);
		//lengthOfRoundSpinner = new JSpinner(lengthOfRoundModel);
		//Hello Nat
		//DateEditor dateEditor = (DateEditor) lengthOfRoundSpinner.getEditor();
		//dateEditor.set
		//  ((DateEditor) lengthOfRoundSpinner.getEditor()).getFormat().applyPattern("mm:ss");
		lengthOfRoundSpinner.addChangeListener(this);
		this.add(lengthOfRoundSpinner);
	}



	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == lengthOfRoundSpinner) {
			this.settings.lengthOfRound = ((Date)lengthOfRoundSpinner.getValue()).getTime() - Duration.ofHours(5).toMillis();
			System.out.println(this.settings.lengthOfRound);
		}
	}
}
