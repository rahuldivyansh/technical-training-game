package com.blaze.gaming.sprites;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.blaze.gaming.utils.GameConstants;

public class Player extends Sprite implements GameConstants {
	
	private BufferedImage walkImage[] = new BufferedImage[6];
	private BufferedImage kickImage[] = new BufferedImage[6];
	private BufferedImage punchImage[] = new BufferedImage[6];
			BufferedImage damageEffect[] = new BufferedImage[5];
	public Player() throws Exception {
		image = ImageIO.read(Player.class.getResource(player_img));
		x = 100;
		w = h = player_dimension;
		y = FLOOR - h;
		loadwalkImage();
		loadkickImage();
		loadpunchImage();
		loaddamageEffect();
		
	}
	public void loaddamageEffect() {
		damageEffect[0] = image.getSubimage(63, 237, 73, 97);
		damageEffect[1] = image.getSubimage(223,2425,69,96);
		damageEffect[2] = image.getSubimage(302,2424,82,100);
		damageEffect[3] = image.getSubimage(392,2422,87,100);
		damageEffect[4] = image.getSubimage(124,2422,80,92);
		
	}
	private void loadwalkImage() {
		walkImage[0] = image.getSubimage(63, 237, 73, 97);
		walkImage[1] = image.getSubimage(142, 237, 73, 97);
		walkImage[2] = image.getSubimage(224, 237, 73, 97);
		walkImage[3] = image.getSubimage(303, 237, 73, 97);
		walkImage[4] = image.getSubimage(375, 237, 73, 97);
		walkImage[5] = image.getSubimage(453, 237, 73, 97);
	}
	
	private void loadkickImage() {
		kickImage[0] = image.getSubimage(37, 1044, 73, 102);
		kickImage[1] = image.getSubimage(120, 1044, 73, 102);
		kickImage[2] = image.getSubimage(202, 1044, 118, 104);
		kickImage[3] = image.getSubimage(332,1044, 73, 102);
		kickImage[4] = image.getSubimage(404,1044, 73, 102);
		kickImage[5] = image.getSubimage(482, 1048, 97, 102);
	}
	
	private void loadpunchImage() {
		punchImage[0] = image.getSubimage(25, 822, 69, 98);
		punchImage[1] = image.getSubimage(107, 822, 69, 98);
		punchImage[2] = image.getSubimage(187, 822, 116, 98);
		punchImage[3] = image.getSubimage(307, 822, 69, 98);
		punchImage[4] = image.getSubimage(403, 822, 109, 98);
		punchImage[5] = image.getSubimage(516, 822, 69, 98);
	}
	public void jump() {
		if(!isJump) {
			isJump=true;
			force=-50;
			y=y+force;
		}
		
	}
	public void fall() {
		if(y>=(FLOOR-h)) {
			isJump=false;
			return;
		}
		y=y+force;
		force=force+GRAVITY;
	}
	
	private BufferedImage printWalk() {
		isAttacking=false;
		if(imageIndex>5)
			imageIndex=0;
		
		BufferedImage img = walkImage[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage printKick() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=walk;
			isAttacking=false;
		}
		isAttacking = true;
		BufferedImage img = kickImage[imageIndex];
		imageIndex++;
		return img;
		
	}
	private BufferedImage printPunch() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=walk;
			isAttacking=false;
		}
		isAttacking = true;
		BufferedImage img = punchImage[imageIndex];
		imageIndex++;
		return img;
		
	}
	public BufferedImage printDamage() {
		if(imageIndex>4) {
			imageIndex=0;
			currentMove=walk;
		}
		BufferedImage img = damageEffect[imageIndex];
		imageIndex++;
		return img;
	}
//	private BufferedImage printDamage() {
//		if(imageIndex>5)
//			imageIndex=0;
//		
//		BufferedImage img = Image[imageIndex];
//		imageIndex++;
//		return img;
//	}
	@Override
	public BufferedImage defaultImage() {
	
		if(currentMove==kick) {
			return printKick();
		}
		else if(currentMove==punch) {
			return printPunch();
		}
		else if(currentMove==DAMAGE) {
			return printDamage();
		}
		else{
			return printWalk();
		}
	}
//	@Override
//	public BufferedImage walk() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	public BufferedImage walk() {
//	return image.getSubimage(ls1,ls2,ls3,ls4); 
//}
	
	

	
	

}
