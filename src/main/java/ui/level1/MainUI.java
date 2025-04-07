package ui.level1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Exercise and Objective - DRY, Inheritance and Polymorphism learning

//Hint: 
//1. Create a abstract class for MenuUI.java and LoginUI.java
//2. LoginUI.java abstract with implementation

//Time Frame
//15 minutes read the code
//30 minutes work on it
//30 minutes code review and work together 

public class MainUI extends JFrame {

	public static LoginUI loginUI  = new LoginUI(); 
	public static MenuUI menuUI = new MenuUI(); 
	
	public MainUI() {
		MainUI.loginUI.setVisible(true);
		MainUI.loginUI.login();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainUI();
			}
		});
	}
}