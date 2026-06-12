package sokoban;

import entity.NPC_crate;
import tile_interactive.IT_Diamond;

public class AssertSetter {
GamePanel gp;
public int[][] playerSpawnPositions;


   public AssertSetter(GamePanel gp) {
	this.gp = gp;
	 playerSpawnPositions = new int[gp.maxMap][2]; // Initialize the array for player spawn positions
   }
   public void setObject() {
	   
   }
   public void setNPC() {
	   int mapNum = 0;
	   int i = 0;
	  gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 383;
	   gp.npc[mapNum][i].worldY = 190;
	   i++;
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 383;
	   gp.npc[mapNum][i].worldY = 144;
	   i++;
	  
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 383;
	   gp.npc[mapNum][i].worldY = 240;
	   i++;
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 383;
	   gp.npc[mapNum][i].worldY = 336;
	   i++;
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 432;
	   gp.npc[mapNum][i].worldY = 336;
	   i++;
	   
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 239;
	   gp.npc[mapNum][i].worldY = 336;
	   i++;
	   
	  mapNum = 1;
	  
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 292;
	   gp.npc[mapNum][i].worldY = 140;
	   i++;
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 236;
	   gp.npc[mapNum][i].worldY = 140;
	   i++;
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 384;
	   gp.npc[mapNum][i].worldY = 236;
	   i++;
	   
	   gp.npc[mapNum][i] = new NPC_crate(gp); 
	   gp.npc[mapNum][i].worldX = 384;
	   gp.npc[mapNum][i].worldY = 336;
	   i++;
	   
	   
		  mapNum = 2;
		  
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 332;
		   gp.npc[mapNum][i].worldY = 384;
		   i++;
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 336;
		   gp.npc[mapNum][i].worldY = 192;
		   i++;
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 236;
		   gp.npc[mapNum][i].worldY = 144;
		   i++;
		   
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 188;
		   gp.npc[mapNum][i].worldY = 144;
		   i++;
		   mapNum = 3;
			  
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 240;
		   gp.npc[mapNum][i].worldY = 384;
		   i++;
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 140;
		   gp.npc[mapNum][i].worldY = 236;
		   i++;
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 192;
		   gp.npc[mapNum][i].worldY = 236;
		   i++;
		   
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 288;
		   gp.npc[mapNum][i].worldY = 144;
		   i++;
		   
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 144;
		   gp.npc[mapNum][i].worldY = 332;
		   i++;
		   mapNum = 4;
			  
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 244;
		   gp.npc[mapNum][i].worldY = 288;
		   i++;
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 432;
		   gp.npc[mapNum][i].worldY = 288;
		   i++;
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 288;
		   gp.npc[mapNum][i].worldY = 240;
		   i++;
		   
		   gp.npc[mapNum][i] = new NPC_crate(gp); 
		   gp.npc[mapNum][i].worldX = 288;
		   gp.npc[mapNum][i].worldY = 146;
		   i++;
		   
		
		   
	   
   }
   public void setInteractiveTile() {
	   int mapNum = 0;
	   int i = 0;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,240,144); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,240,240); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,383,288); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,383,383); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,480,336); i++;
	   
	   mapNum = 1;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,384,384); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,480,288); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,192,432); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,528,476); i++;
	   
	   mapNum = 2;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,432,479); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,192,384); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,336,479); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,288,96); i++;
	   
	   mapNum = 3;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,336,336); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,480,476); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,96,336); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,144,432); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,480,292); i++;
	   
	   mapNum = 4;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,192,240); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,240,96); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,144,480); i++;
	   gp.iTile[mapNum][i] = new IT_Diamond(gp,384,384); i++;
   }
   public void definePlayerSpawnPositions() {
       playerSpawnPositions[0][0] = 287; // X position for map 1
       playerSpawnPositions[0][1] = 136; // Y position for map 1

       playerSpawnPositions[1][0] = 196; // X position for map 2
       playerSpawnPositions[1][1] = 476; // Y position for map 2
       
       playerSpawnPositions[2][0] = 336; // X position for map 3
       playerSpawnPositions[2][1] = 476; // Y position for map 3
       
       playerSpawnPositions[3][0] = 99; // X position for map 4
       playerSpawnPositions[3][1] = 100; // Y position for map 4
       
       playerSpawnPositions[4][0] = 188; // X position for map 5
       playerSpawnPositions[4][1] = 332; // Y position for map 5

       // Define positions for other maps
   }


}
