package mygame.Modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Tiro {
	private int x, y;
	private int largura, altura;
	private Image tiro;
	private boolean isVisivel;
	
	private static final int LARGURA = 938;
	private static int VELOCIDADE = 8;
	
	
	public Tiro(int positionX, int positionY) {
		this.x = positionX-50;
		this.y = positionY-15;
		isVisivel = true;
	}

	public void load () {
		ImageIcon imagem = new ImageIcon("Imagens//Tiros.png");
		tiro = imagem.getImage();
		
		this.altura = tiro.getHeight(null);
		this.largura = tiro.getWidth(null);
	}
	
	public void upDate() {
		this.x += VELOCIDADE;
		if(x > LARGURA) {
			isVisivel = false;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}
	
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}
	
	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Image getTiro() {
		return tiro;
	}
	
	
}
