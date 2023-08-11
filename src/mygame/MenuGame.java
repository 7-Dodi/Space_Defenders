package mygame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuGame extends JPanel{
	private static Image background;
	
	public MenuGame() {
		ImageIcon imagem = new ImageIcon ("Imagens//SpaceDefenders.jpg");
		background = imagem.getImage();
	}
	
	public void paint (Graphics g) {
		Graphics2D grafic = (Graphics2D) g;
		grafic.drawImage(background, 0, 0, null);
		g.dispose();
	}
}
