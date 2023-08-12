package com.blaze.gaming.canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.blaze.gaming.sprites.OppnPlayer;
import com.blaze.gaming.sprites.Player;
import com.blaze.gaming.sprites.Power;
import com.blaze.gaming.utils.GameConstants;

public class Board extends JPanel implements GameConstants {
	BufferedImage imageBg;
	private Player player;
	private OppnPlayer oppnPlayer;
	private Timer timer;
	private Power playerFullPower;
	private Power oppnFullPower;
	private boolean gameOver;
	private void gameLoop() {
		timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				if(gameOver) {
					timer.stop();
				}
				player.fall();
				oppnPlayer.fall();
				collision();
				isGameOver();
			}
		});
		timer.start();
	}
	private void loadPower() {
		playerFullPower= new Power(30,"Player");
		oppnFullPower= new Power(GWIDTH-550,"OppnPlayer");
	}
	private void printFullPower(Graphics g) {
		playerFullPower.printRectangle(g);
		oppnFullPower.printRectangle(g);
		
	}
	private boolean isCollide() {
		int xDist= Math.abs(player.getX()-oppnPlayer.getX());
		int yDist= Math.abs(player.getY()-oppnPlayer.getY());
		int maxH= Math.max(player.getH(), oppnPlayer.getH());
		int maxW= Math.max(player.getW(), oppnPlayer.getW());
		return xDist<=(maxW-40) && yDist<=(maxH-40);
	}
	private void collision() {
		if(isCollide()) {
			if(player.isAttacking()) {
				oppnPlayer.setCurrentMove(DAMAGE);
				oppnFullPower.setHealth();
				//oppnPlayer.setCurrentMove(walk);
			}
			if(oppnPlayer.isAttacking()) {
				player.setCurrentMove(DAMAGE);
				playerFullPower.setHealth();
				
			}
			player.setSpeed(0);
			player.setCollide(true);
			oppnPlayer.setSpeed(0);
			oppnPlayer.setCollide(true);
			
		}
		else {
			player.setCollide(false);
			player.setSpeed(speed);
			oppnPlayer.setCollide(false);
			oppnPlayer.setSpeed(speed);
		}
	}
	
	private void isGameOver() {
		if(oppnFullPower.getHealth()<0 || playerFullPower.getHealth()<0) {
			gameOver= true;
		}
	}
	
	private void printGameOver(Graphics pen) {
		if(gameOver) {
		pen.setColor(Color.BLACK);
		pen.setFont(new Font("Times",Font.BOLD, 50));
		pen.drawString("Game Over", GWIDTH/2-100,GHEIGHT/2-100);
		}
	}
	
	public Board() throws Exception {
		player = new Player();
		oppnPlayer = new OppnPlayer();
		loadBg();
		setFocusable(true);
		bindEvents();
		gameLoop();
		loadPower();
		
		
		
}

	private void bindEvents() {
		KeyListener listener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Type "+e.getKeyCode()+" "+e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//left player
				if(e.getKeyCode()==KeyEvent.VK_A) {
					player.setSpeed(-speed);
					player.setCollide(false);
					player.move();
					//repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_D) {
					player.setSpeed(speed);
					player.move();
					//repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_E) {
					player.setCurrentMove(kick);
					
				}
				else if(e.getKeyCode()==KeyEvent.VK_Q) {
					player.setCurrentMove(punch);
					
				}
				else if(e.getKeyCode()==KeyEvent.VK_W) {
					
					player.jump();
				}
				
				//right player
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					oppnPlayer.setSpeed(-speed);
					
					oppnPlayer.move();
					//repaint();
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					oppnPlayer.setSpeed(speed);
					oppnPlayer.setCollide(false);
					oppnPlayer.move();
					//repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_UP) {
					
					oppnPlayer.jump();
				}
				else if(e.getKeyCode()==KeyEvent.VK_K) {
					oppnPlayer.setCurrentMove(kick);
					
				}
				else if(e.getKeyCode()==KeyEvent.VK_P) {
					
					oppnPlayer.setCurrentMove(punch);
				}
				// TODO Auto-generated method stub
				//System.out.println("Pressed "+e.getKeyCode()+" "+e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Release "+e.getKeyCode()+" "+e.getKeyChar());
			}
			
		};
		this.addKeyListener(listener);
	}
	@Override
	public void paintComponent(Graphics pen){
		printBg(pen);
		player.drawPlayer(pen);
		oppnPlayer.drawPlayer(pen);
		printFullPower(pen);
		printGameOver(pen);
	}
	
	
	private void printBg(Graphics pen){
		pen.drawImage(imageBg,0,0,GWIDTH,GHEIGHT,null);
	}
	
	private void loadBg() {
		try {
		imageBg =ImageIO.read(Board.class.getResource(bg_img));
		}
		catch (Exception e) {
			System.out.println("image not found");
			System.out.println(e);
			System.exit(0);
		}
	}
}
	
