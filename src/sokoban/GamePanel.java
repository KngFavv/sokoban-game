package sokoban;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.Entity;
import entity.NPC_crate;
import entity.wareHouseKeeper;
import tile_interactive.InteractiveTile;
import tiles.TileManager;

public class GamePanel extends JPanel implements Runnable {//inherites JPanel class
	

	private static final long serialVersionUID = 1L;
	//Screen settings 
	final int originalTileSize = 16; // 16X16 of player character
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; // 48X48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; //768 pixels
	public final int screenHeight = tileSize * maxScreenRow;//576 pixels 
	
	//level settings
	public final int maxMap = 5;
	public int currentMap = 0;
	
	//Fps
	int Fps = 60;
	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);//instantiate
	public CollisionChecker cCHecker = new CollisionChecker(this);
	public AssertSetter aSetter = new AssertSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	//entity 
	public wareHouseKeeper player = new wareHouseKeeper(this, keyH);
	public Entity npc[][] = new Entity[maxMap][50];
    public InteractiveTile iTile[][] = new InteractiveTile[maxMap][50];
   
	
	
	//game state
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int optionState = 2;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);//recognise the key input
		this.setFocusable(true);//gamepanel can be focused to receive key input
	}
	
	
	public void setupGame() {
		    aSetter.definePlayerSpawnPositions();
	        aSetter.setNPC();
	        aSetter.setInteractiveTile();
	        setPlayerPosition();
	        gameState = titleState;
		
		
		
		}
	
	public void startGameThread() {
	gameThread = new Thread(this);
	gameThread.start();//automatically call the run method 
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/Fps; //draw the screen 60 times per second(0.016666 seconds)
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread !=null) {//repeats the process in the brackets
			
			update();
			
			repaint();
			
		
			try {
				double remainingTime = nextDrawTime - System.nanoTime();//returns how much time remaiming until the next draw 
				remainingTime = remainingTime/1000000;//convert it from nano to millisecond
				
				if(remainingTime < 0) {// putting 0 to the remain time
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);// to sleep for the remaining time
				
				nextDrawTime += drawInterval; 
			} catch (InterruptedException e) {
				

				e.printStackTrace();
			}
			
		}	
		
	}
	
	
	public void update() {
	    if (gameState == playState) {
	        player.update(); // Update the player

	        for (int i = 0; i < npc[1].length; i++) {
	            if (npc[currentMap][i] != null) {
	                npc[currentMap][i].update(); // Update NPCs

	                // If the NPC is a crate, check for diamond detection
	                if (npc[currentMap][i] instanceof NPC_crate) {
	                    ((NPC_crate) npc[currentMap][i]).detectDiamond();
	                }
	            }
	        }

	        for (int i = 0; i < iTile[1].length; i++) {
	            if (iTile[currentMap][i] != null) {
	                iTile[currentMap][i].update(); // Update interactive tiles
	            }
	        }
	    }
	}

	
	public void paintComponent (Graphics g) {//player
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//debug 
		long drawStart = 0;
		if(keyH.showDebugText == true) {
			drawStart = System.nanoTime();
			
		}
		
		//title screen
		if(gameState == titleState) {
			
			ui.draw(g2);
		}
		else {
			//title
			tileM.draw(g2);
			
			//interacive tile
			for(int i = 0; i < iTile[1].length; i++) {
				if(iTile[currentMap][i] != null) {
					iTile[currentMap][i].draw(g2);
				}
			}
			
			//npc
			for(int i = 0; i < npc[1].length; i++) {
				if(npc[currentMap][i] != null) {
					npc[currentMap][i].draw(g2);
				}
			}
			
			
			
			player.draw(g2); 
			
			ui.draw(g2);
		}
		
		if(keyH.showDebugText == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			
			g2.setFont(new Font("Arial", Font.PLAIN, 20));
			g2.setColor(Color.white);
			int x =10; 
			int y =400;
			int lineHeight = 20;
			
			g2.drawString("worldX" + player.worldX, x, y); y += lineHeight;
			g2.drawString("worldY" + player.worldY, x, y); y += lineHeight;
			g2.drawString("col" + (player.worldX + player.solidArea.x)/tileSize, x, y); y += lineHeight;
			g2.drawString("row" + (player.worldY + player.solidArea.y)/tileSize, x, y); y += lineHeight;
			g2.drawString("Draw Time: " + passed, x, y);
			
			
		}
		
		g2.dispose();//release any system resources that it is using
	}
	 public void setPlayerPosition() {
	        player.worldX = aSetter.playerSpawnPositions[currentMap][0];
	        player.worldY = aSetter.playerSpawnPositions[currentMap][1];
	    }
	 public void nextMap(int map) {
	        currentMap = map;
	        setPlayerPosition();
	        aSetter.setNPC();
	        aSetter.setInteractiveTile();
	        tileM.loadMap("/maps/map01" + (map + 1) + ".txt", map); // Load the correct map file
	    }
	
}
