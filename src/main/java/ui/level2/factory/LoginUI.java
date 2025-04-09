package ui.level2.factory;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.level2.MainUI;
import ui.level2.util.LoginStorage;
import ui.level2.util.LoginUtil;

public abstract class LoginUI extends JFrame implements UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JButton loginButton = new JButton("Login");
	
	public void login() {
		
		initDefault();
		JPanel panel = initPanel();
		add(panel);
		addButtonListener();
	}

	@Override
	public void initDefault() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initFrame();
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 2));

		panel.add(new JLabel("Username:"));
		panel.add(usernameField);
		panel.add(new JLabel("Password:"));
		panel.add(passwordField);
		panel.add(new JLabel()); // Spacer
		panel.add(loginButton);

		return panel;
	}

	@Override
	public void addButtonListener() {
		loginButton.addActionListener(e -> handleLogin());
	}

	private void handleLogin() {
		String username = usernameField.getText();
		String passwordStr = new String(passwordField.getPassword());

		if (LoginUtil.checkLogin(username, passwordStr)) {
			JOptionPane.showMessageDialog(this, "Login successful! at " + LoginUtil.getDate());
			LoginStorage.noOfLogin++;
			MainUI.loginUI.setVisible(false);
			MainUI.menuUI.createMenuUI();
		} else {
			JOptionPane.showMessageDialog(this, "Login failed. Incorrect username or password." + LoginUtil.getDate());
		}
		passwordField.setText("");
	}
	
	public abstract void initFrame();
}
