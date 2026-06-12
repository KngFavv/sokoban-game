package entity;

import java.awt.Rectangle;
import java.util.ArrayList;

import sokoban.GamePanel;
import tile_interactive.IT_Diamond;
import tile_interactive.InteractiveTile;

public class NPC_crate extends Entity{
	
	public static final String npcName = "crate";

	public NPC_crate(GamePanel gp) {
		super(gp);
		
		name = npcName;
		direction = "down";
		speed = 4;
		
		solidArea = new Rectangle();
		solidArea.x = 2;
		solidArea.y = 6;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 44;
		solidArea.height = 40;
		
		getImage();
		
	}
	public void getImage() {
		up1 = setup("/tile_interactive/crate");
		
		down1 = setup("/tile_interactive/crate");
		
		left1 = setup("/tile_interactive/crate");
		
		right1 = setup("/tile_interactive/crate");
		
	}
	public void setAction() {
		
	}
	public void update() {
		
	}
	public void move(String direction) {
	    this.direction = direction;
	    checkCollision();

	    if (collisionOn==false) {
	        switch (direction) {
	            case "up":
	                worldY -= speed;
	                break;
	            case "down":
	                worldY += speed;
	                break;
	            case "left":
	                worldX -= speed;
	                break;
	            case "right":
	                worldX += speed;
	                break;
	        }
	    }
	}

	public void detectDiamond() {
	    ArrayList<InteractiveTile> diamondList = new ArrayList<>();
	    ArrayList<Entity> crateList = new ArrayList<>();

	    for (int i = 0; i < gp.iTile[1].length; i++) {
	        if (gp.iTile[gp.currentMap][i] != null &&
	                gp.iTile[gp.currentMap][i].name != null &&
	                gp.iTile[gp.currentMap][i].name.equals(IT_Diamond.itName)) {
	            diamondList.add(gp.iTile[gp.currentMap][i]);
	        }
	    }

	    for (int i = 0; i < gp.npc[1].length; i++) {
	        if (gp.npc[gp.currentMap][i] != null &&
	                gp.npc[gp.currentMap][i].name.equals(NPC_crate.npcName)) {
	            crateList.add(gp.npc[gp.currentMap][i]);
	        }
	    }

	    int count = 0;

	    for (InteractiveTile diamond : diamondList) {
	        for (Entity crate : crateList) {
	            int xDistance = Math.abs(crate.worldX - diamond.worldX);
	            int yDistance = Math.abs(crate.worldY - diamond.worldY);
	            if (xDistance < gp.tileSize && yDistance < gp.tileSize) {
	                count++;
	                break;
	            }
	        }
	    }

	    if (count == diamondList.size()) {
	    	int nextMapIndex = (gp.currentMap + 1) % gp.maxMap;
            gp.nextMap(nextMapIndex);
	    }
	}
	
}
