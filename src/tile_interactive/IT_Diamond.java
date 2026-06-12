package tile_interactive;

import sokoban.GamePanel;

public class IT_Diamond extends InteractiveTile{
	
GamePanel gp;
public static final String itName = "diamond";
	
	public IT_Diamond(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = col;
		this.worldY = row;
		
		name = itName;
		down1 = setup("/tile_interactive/diamond");
		
		solidArea.x = 0;
		solidArea.x = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		
	
	}

}

