package tile_interactive;

import entity.Entity;
import sokoban.GamePanel;

public class InteractiveTile extends Entity{
	
GamePanel gp;


	public InteractiveTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}
	
    public void update() {
	
    }

}
