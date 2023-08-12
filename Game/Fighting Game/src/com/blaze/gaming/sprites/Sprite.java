package com.blaze.gaming.sprites;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import com.blaze.gaming.utils.*;

public abstract class Sprite {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected BufferedImage image;
	protected int speed;
	protected int imageIndex;
	protected int currentMove;
	protected int force =0;
	protected boolean isJump;
	protected boolean isCollide;
	protected boolean isAttacking;
	protected int health;
	public Sprite() {
		health=500;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth() {
		this.health =(int)(this.health-(GameConstants.MAX_HEALTH*0.01));
	}

	public boolean isAttacking() {
		return isAttacking;
	}
	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}
	public boolean isCollide() {
		return isCollide;
	}
	public void setCollide(boolean isCollide) {
		this.isCollide = isCollide;
	}
	public int getCurrentMove() {
		return currentMove;
	}
	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}
	public abstract BufferedImage defaultImage();
	//public abstract BufferedImage walk();
	
//	private BufferedImage walk() {
//		return image.getSubimage(61, 237, 73, 97); 
//	}
	public void drawPlayer(Graphics pen) {
		pen.drawImage(defaultImage(),x,y,w,h,null);
		//pen.drawImage(walk(),x,y,w,h,null);
	}
	
	public void move() {
		if(!isCollide)
		x = x + speed;
	}
	public  int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
