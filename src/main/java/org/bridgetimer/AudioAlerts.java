package org.bridgetimer;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioAlerts {
	
	private static final String ROOT = "src/main/resources/wav/";
	
	public enum AlertType {
		ROUND_START,
		ROUND_END,
		END_OF_ROUND_WARNING
	}

	public static void main(String[] args) {
		File file = new File(".");
		System.out.println(file.getAbsolutePath());
		playAlert(AlertType.ROUND_START);
	}
	
	public static void playAlert(AlertType alertType) {
		try
		{
			Clip clip = AudioSystem.getClip();
			switch (alertType) {
			case ROUND_START: clip.open(AudioSystem.getAudioInputStream(new File(ROOT + "round_start.wav"))); break;
			case ROUND_END: clip.open(AudioSystem.getAudioInputStream(new File(ROOT + "round_end.wav"))); break;
			case END_OF_ROUND_WARNING:clip.open(AudioSystem.getAudioInputStream(new File(ROOT + "end_of_round_warning.wav"))) ;
			}
			clip.setFramePosition(0);
			clip.start();
		}
		catch (Exception exc)
		{
			exc.printStackTrace(System.out);
		}
	}
}
