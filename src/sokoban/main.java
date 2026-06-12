package sokoban;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the window properly
		window.setResizable(false);//unable to resize the window
		window.setTitle("Sokoban");//the name
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();// to fit the preferred size and layouts of its subcomponents
		
		window.setLocationRelativeTo(null);//center of the screen
		window.setVisible(true);//to see the window 
		
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}

}
