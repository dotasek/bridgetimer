package org.bridgetimer;

import java.util.TimerTask;

public class PlayTimerTask extends TimerTask{

	private final PlayPanel playPanel;
	private final long endTime;
	private final long warnTime;
	
	
	public PlayTimerTask(PlayPanel playPanel, long endTime, long warnTime) {
		this.playPanel = playPanel;
		this.endTime = endTime;
		this.warnTime = warnTime;
	}
	
	@Override
	public void run() {
		playPanel.updateTimer(endTime, warnTime);
	}
}
