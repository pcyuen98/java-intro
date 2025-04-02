package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

// Exercise - Identify area to move into a new class
// Objective #1 - Make the code smaller, reusable and more readable
// Objective #2 - Usages of static class

//SRP – Single Responsibility Principle

// Hint: 
// 1. Separate the code into smaller module/method
// 2. Move Listener into another method
// 3. Separate the listener into another method
// 4. Create new class for specific function. i.e. login or menu only
// 5. Create static class for login or menu JFrame

// Time Frame
// 15 minutes read the code
// 30 minutes work on it
// 30 minutes code review and work together 
public class MainUI extends JFrame {

	public MainUI() {
		login();
	}

	public void login() {

		JButton loginButton;
		JTextField usernameField;
		JPasswordField passwordField;

		setTitle("Login - #Login=" + LoginStorage.noOfLogin);
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center the window

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		JLabel usernameLabel = new JLabel("Username:");
		usernameField = new JTextField();

		JLabel passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField();

		loginButton = new JButton("Login");

		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(new JLabel()); // Empty label for spacing
		panel.add(loginButton);

		add(panel);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				char[] password = passwordField.getPassword();
				String passwordStr = new String(password);

				// Basic authentication logic (replace with your actual logic)
				if (LoginUtil.checkLogin(username, passwordStr)) {
					JOptionPane.showMessageDialog(MainUI.this, "Login successful! at " + LoginUtil.getDate());
					LoginStorage.noOfLogin++;
					// Add code to open the next window or perform other actions
					createMenuUI();
				} else {
					JOptionPane.showMessageDialog(MainUI.this,
							"Login failed. Incorrect username or password." + LoginUtil.getDate());
				}

				// Clear password field after login attempt
				passwordField.setText("");
			}
		});
	}

	private void createMenuUI() {

		JFrame menuFrame;

		menuFrame = new JFrame("Main Menu");
		menuFrame.setSize(400, 300);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setLocationRelativeTo(null);

		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());

		JLabel welcomeLabel = new JLabel("Welcome to the Main Menu!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton option1Button = new JButton("Option 1");
		JButton option2Button = new JButton("Option 2");
		JButton logoutButton = new JButton("Logout");

		buttonPanel.add(option1Button);
		buttonPanel.add(option2Button);
		buttonPanel.add(logoutButton);

		menuPanel.add(welcomeLabel, BorderLayout.NORTH);
		menuPanel.add(buttonPanel, BorderLayout.CENTER);

		menuFrame.add(menuPanel);
		menuFrame.setVisible(true);

		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuFrame.setVisible(false);
				// login();
			}
		});

		option1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(menuFrame, "Option 1 Selected");
			}
		});

		option2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(menuFrame, "Option 2 Selected");
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainUI().setVisible(true);
			}
		});
	}
}