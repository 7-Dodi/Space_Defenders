package mygame.Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameWin{
	private Image background;
	private int altura, largura;
	SomGame music = new SomGame();
	
	public GameWin () {
		ImageIcon gameWin = new ImageIcon ("Imagens//YouWin.jpg");
		background = gameWin.getImage();
		
		altura = background.getHeight(null);
		largura = background.getWidth(null);
	}

	public Image getBackground() {
		return background;
	}
	
}
