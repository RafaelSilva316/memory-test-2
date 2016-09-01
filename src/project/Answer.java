package project;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Answer extends JFrame{

	JTextField answerBox;
	private JTextArea instructions;
	JList answerList;
	JTextArea results;
	int score = 0;
	String[] words = {"vase","tiger","book","cushion","piano","hat","teapot","camera","ice cream","spade","house","orange"};
	List<String> userAnswers = new ArrayList<String>();
	public Formatter resultsFile;
	public int timesTaken = 0;
	
	public Answer(){
		super("Answer");
		setLayout(new FlowLayout());
		answerBox = new JTextField(15);
		JButton adder = new JButton("add word");
		JButton submit = new JButton("submit");
		results = new JTextArea(10, 15);
		
		String instructionText = new String();
		instructionText = "Please write down as many words as you can remember, hitting the add word button after each word.\n\n Hit the *Submit* button when finished to see your score.";
		
		instructions = new JTextArea(5, 20);
		instructions.setText(instructionText);
		instructions.setLineWrap(true);
		instructions.setWrapStyleWord(true);
		instructions.setEditable(false);
		add(instructions);
		
		addHandler handler1 = new addHandler();
		adder.addActionListener(handler1);
		
		handler2 handlerSubmit = new handler2();
		submit.addActionListener(handlerSubmit);
		
		add(answerBox);
		add(adder);
		add(submit);
		add(results);
		
		JRootPane rootPane = this.getRootPane();
	    rootPane.setDefaultButton(adder);
	}
	
	private class addHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(userAnswers.contains(answerBox.getText())){
					JOptionPane.showMessageDialog(answerBox ,"you already wrote that word");
			}
			else{
				results.setText(results.getText() + "\n" + answerBox.getText());
				userAnswers.add(answerBox.getText().toLowerCase());
			}
			answerBox.requestFocusInWindow();
			answerBox.setText("");
		}
	}
	
	public void grade()
	{
		for(String word: words)
		{
			if(userAnswers.contains(word.toLowerCase()))
			{
				score = score + 1;
			}
		}
		appendFile();
	}
	
	private class handler2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			setVisible(false);
			grade();
			JOptionPane.showMessageDialog(answerBox ,"your score is " + score + " out of 12.");
		}
	}

	public void appendFile(){
		File f = new File("C:\\Users\\Owner\\workspace\\shortTerm\\results.txt");
		if(f.exists()){
			BufferedWriter bw = null;
			
			try {
				bw = new BufferedWriter(new FileWriter(f, true));
				bw.write(score + "");
				bw.newLine();
				bw.flush();
			} 
			catch(IOException ioe){
				ioe.printStackTrace();
		    }
			finally{
				if (bw != null)
					try {
						bw.close();
					}
					catch(IOException ioe2){
						System.out.println("Couldnt close");
					}
		    	}
		 	}
		 	else{
		 		try{ 
		 			resultsFile = new Formatter("Results.txt");
		 			System.out.println("results.txt created");
		 		}
		 		catch(Exception e){
		 			System.out.println("Error");
		 		}
		 		resultsFile.close();
		 		appendFile();
		 	}
		}
	}
