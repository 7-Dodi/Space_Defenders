package mygame.Modelo;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SomGame {
	
	private Clip clip;
	
	public void tocarAudio(String music) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("Audio//"+music);
		AudioInputStream audio = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audio);
		
		clip.stop();
		clip.start();
		
		if(music.equals("MenuGame.wav")) {
			clip.loop(clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public boolean pararAudio() {
		this.clip.stop();
		return true;
	}
}
