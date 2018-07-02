package org.bridgetimer;

import java.awt.Color;
import java.util.TimerTask;

public class StartRestTask extends TimerTask{

	private final PlayPanel playPanel;

	private final Long duration;
	
	public StartRestTask(PlayPanel playPanel, long duration) {
		this.playPanel = playPanel;
		this.duration = duration;
	}
	
	@Override
	public void run() {
		playPanel.setRoundText("Break");
		playPanel.roundStart(duration);
		playPanel.setTimerColor(Color.RED);
	}
}
