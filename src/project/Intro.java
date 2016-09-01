package project;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.JTextArea;
import java.awt.*;

public class Intro extends JFrame{
	
	private JTextArea introductionArea;
	public JButton start;
	public JButton admin;
	private JTextField username;
    private JPasswordField password;
    public JButton loginBtn;
	
	public Intro(){
		super("Short-Term Memory Experiment");
		setLayout(new FlowLayout());
		
		String introMessage = new String();
		introMessage = "Welcome to this short-term memory experiment. In the next screen you will see 12 words which will disappear after 30 seconds. After this time, you will be prompted to write down as many words from the list of 12 as you remember. Hit Start to begin.";
		
		introductionArea = new JTextArea(5, 20);
		introductionArea.setText(introMessage);
		introductionArea.setLineWrap(true);
		introductionArea.setWrapStyleWord(true);
		introductionArea.setEditable(false);
		add(introductionArea);
		
		start = new JButton("start");
		add(start);
		
		admin = new JButton("admin");
		add(admin);
		
		handler handler1 = new handler();
		start.addActionListener(handler1);
		
		adminHandler adminHandler1 = new adminHandler();
		admin.addActionListener(adminHandler1);			
	}

	
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			setVisible(false);
		}
	}
	
	private class adminHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JFrame login = new JFrame();
			username = new JTextField(20);
			password = new JPasswordField(20);
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		    loginBtn = new JButton("Login");
			panel.add(username, BorderLayout.NORTH);
			panel.add(password, BorderLayout.CENTER);
			panel.add(loginBtn, BorderLayout.SOUTH);
			username.setText("Username");
            password.setText("Password");
            login.getContentPane().add(BorderLayout.CENTER, panel);
            login.setSize(200,120);
            login.setVisible(true);
            login.setLocationRelativeTo(null);
			
			loginBtn.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e) {
	                if (authenticate(username.getText(), getPassword())) {
	                	adminPage adminWindow = new adminPage();
	                	adminWindow.setVisible(true);
	                }
	                else{
	                	 JOptionPane.showMessageDialog(login ,"wrong unsername or password");
	                     username.setText("Username");
	                     password.setText("Password");
	                }
	            }
			});
		}
	}
	
	public String getPassword() {
        return new String(password.getPassword());
    }
	
	public static boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
	
}
	
	