package project;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.io.*;

public class WordsPage extends JFrame{

	String fileName;
	String[] wordsLeftColumn = {"Vase","Tiger","Book","Cushion","Piano","Hat"};
	String[] wordsRightColumn = {"Teapot","Camera","Ice Cream","Spade","House","Orange"};
	public String leftColumn = "";
	public String rightColumn = "";	
	
	public WordsPage()
	{
		super("Words");
		setLayout(new FlowLayout());

		String Columns = addWords();
		String output[] = Columns.split("\n");

		for(int i = 0; i < 6; i++){
			leftColumn = leftColumn.concat(output[i] + "\n");
		}

		for(int i = 6; i < 12; i++){
			rightColumn = rightColumn.concat(output[i] + "\n");
		}
		
		JTextPane column1 = new JTextPane();
		JTextPane column2 = new JTextPane();
		column1.setText(leftColumn);
		column2.setText(rightColumn);
		column1.setFont(new Font("Serif", Font.PLAIN, 20));
		column2.setFont(new Font("Serif", Font.PLAIN, 20));
		column1.setEditable(false);
		column2.setEditable(false);
		add(column1, BorderLayout.WEST);
		add(column2, BorderLayout.EAST);
		
	}
	
	public String addWords(){
		
		fileName = "words.txt";
		String line = null;
		String column = "";
		
		try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);

            while((line = br.readLine()) != null) {
            	column = column.concat(line + "\n");
            }
            
            br.close(); 
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ fileName + "'");
        }
		return column;
	}
	
}
