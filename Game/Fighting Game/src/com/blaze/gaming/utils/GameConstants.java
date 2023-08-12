package com.blaze.gaming.utils;

public interface GameConstants {
	int GWIDTH=1550;
	int GHEIGHT=900;
	String TITLE="To be Street Fighter";
	int FLOOR= GHEIGHT - 100;
	int speed = 20;
	int player_dimension=250;
	int walk=1;
	int kick=2;
	int punch=3;
	int GRAVITY =20;
	int DAMAGE = 5;
	static int MAX_HEALTH=500;
	String bg_img = "bg.jpg";
	String player_img = "ryu.gif";
	String oppn_player_img = "goku1.png";
	
	//walk method sprite values
	//left player
	int ls1=61, ls2=237, ls3=73, ls4=97;

	//right player
	int rs1=659,rs2=2,rs3=51,rs4=87;
	
	
	//player movement keys values
	//left
	int W = 87;
	int S = 83;
	int A = 65;
	int D = 68;
	//right
	int UP = 38;
	int DOWN = 40;
	int LEFT = 37;
	int RIGHT = 39;
}
