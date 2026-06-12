package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sokoban.GamePanel;
import sokoban.KeyHandler;
import sokoban.UtilityTool;

public class wareHouseKeeper extends Entity {

KeyHandler keyH;





public wareHouseKeeper(GamePanel gp,  KeyHandler keyH) {//Constructor
	
	super(gp);
	this.keyH = keyH;
	
	
	
	solidArea = new Rectangle();//make a solid smaller rectangle so that the player can fit in tight corners with no stuggle 
	solidArea.x = 8;
	solidArea.y = 16;
	solidAreaDefaultX = solidArea.x;
	solidAreaDefaultY = solidArea.y;
	solidArea.width = 30;
	solidArea.height = 30;
	
	
	setDefaultValues();
	getPlayerImage();
}
public void setDefaultValues() {//method
	speed = 4;
	direction = "down";
}
public void getPlayerImage() {//method to get image for the players animation
	
	up1 = setup("/wareHouseKeeper/boy_up_1");
	up2 = setup("/wareHouseKeeper/boy_up_2");
	down1 = setup("/wareHouseKeeper/boy_down_1");
	down2 = setup("/wareHouseKeeper/boy_down_2");
	left1 = setup("/wareHouseKeeper/boy_left_1");
	left2 = setup("/wareHouseKeeper/boy_left_2");
	right1 = setup("/wareHouseKeeper/boy_right_1");
	right2 = setup("/wareHouseKeeper/boy_right_2");
	
	
	
}

public void update() {//gets called 60times per second

	
	if(keyH.upPressed == true || keyH.downPressed == true ||
		keyH.leftPressed == true || keyH.rightPressed == true) {
	
	if (keyH.upPressed == true) {
		direction = "up";
		
	}
	else if(keyH.downPressed == true) {
		direction = "down";
	
	}
	else if(keyH.leftPressed == true) {
		direction = "left";
		
	}
	else if(keyH.rightPressed == true) {
		direction = "right";
		
	}
	
	//CHECK TILE COLLISION
	collisionOn = false;
	gp.cCHecker.checkTiles(this);
	
	//CHECK NPC COLLISOIN
	
	int npcIndex =gp.cCHecker.checkEntity(this, gp.npc);
	interactiveNPC(npcIndex);
	
	//CHECK INTERACTIVE TILE COLLISION
	int iTileIndex =gp.cCHecker.checkEntity(this, gp.iTile);
	
	//iF COLLISION IS FALSE, PLAYER CAN MOVE
	if(collisionOn == false) {// player can move when the tiles are not solid 
		
		switch(direction) {
		case "up":
			worldY -= speed;//value decreased to go up
			break;
		case "down":
			worldY += speed; //value increased to go down
			break;
		case "left":
			worldX -= speed;//value decreased to go left
			break;
		case "right":
			worldX += speed; //value increased to go right
			break;
			
	
		}
		
	}
	spriteCounter++;//every frame this calls it increases this counter by 1 
	if(spriteCounter > 13) {//when it hits 13 frame it changes the playeImage from 1 to 2 or 2 to 1 to create the walking animation
		if(spriteNum == 1) {
			spriteNum = 2;
		}
		else if(spriteNum == 2) {
			spriteNum = 1;
		}
		spriteCounter = 0;
	}
}
}
public void interactiveNPC(int i) {
	
	if(i != 999) {
		gp.npc[gp.currentMap][i].move(direction);
	}
}
public void draw(Graphics2D g2) {

	//g2.setColor(Color.white);// sets a colour to use for drawing objects 
	//g2.fillRect(x, y, gp.tileSize, gp.tileSize);//draw a rectangle (player character)
	
  BufferedImage image = null;
	
	switch(direction) {
	
	case "up"://create the animation going up 
		if(spriteNum == 1 ) {
	        image = up1;
		}
		if(spriteNum == 2) {
			image = up2;
		}
	      break;
	      
	case "down"://create the animation for going down 
		if(spriteNum == 1 ) {
		    image = down1;
		}
			if(spriteNum == 2) {
			image = down2;
		}
		  break;
		  
	case "left"://create the animation for going left
		if(spriteNum == 1 ) {
		    image = left1;
		}
			if(spriteNum == 2) {
		    image = left2;
		}
		  break;
		  
	case "right"://create the animation for going right
		if(spriteNum == 1 ) {
		    image = right1;
		}
			if(spriteNum == 2) {
		    image = right2;
		  break;
    	}
	}
    g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);//to draw the image on the screen
	
}



}


