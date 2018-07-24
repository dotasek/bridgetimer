package org.bridgetimer;

import java.awt.Color;
import java.util.TimerTask;

import org.bridgetimer.AudioAlerts.AlertType;

public class StartRoundTask extends TimerTask{

	private final PlayPanel playPanel;
	
	private final long duration;
	
	private int round;
	
	public StartRoundTask(PlayPanel playPanel, long duration) {
		this.playPanel = playPanel;
		this.duration = duration;
		this.round = 0;
	}
	
	@Override
	public void run() {
		round++;
		playPanel.setRoundText("Round " + round);
		playPanel.setTimerColor(Color.GREEN);
		playPanel.roundStart(duration);
		AudioAlerts.playAlert(AlertType.ROUND_START);
	}
}
