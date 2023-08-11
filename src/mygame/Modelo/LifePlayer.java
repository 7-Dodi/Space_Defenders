package mygame.Modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class LifePlayer {
	private Image vida;
	private int x, y;
	private int height, widht;
	private boolean isVisivel;
	
	private static int qtdeVidas = 3;
	
	public LifePlayer(int num) {
		this.y = 20;
		this.x = num;
		isVisivel = true;
	}
	
	public void load() {
		ImageIcon image = new ImageIcon("Imagens//VidaPlayer.png");
		vida = image.getImage();
		
		height = vida.getHeight(null);
		widht = vida.getWidth(null);
	}
	
	public Image getVida() {
		return vida;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static int getQtdeVidas() {
		return qtdeVidas;
	}

	public static void setQtdeVidas(int qtdeVidas) {
		LifePlayer.qtdeVidas = qtdeVidas;
	}
	
}
