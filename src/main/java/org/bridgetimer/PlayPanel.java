package org.bridgetimer;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayPanel extends JPanel {
	
	SimpleDateFormat formatter;
	JTextField roundField;
	JTextField timerField;
	
	long startTime;
	//long duration;
	
	Settings settings;

	
	public PlayPanel(Settings settings) {
		
		this.settings = settings;
		
		formatter = new SimpleDateFormat("mm:ss");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		
		roundField = new JTextField();
		roundField.setFont(font);
		roundField.setBackground(Color.BLACK);
		roundField.setForeground(Color.WHITE);
		this.add(roundField);
		
		timerField = new JTextField();
		timerField.setFont(font);
		timerField.setBackground(Color.BLACK);
		timerField.setForeground(Color.WHITE);
		this.add(timerField);
	}
	
	public void setRoundText(String text) {
		roundField.setText(text);
	}
	
	public void setTimerColor(Color color)
	{
		timerField.setForeground(color);
	}
	
	public void roundStart(long duration) {
		this.startTime = System.currentTimeMillis();
	}
	
	public void updateTimer() { 
			long timeRemaining = startTime + settings.lengthOfRound - System.currentTimeMillis();
			System.out.println(timeRemaining);
			Date date = new Date(timeRemaining);
			timerField.setText(formatter.format(date));
	}
	
}
