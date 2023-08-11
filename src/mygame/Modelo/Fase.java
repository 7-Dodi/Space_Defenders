package mygame.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.sound.sampled.*;
import java.io.IOException;

public class Fase extends JPanel implements ActionListener, StageGame{
	private Image background;
	private Player player;
	private Timer time;
	private GameWin youWin;
	private GameOver youDead;
	private boolean inGame;
	private List<EnemyOne> enemy;
	private List<Stars> stars;
	private List<LifePlayer> lifes;
	SomGame music = new SomGame();
	
	public Fase() {
		setFocusable(true); 
		setDoubleBuffered(true);
		
		ImageIcon image = new ImageIcon("Imagens//BackGround.jpg");
		background = image.getImage();
		
		player = new Player();
		player.upPlayer();
		
		addKeyListener(new TecladoAdapt());
		
		time = new Timer(5, this);
		time.start();
		
		playedEnemy();
		playedStars();
		playedLife();
		
		inGame = true;
		
		try {
			music.tocarAudio("MusicGame.wav");
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playedEnemy () {
		int coordenadas[] = new int [60];
		enemy = new ArrayList<EnemyOne>();
		
		for(int k=0; k<coordenadas.length; k++) {
			int x = (int)(Math.random() * 8500 + 1024);
			int y = (int)(Math.random() * 620 + 30);
			enemy.add(new EnemyOne(x, y));
		}
	}
	
	public void playedStars () {
		int coordenadas[] = new int [200];
		stars = new ArrayList<Stars>();
		
		for(int k=0; k<coordenadas.length; k++) {
			int x = (int)(Math.random() * 1024 + 0);
			int y = (int)(Math.random() * 768 + 0);
			stars.add(new Stars(x, y));
		}
	}
	
	public void playedLife() {
		int[] vidas = new int[LifePlayer.getQtdeVidas()];
		lifes = new ArrayList<LifePlayer>();
		int life = 487;
		
		for(int k = 0; k < vidas.length; k++) {
			lifes.add(new LifePlayer(life));
			life += 25;
		}
	}
	
	@Override
	public void paint (Graphics g) {
		Graphics2D grafic = (Graphics2D) g;
		if(inGame == true) {
			grafic.drawImage(background, 0, 0, null);
			
			for(int p = 0; p < stars.size(); p++) {
				Stars m = stars.get(p);
				m.load();
				grafic.drawImage(m.getStars(), m.getX(), m.getY(), this);
			}
			
			grafic.drawImage(player.getPlayer(), player.getX(), player.getY(), this);
			
			for(LifePlayer m : lifes) {
				m.load();
				grafic.drawImage(m.getVida(), m.getX(), m.getY(), this);
			}
			
			List<Tiro> tiros = player.getTiros();
			for(int k = 0; k < tiros.size(); k++) {
				Tiro m = tiros.get(k);
				m.load();
				grafic.drawImage(m.getTiro(), m.getX(), m.getY(), this);
			}
			
			for(int j = 0; j < enemy.size(); j++) {
				EnemyOne m = enemy.get(j);
				m.load();
				grafic.drawImage(m.getEnemy(), m.getX(), m.getY(), this);
			}
		}
		else {
			youDead = new GameOver();
			grafic.drawImage(youDead.getBackground(), 0, 0, null);	
			music.pararAudio();
		}
		if(enemy.size() == 0) {
			inGame = false;
			player.setVisivel(false);
			youWin = new GameWin();
			grafic.drawImage(youWin.getBackground(), 0, 0, null);
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.movimented();
		
		for(int p = 0; p < stars.size(); p++) {
			Stars m = stars.get(p);
			if(m.isVisivel()) {
				m.upDate();
			}else {
				stars.remove(p);
			}
		}
		
		List<Tiro> tiros = player.getTiros();
		for(int k = 0; k < tiros.size(); k++) {
			Tiro m = tiros.get(k);
			if(m.isVisivel()) {
				m.upDate();
			}else {
				tiros.remove(k);
			}
		}
		
		for(int j = 0; j < enemy.size(); j++) {
			EnemyOne m = enemy.get(j);
			if(m.isVisivel()) {
				m.upDate();
			}else {
				enemy.remove(j);
			}
		}
		
		for(int x = 0; x < lifes.size(); x++) {
			LifePlayer m = lifes.get(x);
			if(m.isVisivel() == false) {
				lifes.remove(x);
			}
		}
		
		ChecarColisao();
		
		repaint();
	}
	
	@Override
	public void ChecarColisao(){
		Rectangle formaNave = player.getBounds();
		Rectangle formaEnemy;
		Rectangle formaTiros;
		int life = LifePlayer.getQtdeVidas();
		
		for(int k = 0; k < enemy.size(); k ++ ) {
			EnemyOne temEnemy = enemy.get(k);
			formaEnemy = temEnemy.getBounds();
			if(formaNave.intersects(formaEnemy)) {
				if(LifePlayer.getQtdeVidas() > 1) {
					temEnemy.setVisivel(false);
					life--;
					LifePlayer.setQtdeVidas(life);
					lifes.get(life).setVisivel(false);
				}else {
					player.setVisivel(false);
					temEnemy.setVisivel(false);
					inGame = false;	
				}
			}
		}
		
		List <Tiro> tirosPlayer = player.getTiros();
		for(int i = 0; i < tirosPlayer.size(); i++) {
			Tiro temTiros = tirosPlayer.get(i);
			formaTiros = temTiros.getBounds();
			for(int j = 0; j < enemy.size(); j++) {
				EnemyOne temEnemy = enemy.get(j);
				formaEnemy = temEnemy.getBounds();
				if(formaTiros.intersects(formaEnemy)) {
					temEnemy.setVisivel(false);
					temTiros.setVisivel(false);
					temEnemy.KILL++;
				}
			}
		}
	}
	
	private class TecladoAdapt extends KeyAdapter{
		@Override
		public void keyPressed (KeyEvent e){
			player.keyPressed(e);
		}
		@Override
		public void keyReleased (KeyEvent e){
			player.keyRelease(e);
		}
	}

	public boolean isInGame() {
		return inGame;
	}
}
