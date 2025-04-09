package ui.level2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Exercise and Objective - DRY, Inheritance and Polymorphism learning
// Abstract class often associate with factory design pattern

//Hint: 
//1. Move MenuUI to factory package and as abstract class. Use LoginUI level 2 as sample
//2. MenuUI has 2 abstract method createMenuUI and initLabel 
//3. Create MenuUIMsia.java then extends MenuUI.java and implement the #2. abstract method. 
// Then display message in specific country language. i.e. Welcome to the Main Menu! --> Selamat Datang ke Menu Utama

// Upon Completion - Compare Level 2 completed code and level 0 improvement difference. Discussion session

//Time Frame
//15 minutes read the code
//30 minutes work on it
//30 minutes code review and work together 

public class MainUI extends JFrame {

	public static LoginUIMsia loginUI  = new LoginUIMsia(); 
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