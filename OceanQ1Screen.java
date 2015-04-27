


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

//import QuizScreen.openQuizButtonListener;


//import SummaryScreen.openQuizButtonListener;


import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OceanQ1Screen extends JPanel implements QInterface{

	private JPanel oq1screen;
	
	private AppletMain applet;

	JTextField userInput;
	
	String[][] question = new String[][]{{"Climate experts predict the average sea level will do what this century?", "C", "A. Fall by about 15 inches", "B. Stay constant", "C. Rise by about 15 inches"}};
	
	String funFact = "Average sea level is expected to rise 7 - 23 inches before the end of this century - and perhaps as much as 31 inches (if, as some models predict, the rate of ice melting from Greenland and Antarctica increases).";
	
	private int points = 7; // random int for testing // this should be 0 for actual
	
	
	class openQuizButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			applet.oq1tooq2();
		}
	}
	
	
	public OceanQ1Screen(AppletMain appletParameter)
	{
		
		
		applet = appletParameter;
		
		oq1screen = new JPanel();
		oq1screen.setBackground(Color.WHITE);
		oq1screen.setLayout(new BorderLayout());
		
		
		
		
		
		JLabel titleSummary = new JLabel("<html>Global climate change is affecting sea life as well!</html>");
		titleSummary.setFont(new Font("Helvetica", Font.BOLD, 32));
		titleSummary.setForeground(Color.BLACK);
		titleSummary.setHorizontalAlignment(JLabel.CENTER);
		titleSummary.setVerticalAlignment(JLabel.CENTER);
		
		
		
		
		
		
		
		//  button to progress to next question
		JPanel oq2ButtonPanel = new JPanel();
		oq2ButtonPanel.setBackground(Color.WHITE);
		JButton oq2Button = new JButton("Next!");
		oq2Button.setFont(new Font("Helvetica", Font.BOLD, 16));
		oq2Button.addActionListener(new openQuizButtonListener());
		oq2ButtonPanel.add(oq2Button);
		
		
		
		JTextArea q = new JTextArea();
		q.setText(question[0][0] + "\n" + question[0][2] + "\n" +  question[0][3] + "\n" + question[0][4]);
		q.setWrapStyleWord(true);
		q.setFont(new Font("Helvetica", Font.BOLD, 20));
		titleSummary.setHorizontalAlignment(JLabel.CENTER);
		titleSummary.setVerticalAlignment(JLabel.CENTER);
		
		userInput = new JTextField(1);
		
		String input = new String();
		
		input = userInput.getText();
		
		TextHandler handler = new TextHandler();
		userInput.addActionListener(handler);
		
		
		
		
		oq1screen.add(titleSummary, BorderLayout.PAGE_START);
		oq1screen.add(q, BorderLayout.CENTER);
		oq1screen.add(oq2ButtonPanel, BorderLayout.PAGE_END);
		
		add(oq1screen);
		
		validate();
		repaint();

		
	}
	
	
	// need a function(s) to display the question, display the answer choices, and update points based on the
	// user's answer
	
	
	private class TextHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == userInput){
				String display = e.getActionCommand();
			}
			//JOptionPane.showMessageDialog(null, display); // this is not working :/
		}
		
	}
	
	
	
	@Override
	public int getPoints() { return points; }


	@Override
	public void displayQuestion() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void printQ() {
		// TODO Auto-generated method stub
		
		
		
		
	}

	@Override
	public boolean isAnswerCorrect(int x, char userAnswer) {
		// TODO Auto-generated method stub
		
		String correct = "Correct!";
		String incorrect = "Incorrect!";
		
		boolean correctAnswer = (userAnswer + "").equalsIgnoreCase(question[x][1]);
		if (correctAnswer){
			JOptionPane.showMessageDialog(this, correct, "Correct!", JOptionPane.YES_NO_OPTION);
			}else{
			JOptionPane.showMessageDialog(this, incorrect, "Incorrect!", JOptionPane.YES_NO_OPTION);
		}
		
		return correctAnswer;
	}


	@Override
	public void displayFunFact() {
		// TODO Auto-generated method stub
		
	};
	
}