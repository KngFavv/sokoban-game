package sokoban;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class UI {

	GamePanel gp;
	Graphics2D g2;
	Font arial_40;
	public int commandNum = 0;
    public int titleScreenState = 0;// 
    int subState = 0;
    public String currentDialogue = "";
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		
		}
   public void draw(Graphics2D g2) {
	   this.g2 = g2;
	   g2.setFont(arial_40);
	   g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
	   g2.setColor(Color.white);
	   
	   //title state
	   if(gp.gameState == gp.titleState) {
	   drawTitleScreen();
	   }
	   //play state
	   if(gp.gameState == gp.optionState) {
		   drawOptionScreen();
	   }
	
   }
   public void drawTitleScreen() {
	   
	   if(titleScreenState == 0) {
		   
		//title name
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,96F));
		String text = "Sokoban";
		int x = getXForCenteredText(text);
		int y = gp.tileSize*3;
		
		g2.setColor(Color.white);
		g2.drawString(text, x+5, y+5);
		
		x = gp.screenWidth/2 - (gp.tileSize*2)/2;// to put the image in the middle
		y += gp.tileSize*2; 
		g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);// to input the playes image
		
		//menu
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,48F));
		
		text = "START GAME";
		 x = getXForCenteredText(text);
		 y = gp.tileSize*8;
		 g2.drawString(text, x, y);
		 if(commandNum == 0) {
			 g2.drawString(">", x-gp.tileSize, y);// to put ">" nect to the one players select
		 }
		 
		 text = "LEVELS";
		 x = getXForCenteredText(text);
		 y = gp.tileSize*9;
		 g2.drawString(text, x, y);
		 if(commandNum == 1) {
			 g2.drawString(">", x-gp.tileSize, y);
		 }
		 
		 
		 text = "CONTROLS/INTRUCTION";
		 x = getXForCenteredText(text);
		 y = gp.tileSize*10;
		 g2.drawString(text, x, y);
		 if(commandNum == 2) {
			 g2.drawString(">", x-gp.tileSize, y);
		 }
		 
		 
		 text = "QUIT";
		 x = getXForCenteredText(text);
		 y = gp.tileSize*11;
		 g2.drawString(text, x, y);
		 if(commandNum == 3) {
			 g2.drawString(">", x-gp.tileSize, y);
		 }
	   }
	   else if(titleScreenState == 1) {
		   
		   g2.setColor(Color.white);
		   g2.setFont(g2.getFont().deriveFont(42F));
		   
		   String text = "Select level";
			int x = getXForCenteredText(text);
			int y = gp.tileSize;
		    g2.drawString(text, x, y);
		    
		    text = "LEVEL 1";
		    x = getXForCenteredText(text);
			y = gp.tileSize*3;
		    g2.drawString(text, x, y);
		    if(commandNum == 0) {
				 g2.drawString(">", x-gp.tileSize, y);
			 }
		    text = "LEVEL 2";
		    x = getXForCenteredText(text);
			y = gp.tileSize*4;
		    g2.drawString(text, x, y);
		    if(commandNum == 1) {
				 g2.drawString(">", x-gp.tileSize, y);
			 }
		    text = "LEVEL 3";
		    x = getXForCenteredText(text);
			y = gp.tileSize*5;
		    g2.drawString(text, x, y);
		    if(commandNum == 2) {
				 g2.drawString(">", x-gp.tileSize, y);
			 }
		    text = "LEVEL 4";
		    x = getXForCenteredText(text);
			y = gp.tileSize*6;
		    g2.drawString(text, x, y);
		    if(commandNum == 3) {
				 g2.drawString(">", x-gp.tileSize, y);
			 }
		    text = "LEVEL 5";
		    x = getXForCenteredText(text);
			y = gp.tileSize*7;
		    g2.drawString(text, x, y);
		    if(commandNum == 4) {
				 g2.drawString(">", x-gp.tileSize, y);
			 }
		    text = "BACK";
		    x = getXForCenteredText(text);
			y = gp.tileSize*10;
		    g2.drawString(text, x, y);
		    if(commandNum == 5) {
				 g2.drawString(">", x-gp.tileSize, y);
			 }
	   }
else if(titleScreenState == 2) {
		   
		   g2.setColor(Color.white);
		   g2.setFont(g2.getFont().deriveFont(42F));
		   
		  
		
		 
		   String text = "CONTROLS AND INSTRUCTION";
			int x = getXForCenteredText(text);
			int y = gp.tileSize;
		    g2.drawString(text, x, y);
		    
		
		    //controls 
			   x =  + gp.tileSize;
			   y += gp.tileSize;
			   g2.drawString("Move Up     W", x, y); y+=gp.tileSize;
			   g2.drawString("Move Down   S", x, y); y+=gp.tileSize;
			   g2.drawString("Move Left   A", x, y); y+=gp.tileSize;
			   g2.drawString("Move Right  D", x, y); y+=gp.tileSize;
			   g2.drawString("Refresh     R", x, y); y+=gp.tileSize;
			   g2.drawString("Menu     esc", x, y); y+=gp.tileSize;
			   g2.drawString("Get All Crates To Each Diamond", x, y); y+=gp.tileSize;
			   
		  
		    text = "BACK";
		    x = getXForCenteredText(text);
			y = gp.tileSize*10;
		    g2.drawString(text, x, y);
		    if(commandNum == 0) {
				 g2.drawString(">", x-gp.tileSize, y);
			 }
	   }
		 
		 
	}
   
   public void drawOptionScreen() {
	   
	   g2.setColor(Color.white);
	   g2.setFont(g2.getFont().deriveFont(35F));
	   
	   //sub window 
	   int frameX = gp.tileSize;
	   int frameY = gp.tileSize;
	   int frameWidth = gp.tileSize*8;
	   int frameHeight = gp.tileSize*10;
	   
	   drawSubWindow(frameX, frameY, frameWidth, frameHeight);
	   
	   switch(subState) {
	   case 0: options_top(frameX, frameY);break;
	   case 1: options_control(frameX, frameY);break;
	   case 2: options_endGameConfirmation(frameX, frameY);break;
	   }
	   
	   gp.keyH.enterPressed = false;
	   
		   
   }
   public void options_top(int frameX, int frameY) {
	   int textX;
	   int textY;
	 
	   //title
	   String text = "MENU";
	   textX = frameX + gp.tileSize*3;
	   textY = frameY + gp.tileSize;
	   g2.drawString(text, textX, textY);
	   
	   //controls 
	   textX = frameX + gp.tileSize;
	   textY += gp.tileSize*2;
	   g2.drawString("CONTROLS", textX, textY);
	   if(commandNum == 0) {
			 g2.drawString(">", textX-25, textY);
			 if(gp.keyH.enterPressed == true) {
				 subState = 1;
			     commandNum = 0;//resettiing commandNum to 0
			     
				 
			 }
		 }
	   //end game 
	   textY += gp.tileSize;
	   g2.drawString("END GAME", textX, textY);
	   if(commandNum == 1) {
			 g2.drawString(">", textX-25, textY);
			 if(gp.keyH.enterPressed == true) {
				 subState = 2;
				 commandNum = 0;
			 }
			
		 }
	   
	   //back
	   textY += gp.tileSize*2;
	   g2.drawString("BACK", textX, textY);
	   if(commandNum == 2) {
			 g2.drawString(">", textX-25, textY);
			 if(gp.keyH.enterPressed == true) {
				 gp.gameState = gp.playState;
				 commandNum = 0;
				 
			 }
		 }
	   
   }
   public void options_control(int frameX, int frameY) {
	   int textX;
	   int textY;
	 
	   //title
	   String text = "CONTROLS";
	   textX = frameX + gp.tileSize*3;
	   textY = frameY + gp.tileSize;
	   g2.drawString(text, textX, textY);
	   
	   //controls 
	   textX = frameX + gp.tileSize;
	   textY += gp.tileSize;
	   g2.drawString("Move up     W", textX, textY); textY+=gp.tileSize;
	   g2.drawString("Move down   S", textX, textY); textY+=gp.tileSize;
	   g2.drawString("Move left   A", textX, textY); textY+=gp.tileSize;
	   g2.drawString("Move right  D", textX, textY); textY+=gp.tileSize;
	   g2.drawString("Refresh     R", textX, textY); textY+=gp.tileSize;
	   
	   //back
	   textX = frameX + gp.tileSize;
	   textY += gp.tileSize;
	   g2.drawString("BACK", textX, textY);
	   if(commandNum == 0) {
			 g2.drawString(">", textX-25, textY);
			 if(gp.keyH.enterPressed == true) {
				 subState = 0;
			    commandNum = 0;
			     
				 
			 }
		 }
	   
	   
   }
   public void options_endGameConfirmation(int frameX, int frameY) {
	  int textX = frameX + gp.tileSize;
	  int textY = frameY + gp.tileSize*3;
	  
	  currentDialogue = "Quit the game \nBack to title screen?";
	  
	  for(String line: currentDialogue.split("\n")) {
	  g2.drawString(line, textX, textY);
	  textY+=30;
	  }
	  //yes
	  String text = "YES";
	  textX = frameX + gp.tileSize;
	  textY = gp.tileSize*9;
	    g2.drawString(text, textX, textY);
	    if(commandNum == 0) {
			 g2.drawString(">", textX-25, textY);
			 if(gp.keyH.enterPressed == true) {
				 subState = 0;
			     gp.gameState = gp.titleState;
			     
				 
			 }
		 }
	  
	  //no
	      text = "NO";
		    textX = frameX + gp.tileSize;
			textY= gp.tileSize*10;
		    g2.drawString(text, textX, textY);
		    if(commandNum == 1) {
				 g2.drawString(">", textX-25, textY);
				 if(gp.keyH.enterPressed == true) {
					 subState = 0;
					 commandNum = 1; 
				     
				     
					 
				 }
			 }
		  
	   
   }
  public void drawSubWindow(int x, int y, int width, int height) {
	   
	   Color c = new Color(0,0,0,210);
	   g2.setColor(c);
	   g2.fillRoundRect(x, y, width, height, 35, 35);
	   
	   c = new Color(255,255,255);
	   g2.setColor(c);
	   g2.setStroke(new BasicStroke(5));
	   g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	   
	     
   }

  
   public int getXForCenteredText(String text) {
	   int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
	   int x = gp.screenWidth/2 - lenght/2;
	   return x;
   }
   
	
}

