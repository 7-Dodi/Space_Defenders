package mygame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import mygame.Modelo.Fase;
import mygame.Modelo.*;

public class WindowContainer extends JFrame {
	private static final int HIGHT = 1024;
	private static final int WIDTH = 720;
	private static final String NAME = "Space Defenders";
	SomGame music = new SomGame();
	
	public WindowContainer() {
		add(new MenuGame());
		setTitle(NAME);
		setSize(HIGHT,WIDTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
		addKeyListener(new TecladoAdapt());
		
		try {
			music.tocarAudio("MenuGame.wav");
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WindowContainer(boolean isVisivel) {
		if(isVisivel == true) {
			add(new Fase());
			setTitle(NAME);
			setSize(HIGHT,WIDTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			this.setResizable(false);
			setVisible(true);	
		}
	}
	
	private class TecladoAdapt extends KeyAdapter{
		@Override
		public void keyPressed (KeyEvent tecla){
			int cody = tecla.getKeyCode();
			if(cody == KeyEvent.VK_ENTER) {
				new WindowContainer(true);
				music.pararAudio();
			}
		}
	}
	
	public static void main (String[] Args) {
		
		new WindowContainer();
	}
}
