package ui.level2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuUI extends JFrame {

	JButton option1Button = new JButton("Option 1");
	JButton option2Button = new JButton("Option 2");
	JButton logoutButton = new JButton("Logout");
	
	public void createMenuUI() {
		
		initDefault();
		JPanel panel = initPanel();
		add(panel);
		addButtonListener();
		this.setVisible(true);
	}
	
	private void initDefault() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Main Menu");
		setSize(400, 300);
	}
	
	private JPanel initPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(initLabel(), BorderLayout.NORTH);
		panel.add(initButton(), BorderLayout.CENTER);
		return panel;
	}
	
	private JLabel initLabel() {
		JLabel welcomeLabel = new JLabel("Welcome to the Main Menu!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		return welcomeLabel;
	}
	
	private void addButtonListener() {
		logoutButton.addActionListener(e -> handleLogout());
		option1Button.addActionListener(e -> handleOption1());
		option2Button.addActionListener(e -> handleOption2());
	}
	
	private JPanel initButton() {
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(option1Button);
		buttonPanel.add(option2Button);
		buttonPanel.add(logoutButton);
		
		return buttonPanel;
	}

	private void handleLogout() {
		this.setVisible(false);
		MainUI.loginUI.setVisible(true);
	}

	private void handleOption1() {
		JOptionPane.showMessageDialog(this, "Option 1 Selected");
	}
	
	private void handleOption2() {
		JOptionPane.showMessageDialog(this, "Option 2 Selected");
	}
}

