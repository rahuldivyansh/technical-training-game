package com.blaze.gaming.sprites;

import java.awt.image.BufferedImage;


import java.io.IOException;

import javax.imageio.ImageIO;

import com.blaze.gaming.utils.GameConstants;

public class OppnPlayer extends Sprite implements GameConstants {
	private BufferedImage walkImage[] = new BufferedImage[6];
	private BufferedImage kickImage[] = new BufferedImage[6];
	private BufferedImage punchImage[] = new BufferedImage[6];
			BufferedImage damageEffect[] = new BufferedImage[5];
	public OppnPlayer() throws IOException {
		x = GWIDTH - 300;
		h = w = player_dimension;
		y = FLOOR - h;
		image = ImageIO.read(OppnPlayer.class.getResource(oppn_player_img));
		loadwalkImage();
		loadkickImage();
		loadpunchImage();
		loaddamageEffect();
	}
	public void loaddamageEffect() {
		damageEffect[0] = image.getSubimage(659,543,51,81);
		damageEffect[1] = image.getSubimage(544,543,54,81);
		damageEffect[2] = image.getSubimage(544,543,54,81);
		damageEffect[3] = image.getSubimage(605,543,51,81);
		damageEffect[4] = image.getSubimage(605,543,51,81);
		
	}
	private void loadwalkImage() {
		walkImage[0] = image.getSubimage(551, 0, 57, 92);
		walkImage[1] = image.getSubimage(492, 0, 56, 94);
		walkImage[2] = image.getSubimage(436, 0, 52, 92);
		walkImage[3] = image.getSubimage(383, 0, 52, 90);
		walkImage[4] = image.getSubimage(331, 0, 53, 88);
		walkImage[5] = image.getSubimage(270, 0, 59, 95);
	}
	
	private void loadkickImage() {
		kickImage[0] = image.getSubimage(551, 0, 57, 92);
		kickImage[1] = image.getSubimage(379, 93, 53, 84);
		kickImage[2] = image.getSubimage(300, 93, 75, 82);
		kickImage[3] = image.getSubimage(300, 93, 75, 82);
		kickImage[4] = image.getSubimage(222, 98, 74, 82);
		kickImage[5] = image.getSubimage(222, 98, 74, 82);
	}
	
	private void loadpunchImage() {
		punchImage[0] = image.getSubimage(551, 0, 57, 92);
		punchImage[1] = image.getSubimage(650, 92, 60, 80);
		punchImage[2] = image.getSubimage(582, 94, 72, 78);
		punchImage[3] = image.getSubimage(582, 94, 72, 78);
		punchImage[4] = image.getSubimage(504, 96, 75, 76);
		punchImage[5] = image.getSubimage(504, 96, 75, 76);
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
//	return image.getSubimage(rs1,rs2,rs3,rs4); 
//}
//	@Override
//	public BufferedImage defaultImage() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
