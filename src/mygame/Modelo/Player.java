package mygame.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Player {
	private int x, y;
	private int dx, dy;
	private int altura, largura;
	private Image player;
	private boolean isVisivel;
	private List <Tiro> tiros;
	
	
	public  Player() {
		this.x = 100;
		this.y = 100;
		isVisivel = true;
		
		tiros = new ArrayList<Tiro>();
	}
	
	public void upPlayer () {
		ImageIcon imagem = new ImageIcon("Imagens//Player.png");
		player = imagem.getImage();
		
		altura = player.getHeight(null);
		largura = player.getWidth(null);
	}
	

	public void movimented () {
		x += dx;
		y += dy;
	}
	
	public void tiroSimples () {
		this.tiros.add(new Tiro(x+largura, y+ (altura/2)));
	}
	
	public void keyPressed (KeyEvent tecla) {
		int cody = tecla.getKeyCode();
		if(cody == KeyEvent.VK_A) {
			tiroSimples();
			SomGame music = new SomGame();
			if(isVisivel != false) {
				try {
					music.tocarAudio("TiroNave.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		if(cody == KeyEvent.VK_UP) {
			dy = -3;
		}
		if(cody == KeyEvent.VK_DOWN) {
			dy = 3;
		}
		if(cody == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		if(cody == KeyEvent.VK_RIGHT) {
			dx = 3;
		}
	}
	
	public void keyRelease (KeyEvent tecla) {
		int cody = tecla.getKeyCode();
		if(cody == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(cody == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if(cody == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(cody == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
	

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getPlayer() {
		return player;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}
	
	
}
