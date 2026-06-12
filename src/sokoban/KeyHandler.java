package sokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	GamePanel gp;
public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	boolean showDebugText = false;
	//contructor
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

        }


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
      int code = e.getKeyCode();

      //title state
      if(gp.gameState == gp.titleState) {
    	  titleState(code);
      }
      //play state
      else if(gp.gameState == gp.playState) {
     	 playState(code);
      }
      //options state
      else if(gp.gameState == gp.optionState) {
      	 optionState(code);
       }

	}


	public void titleState(int code) {

		//titleState
		 if(gp.ui.titleScreenState == 0) {

	    	  if(code == KeyEvent.VK_W) { //to go up when pressed
	  			 gp.ui.commandNum--;
	  			 if(gp.ui.commandNum < 0) {
	  				 gp.ui.commandNum = 3;
	  			 }

	  		}
	          if(code == KeyEvent.VK_S) {//to go down when pressed
	  			gp.ui.commandNum++;
	  			if(gp.ui.commandNum > 3) {
	 				 gp.ui.commandNum = 0;
	          }
	      }
	          if (code == KeyEvent.VK_ENTER) {
	                if (gp.ui.commandNum == 0) {
	                    gp.currentMap = 0;
	                    gp.setPlayerPosition();
	                    gp.gameState = gp.playState;
	                } else if (gp.ui.commandNum == 1) {
	                    gp.ui.titleScreenState = 1;
	                } else if (gp.ui.commandNum == 2) {
	                    gp.ui.titleScreenState = 2;
	                } else if (gp.ui.commandNum == 3) {
	                    System.exit(0);
	                }
	            }
		 } else if (gp.ui.titleScreenState == 1) {
	            if (code == KeyEvent.VK_W) {
	                gp.ui.commandNum--;
	                if (gp.ui.commandNum < 0) {
	                    gp.ui.commandNum = 5;
	                }
	            }
	            if (code == KeyEvent.VK_S) {
	                gp.ui.commandNum++;
	                if (gp.ui.commandNum > 5) {
	                    gp.ui.commandNum = 0;
	                }
	            }
	            if (code == KeyEvent.VK_ENTER) {
	                if (gp.ui.commandNum == 0) {
	                    gp.currentMap = 0;
	                    gp.setPlayerPosition();
	                    gp.gameState = gp.playState;
	                } else if (gp.ui.commandNum == 1) {
	                    gp.currentMap = 1;
	                    gp.setPlayerPosition();
	                    gp.gameState = gp.playState;
	                } else if (gp.ui.commandNum == 2) {
	                    gp.currentMap = 2;
	                    gp.setPlayerPosition();
	                    gp.gameState = gp.playState;
	                } else if (gp.ui.commandNum == 3) {
	                    gp.currentMap = 3;
	                    gp.setPlayerPosition();
	                    gp.gameState = gp.playState;
	                } else if (gp.ui.commandNum == 4) {
	                    gp.currentMap = 4;
	                    gp.setPlayerPosition();
	                    gp.gameState = gp.playState;
	                } else if (gp.ui.commandNum == 5) {
	                    gp.ui.titleScreenState = 0;
	                }
	            }
	        } else if (gp.ui.titleScreenState == 2) {
	            if (code == KeyEvent.VK_W) {
	                gp.ui.commandNum--;
	                if (gp.ui.commandNum < 0) {
	                    gp.ui.commandNum = 0;
	                }
	            }
	            if (code == KeyEvent.VK_S) {
	                gp.ui.commandNum++;
	                if (gp.ui.commandNum > 0) {
	                    gp.ui.commandNum = 0;
	                }
	            }
	            if (code == KeyEvent.VK_ENTER) {
	                if (gp.ui.commandNum == 0) {
	                    gp.ui.titleScreenState = 0;
	                }
	            }
	        }
	    }


	   public void playState(int code) {
			//play state

				if(code == KeyEvent.VK_W) { //to go up when pressed
					upPressed = true;
				}
		        if(code == KeyEvent.VK_S) {//to go down when pressed
					downPressed = true;
				}
		        if(code == KeyEvent.VK_A) {//to go left when pressed
			        leftPressed = true;
		        }
		        if(code == KeyEvent.VK_D) {// to right when pressed
			        rightPressed = true;
		        }
		        if(code == KeyEvent.VK_ESCAPE) {//to bring up the option menu
			       gp.gameState = gp.optionState;
		        }
				if(code == KeyEvent.VK_T) {
				  if(showDebugText == false) {
				      showDebugText = true;
				    	  }
				    	  else if(showDebugText == true) {
				    		  showDebugText = false;
				    	  }
				    		  
				}   	  
				  if (code == KeyEvent.VK_R) { // Refresh the map when 'R' is pressed
				        refreshMap();
				    }
				}

				private void refreshMap() {
				    switch (gp.currentMap) {
				    case 0:
			            gp.tileM.loadMap("/maps/map01.txt", 0);
			            gp.setPlayerPosition();
			            break;
			        case 1:
			            gp.tileM.loadMap("/maps/map02.txt", 1);
			            gp.setPlayerPosition();
			            break;
			        case 2:
			            gp.tileM.loadMap("/maps/map03.txt", 2);
			            gp.setPlayerPosition();
			            break;
			        case 3:
			            gp.tileM.loadMap("/maps/map04.txt", 3);
			            gp.setPlayerPosition();
			            break;
			        case 4:
			            gp.tileM.loadMap("/maps/map05.txt", 4);
			            gp.setPlayerPosition();
			            break;
				    }

				    // Reset player and NPC positions if needed
				    gp.player.setDefaultValues();
				    gp.aSetter.setNPC();
				    gp.aSetter.setInteractiveTile();
				}


		      
	   public void optionState(int code) {

		   if(code == KeyEvent.VK_ESCAPE) {	//to bring up the option menu
		       gp.gameState = gp.playState;
	        }
		   if(code == KeyEvent.VK_ENTER) {
		       enterPressed = true;
	        }
		   
		   int maxCommandNum = 0;
		   switch(gp.ui.subState) {
		   case 0: maxCommandNum = 2; 
		   break;
		   case 2: maxCommandNum = 1; //to select the yes N no 
		   break;
		 
		   }
		   if(code == KeyEvent.VK_W) { //to go up when pressed
		  	 gp.ui.commandNum--;
		   if(gp.ui.commandNum < 0) {
		  		 gp.ui.commandNum = maxCommandNum;
		  	 }

		  	}
		   if(code == KeyEvent.VK_S) {//to go down when pressed
		  			gp.ui.commandNum++;
		 	if(gp.ui.commandNum > maxCommandNum) {
		 		 gp.ui.commandNum = 0;
		          }
		      }
		   
		   
	   }


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
int code = e.getKeyCode();

		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
        if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
        if(code == KeyEvent.VK_A) {
	        leftPressed = false;
        }
        if(code == KeyEvent.VK_D) {
	        rightPressed = false;
        }
	}

}


