package org.bridgetimer;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayPanel extends JPanel {
	
	SimpleDateFormat formatter;
	JTextField timerField;
	
	public PlayPanel() {
		formatter = new SimpleDateFormat("mm:ss");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		timerField = new JTextField();
		timerField.setFont(font);
		timerField.setBackground(Color.BLACK);
		timerField.setForeground(Color.WHITE);
		this.add(timerField);
	}
	
	public void updateTimer(long endTime, long warnTime) {
		long timeRemaining = endTime - System.currentTimeMillis();
		
		if (timeRemaining < warnTime)
		{
			timerField.setForeground(Color.YELLOW);
		} else 
		{
			timerField.setForeground(Color.GREEN);
		}
		
		System.out.println(timeRemaining);
		
		if (timeRemaining < 0) {
			java.awt.Toolkit.getDefaultToolkit().beep();
		}
		
		Date date = new Date(timeRemaining);
		
		timerField.setText(formatter.format(date));
	}
	
}
