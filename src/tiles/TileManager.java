
package tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import sokoban.GamePanel;
import sokoban.UtilityTool;

public class TileManager {

	GamePanel gp;
public Tile[] tile;
public int mapTileNum[][][];
	
	public TileManager(GamePanel gp) {//constructor
		
		this.gp = gp;
		
		tile = new Tile[4];//create 4 type of tiles 
		mapTileNum = new int[gp.maxMap][gp.maxScreenCol][gp.maxScreenRow];// to store all the numbers 
		
		getTileImage();
		loadMap("/maps/map01.txt",0);
		loadMap("/maps/map02.txt",1);
		loadMap("/maps/map03.txt",2);
		loadMap("/maps/map04.txt",3);
		loadMap("/maps/map05.txt",4);
		
	}
	
	public void getTileImage() {
			
			setup(0, "floor01", false);
			setup(1, "wall", true);
	
	}
	public void setup(int index, String imageName, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		try{
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName +".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision; 
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void loadMap(String filepath, int map) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filepath);//to import the txt file
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
				String line = br.readLine();//read a single line and put  it into the string line 
				
				while(col< gp.maxScreenCol) {
					
					String numbers[] = line.split(" ");//split a line and get tile number one by one and put them into the number array
					
					int num = Integer.parseInt(numbers[col]);//changing it from string to integer
					
					mapTileNum[map][col][row] = num; //to store the extracted number
					col++;
				}
				if(col == gp.maxScreenCol) {//if it hit the max screen it stops and go to the next row
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		
		
	}
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			
			int tileNum = mapTileNum[gp.currentMap][col][row];
			
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);//draw a tile at 0,0
			col++;//draw the next tile
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol) {//if it hits the max screen column it resets
		    	col = 0;
		    	x = 0;
		    	row++;
		    	y += gp.tileSize;
			
			}
			
		}
			
	}
}
