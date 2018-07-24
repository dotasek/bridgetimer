package org.bridgetimer;

import java.awt.Color;
import java.util.TimerTask;

import org.bridgetimer.AudioAlerts.AlertType;

public class WarningTask extends TimerTask{

	private final PlayPanel playPanel;
	
	public WarningTask(PlayPanel playPanel) {
		this.playPanel = playPanel;
	}
	
	@Override
	public void run() {
		playPanel.setTimerColor(Color.YELLOW);
		AudioAlerts.playAlert(AlertType.END_OF_ROUND_WARNING);
	}
}
