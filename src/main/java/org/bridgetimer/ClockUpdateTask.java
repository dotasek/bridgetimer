package org.bridgetimer;

import java.util.TimerTask;

public class ClockUpdateTask extends TimerTask{

	private final PlayPanel playPanel;

	public ClockUpdateTask(PlayPanel playPanel) {
		this.playPanel = playPanel;
	
	}
	
	@Override
	public void run() {
		playPanel.updateTimer();
	}
}
