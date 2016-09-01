package project;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Main extends JFrame{
	
	static Timer timer = new Timer();
	
	public static void main(String[] args)
	{
		WordsPage window2 = new WordsPage();
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window2.setSize(300,250);
		window2.getContentPane().setBackground(Color.WHITE);
		window2.setVisible(false);
		window2.setLocationRelativeTo(null);
		
		Intro window1 = new Intro();
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window1.setSize(300,200);
		window1.getContentPane().setBackground(Color.WHITE);
		window1.setVisible(true);
		window1.setLocationRelativeTo(null);
		
		Answer window3 = new Answer();
		window3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window3.setSize(300,400);
		window3.getContentPane().setBackground(Color.WHITE);
		window3.setVisible(false);
		window3.setLocationRelativeTo(null);
		
		while(window1.isVisible())
		{
			window2.setVisible(false);
		}
		window2.setVisible(true);
		
		timer.schedule(new TimerTask() {	
			public void run(){
				window2.setVisible(false);
				window3.setVisible(true);
			}
		}, 2000);
		//newSession();
		
	}
}
