package ui.level2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuUI {

	public void createMenuUI() {
		
		JFrame menuFrame = new JFrame("Main Menu");
		menuFrame.setSize(400, 300);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setLocationRelativeTo(null);

		menuFrame.add(initPanel(menuFrame));
		menuFrame.setVisible(true);

	}
	
	private JPanel initPanel(JFrame menuFrame) {
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());

		menuPanel.add(initLabel(menuFrame), BorderLayout.NORTH);
		menuPanel.add(initButton(menuFrame), BorderLayout.CENTER);
		
		return menuPanel;
	}
	
	private JLabel initLabel(JFrame menuFrame) {
		JLabel welcomeLabel = new JLabel("Welcome to the Main Menu!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		return welcomeLabel;
	}
	
	private JPanel initButton(JFrame menuFrame) {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton option1Button = new JButton("Option 1");
		JButton option2Button = new JButton("Option 2");
		JButton logoutButton = new JButton("Logout");

		buttonPanel.add(option1Button);
		buttonPanel.add(option2Button);
		buttonPanel.add(logoutButton);
		
		logoutButton.addActionListener(e -> handleLogout(menuFrame));
		option1Button.addActionListener(e -> handleOption1(menuFrame));
		option2Button.addActionListener(e -> handleOption2(menuFrame));
		
		return buttonPanel;
	}

	private void handleLogout(JFrame frame) {
		frame.setVisible(false);
	}

	private void handleOption1(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "Option 1 Selected");
	}
	
	private void handleOption2(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "Option 2 Selected");
	}
}
