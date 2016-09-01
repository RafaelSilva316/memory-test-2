package project;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.Formatter;

public class adminPage extends JFrame{

	public JTextField word1;
	public JTextField word2;
	public JTextField word3;
	public JTextField word4;
	public JTextField word5;
	public JTextField word6;
	public JTextField word7;
	public JTextField word8;
	public JTextField word9;
	public JTextField word10;
	public JTextField word11;
	public JTextField word12;
	String fileName;
	String fN;
	public JButton changeWords;
	public Formatter wordsFile;
	
	public adminPage(){
		
		super("Admin");
		
		word1 = new JTextField(20);
		word2 = new JTextField(20);
		word3 = new JTextField(20);
		word4 = new JTextField(20);
		word5 = new JTextField(20);
		word6 = new JTextField(20);
		word7 = new JTextField(20);
		word8 = new JTextField(20);
		word9 = new JTextField(20);
		word10 = new JTextField(20);
		word11 = new JTextField(20);
		word12 = new JTextField(20);
		
		changeWords = new JButton("Change");
		add(changeWords);
		
		changer wordChanger = new changer();
		changeWords.addActionListener(wordChanger);
		
		add(word1);
		add(word2);
		add(word3);
		add(word4);
		add(word5);
		add(word6);
		add(word7);
		add(word8);
		add(word9);
		add(word10);
		add(word11);
		add(word12);
		
		String Columns = addWords();
		System.out.println("adminpage: " + Columns);
		String output[] = Columns.split("\n");
		
		word1.setText(output[0]);
		word2.setText(output[1]);
		word3.setText(output[2]);
		word4.setText(output[3]);
		word5.setText(output[4]);
		word6.setText(output[5]);
		word7.setText(output[6]);
		word8.setText(output[7]);
		word9.setText(output[8]);
		word10.setText(output[9]);
		word11.setText(output[10]);
		word12.setText(output[11]);

		fileName = "Results.txt";
		String line = null;
		double sum = 0.0;
		int number = 0;
		
		try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);

            while((line = br.readLine()) != null) {
                sum = sum + Integer.parseInt(line);
                number = number + 1;
            }   

            br.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ fileName + "'");
        }
		
		double averageScore = sum/number;
		JLabel avg = new JLabel("Average Score: " + averageScore);
		JLabel num = new JLabel("Times Taken: " + number);
		add(avg);
		add(num);
		
		setLayout(new FlowLayout());
		setVisible(false);
		setSize(300,400);
		setLocationRelativeTo(null);
		
	}
	
	private class changer implements ActionListener{
		public void actionPerformed(ActionEvent event){
			changeFile();
		}
	}
	
	public void changeFile(){
		File f = new File("C:\\Users\\Owner\\workspace\\shortTerm\\words.txt");
		
		if(f.exists()){
			BufferedWriter bw = null;
			
			try {
				bw = new BufferedWriter(new FileWriter(f, false));
				bw.write(word1.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word2.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word3.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word4.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word5.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word6.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word7.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word8.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word9.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word10.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word11.getText() + "");
				bw.newLine();
				bw.flush();
				bw.write(word12.getText() + "");
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
				wordsFile = new Formatter("words.txt");
				System.out.println("words.txt created");
			}
			catch(Exception e){
				System.out.println("Error");
			}

			wordsFile.close();
			changeFile();
		}
	}
	
	public String addWords(){
		
		fN = "words.txt";
		String line = null;
		String column = "";
		
		try {
            FileReader fileReader = new FileReader(fN);
            BufferedReader br = new BufferedReader(fileReader);

            while((line = br.readLine()) != null) {
            	column = column.concat(line + "\n");
            	//System.out.println(column);
            }
            
            br.close(); 
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fN + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ fN + "'");
        }
		return column;
	}
		
}
