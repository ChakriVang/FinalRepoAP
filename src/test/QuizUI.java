package test;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizUI extends JFrame {
    private int currentMCQ = 0;
    private int currentFRQ = 0;
    private MCQ currentMCQPanel;
    private FRQ currentFRQPanel;
    private JButton nextButton;
    private JPanel mainPanel;
    private boolean showingMCQ = true;

    public QuizUI() {
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
                    Constants.FRQ_QUESTIONS.get(currentFRQ).setResponse(response);
                    currentFRQ++;
                    if (currentFRQ < Constants.FRQ_QUESTIONS.size()) {
                        loadFRQ();
                    } else {
                        JOptionPane.showMessageDialog(null, "Quiz complete!\nThank you for your answers.");
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
