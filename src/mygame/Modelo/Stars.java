package mygame.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Stars {
	private int x, y;
	private int largura, altura;
	private Image stars;
	private boolean isVisivel;
	
	private static int VELOCIDADE = 6;
	
	public Stars(int positionX, int positionY) {
		this.x = positionX-50;
		this.y = positionY-15;
		isVisivel = true;
	}

	public void load () {
		ImageIcon imagem = new ImageIcon("Imagens//starPixel.png");
		stars = imagem.getImage();
		
		this.altura = stars.getHeight(null);
		this.largura = stars.getWidth(null);
	}
	
	public void upDate() {
		if(this.x < 0) {
			this.x = largura;
			
			Random a = new Random();
			int m = a.nextInt(500);
			this.x = m + 1024;
			
			Random y = new Random();
			int w = y.nextInt(768);
			this.y = w;
		}else {
			this.x -= VELOCIDADE;			
		}
	}

	public Image getStars() {
		return stars;
	}

	public void setStars(Image stars) {
		this.stars = stars;
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
	
}
