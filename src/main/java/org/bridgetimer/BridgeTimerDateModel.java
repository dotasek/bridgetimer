package org.bridgetimer;

import java.util.Calendar;
import java.util.Date;

import javax.swing.SpinnerDateModel;

public class BridgeTimerDateModel extends SpinnerDateModel {
	public BridgeTimerDateModel(Date defaultDate, Date minDate, Date maxDate, int minute) {
		super(defaultDate, minDate, maxDate, minute);
	}

	@Override
    public Object getPreviousValue() {
      
        Date value = (Date) super.getValue();
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate());
        cal.add(Calendar.MINUTE, -1);
        value = cal.getTime();
        System.err.println("Decrement");
        return value;
    }

    @Override
    public Object getNextValue() {
    	  Date value = (Date) super.getValue();
          Calendar cal = Calendar.getInstance();
          cal.setTime(getDate());
          cal.add(Calendar.MINUTE, 1);
          value = cal.getTime();
        
         System.err.println("Increment");

        return value;
    }
}
