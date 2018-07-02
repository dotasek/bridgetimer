package org.bridgetimer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

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
	
	Timer timer;
	
	public MainPanel() {
		super(new BorderLayout());
		
		timer = new Timer();
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		this.add(cardPanel, BorderLayout.CENTER);
		
		cardPanel.add(new SettingsPanel(), SETTINGS);
		
		playPanel = new PlayPanel();
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
				
				long totalDuration = rounds * (roundTime + restTime);
				
				timer.schedule(new ClockUpdateTask(playPanel), 0l, 1000l);
				timer.schedule(new StartRoundTask(playPanel, roundTime), 0l, roundTime + restTime);
				timer.schedule(new WarningTask(playPanel), roundTime - warningTime, roundTime + restTime);
				timer.schedule(new StartRestTask(playPanel, restTime), roundTime, roundTime + restTime);
			} else {
				timer.cancel();
				cardLayout.show(cardPanel, SETTINGS);
				
			}	
		}
	}
}
