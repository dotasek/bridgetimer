package org.bridgetimer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements ActionListener{
	
	JToggleButton playPause = new JToggleButton("Play/Pause");
	CardLayout cardLayout;
	JPanel cardPanel;
	
	private static final String SETTINGS = "settings";
	private static final String PLAY = "play";
	
	private PlayPanel playPanel;
	
	private Settings settings;
	
	Timer timer = null;
	
	public MainPanel() {
		super(new BorderLayout());
		settings = new Settings();
		
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		this.add(cardPanel, BorderLayout.CENTER);
		SettingsPanel settingsPanel = new SettingsPanel(settings);
		settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
		cardPanel.add(settingsPanel, SETTINGS);
		
		playPanel = new PlayPanel(settings);
		playPanel.setLayout(new BoxLayout(playPanel, BoxLayout.Y_AXIS));
		cardPanel.add(playPanel, PLAY);
		
		playPause.addActionListener(this);
		this.add(playPause, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playPause) {
			if (playPause.isSelected()) {
				
				cardLayout.show(cardPanel, PLAY); 
				
				int rounds = 3;
				long restTime = 10000;
				long roundTime =  30000;
				long warningTime = 10000;
				
			//	long totalDuration = rounds * (roundTime + restTime);
				timer = new Timer();
				playPanel.updateTimer();
				timer.schedule(new ClockUpdateTask(playPanel), 0l, 1000l);
				timer.schedule(new StartRoundTask(playPanel, settings.lengthOfRound), 0l, settings.lengthOfRound + restTime);
				timer.schedule(new WarningTask(playPanel), settings.lengthOfRound - warningTime, settings.lengthOfRound + restTime);
				timer.schedule(new StartRestTask(playPanel, restTime), settings.lengthOfRound, settings.lengthOfRound + restTime);
			} else {
				timer.cancel();
				timer.purge();
				cardLayout.show(cardPanel, SETTINGS);
			}	
		}
	}
}
