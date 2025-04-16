package ui.level2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Exercise and Objective - DRY, Inheritance, and Polymorphism learning.
 * Abstract class often associated with the factory design pattern.
 * <p>
 * <b>Exercise 1 - Implement the abstract method from LoginUI.java:</b>
 * <p> 
 * 1. Create LoginUIMsia.java
 * <pre><code>
 * public class LoginUIMsia extends LoginUI { }
 * </code></pre>
 * Implement the method with Malay wording:
 * <pre><code>
 * public void initFrame() {
 * setTitle("Log Masuk - #Login=" + LoginStorage.noOfLogin);
 * }
 * </code></pre>
 * Init MainUI with static value below:
 * <pre><code>
 * public static LoginUIMsia loginUI  = new LoginUIMsia();
 * </code></pre>
 *
 * <b>Exercise 2 - Reuse the rest and Rewrite only one method handleLogin() with Malay output.</b>
 * <p>
 * <b>Exercise 3 - Change handleLogin() to an abstract method for code cleanup.</b>
 * <p>
 * <b>Exercise 4 - Change MenuUI to abstract factory and code standard as LoginUI:</b>
 * <p>
 * Move MenuUI to factory package and as abstract class. Do similar exercise as 1-3 above 
 * <p>
 * Upon Completion - Compare Level 2 completed code and level 0 improvement difference. Discussion session
 *
 * @author CY
 * @version 1.0
 * @since [Insert version here, e.g., "1.0"]
 */


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