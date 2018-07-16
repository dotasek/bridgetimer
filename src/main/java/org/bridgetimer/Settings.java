package org.bridgetimer;

public class Settings {
	public int numberOfRounds;
	public long lengthOfRound;
	public long warningTime;
	public long breakTime;
	
	public Settings() {
		numberOfRounds = 5;
		lengthOfRound = 30000;
		warningTime = 10000;
		breakTime = 20000;
	}
}
