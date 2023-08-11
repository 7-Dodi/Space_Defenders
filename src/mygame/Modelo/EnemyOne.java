package mygame.Modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EnemyOne extends Enemy{
	private int x, y;
	private int largura, altura;
	private Image enemy;
	private boolean isVisivel;
	
	private static final int LARGURA = -100;
	private static int VELOCIDADE = 6;
	public static int KILL = 0;
	
	public EnemyOne(int positionX, int positionY) {
		this.x = positionX-50;
		this.y = positionY-15;
		isVisivel = true;
	}

	@Override
	public void load () {
		ImageIcon imagem = new ImageIcon("Imagens//EnemyOne.png");
		enemy = imagem.getImage();
		
		this.altura = enemy.getHeight(null);
		this.largura = enemy.getWidth(null);
	}
	
	@Override
	public void upDate() {
		this.x -= VELOCIDADE;
		if(x < LARGURA) {
			isVisivel = false;
		}
	}
	
	public ImageIcon setEnemy(ImageIcon enemy) {
		return enemy;
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

	public Image getEnemy() {
		return enemy;
	}
}
