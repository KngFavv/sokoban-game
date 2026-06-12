package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sokoban.GamePanel;
import sokoban.UtilityTool;

public class Entity {
    GamePanel gp;
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, CAI;
	public String direction = "down";
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX,  solidAreaDefaultY; 
	public boolean collisionOn = false;
	public int actionLockCounter = 0;
	public BufferedImage image, image2, image3;
	public String name;
	public boolean collision = false;
	
	
	String dialogues[] = new String[20];
	public Entity linkedEntity;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
		
	}
public void setAction() {}
public void move(String direction) {
	
}
public void checkCollision() {
	collisionOn = false;
	gp.cCHecker.checkTiles(this);
	gp.cCHecker.checkEntity(this, gp.npc);
	gp.cCHecker.checkEntity(this, gp.iTile);
	gp.cCHecker.checkPlayer(this);
	
}
public void update() {
	
	
	setAction();
	checkCollision();

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
	
	public void draw(Graphics2D g2) {
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
	
	public BufferedImage setup(String imagePath) {// to scale the image 
		
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
        	image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
        	image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        	
        }catch(IOException e) {
        	e.printStackTrace();
        }
        return image;
	}
			
			
}
