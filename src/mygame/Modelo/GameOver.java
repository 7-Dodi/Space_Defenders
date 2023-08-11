package mygame.Modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GameOver {
	private Image background;
	private int altura, largura;
	
	public GameOver() {
		ImageIcon gameOver = new ImageIcon("Imagens//GameOver.jpg");
		background = gameOver.getImage();
		
		altura = background.getHeight(null);
		largura = background.getWidth(null);
	}
	
	public Image getBackground() {
		return background;
	}
}
