package test;
import javax.swing.*;


import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizUI extends JFrame {
    public int currentMCQ = 0;
    private int currentFRQ = 0;
    private MCQ currentMCQPanel;
    private FRQ currentFRQPanel;
    private JButton nextButton;
    private JPanel mainPanel;
    private boolean showingMCQ = true;
    private  String[] answers=new String[Constants.QUESTIONS.size()];
    private  String[] selectedAnswers=new String[Constants.QUESTIONS.size()];
    private  String[] FRQAnswers=new String[Constants.FRQ_QUESTIONS.size()];
    private int MCQScore=0;
    private int FRQScore=0;
    private int totalFRQPoints;

    public QuizUI() {
    	for (int i=0;i<Constants.QUESTIONS.size();i++) {
    		answers[i]=Constants.QUESTIONS.get(i).correctAnswer;
    	}
        setTitle("Quiz Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        loadMCQ();

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	if (showingMCQ) {
            		selectedAnswers[currentMCQ]=MCQ.getSelectedAnswer();
                    String selected = currentMCQPanel.getSelectedAnswer();
                    if (selected == null) {
                        JOptionPane.showMessageDialog(null, "Please select an answer.");
                        return;
                    }
                    currentMCQ++;
                    if (currentMCQ < Constants.QUESTIONS.size()) {
                        loadMCQ();
                    } else {
                        showingMCQ = false;
                        loadFRQ();
                    }
                } else {
                    String response = currentFRQPanel.getResponse();
                    FRQAnswers[currentFRQ]=currentFRQPanel.getResponse();
                    Constants.FRQ_QUESTIONS.get(currentFRQ).setResponse(response);
                    currentFRQ++;
                    if (currentFRQ < Constants.FRQ_QUESTIONS.size()) {
                        loadFRQ();
                    } else {
                    	for (int i=0;i<selectedAnswers.length;i++) {
                    		if(selectedAnswers[i].equals(answers[i])) {
                    			MCQScore++;
                    		}
                    	}
                    	System.out.println(MCQScore);
                    	for(int i=0;i<FRQAnswers.length;i++) {
                    		for(int j=0;j<Constants.FRQ_QUESTIONS.get(i).answerKey.length;j++) {
                    			if(FRQAnswers[i]==null) {
                    				FRQScore+=0;
                    			}
                    			else if(FRQAnswers[i].indexOf(Constants.FRQ_QUESTIONS.get(i).answerKey[j])!=-1) {
                    				FRQScore++;
                    				System.out.println("cool");
                    			}
                    			totalFRQPoints++;
                    		}
                    	}
                    	FRQScore*=5;
                    	totalFRQPoints*=5;
                    	double percentage=(double)(MCQScore+FRQScore)/(answers.length+totalFRQPoints);
                    	System.out.println(percentage);
                    	int APScore=0;
                    	if(percentage>0.70) {
                    		APScore=5;
                    	}
                    	else if(percentage>0.60) {
                    		APScore=4;
                    	}
                    	else if(percentage>0.50) {
                    		APScore=3;
                    	}
                    	else if(percentage>0.30) {
                    		APScore=2;
                    	}
                    	else {
                    		APScore=1;
                    	}
                        JOptionPane.showMessageDialog(null, "Quiz complete!\nThank you for your answers.\nyou earned a "+APScore);
                        System.exit(0);
                    }
                }
            }
        });

        mainPanel.add(nextButton, BorderLayout.SOUTH);
        add(mainPanel);
        setVisible(true);
    }
    
    private void loadMCQ() {
        if (currentMCQPanel != null) {
            mainPanel.remove(currentMCQPanel);
        }
        currentMCQPanel = new MCQ(Constants.QUESTIONS.get(currentMCQ));
        mainPanel.add(currentMCQPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void loadFRQ() {
        if (currentMCQPanel != null) {
            mainPanel.remove(currentMCQPanel);
            currentMCQPanel = null;
        }
        if (currentFRQPanel != null) {
            mainPanel.remove(currentFRQPanel);
        }
        currentFRQPanel = new FRQ(Constants.FRQ_QUESTIONS.get(currentFRQ));
        mainPanel.add(currentFRQPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
