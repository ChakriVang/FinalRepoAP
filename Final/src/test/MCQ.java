package test;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class MCQ extends JPanel {
    private JLabel questionLabel;
    private static JRadioButton[] options;
    private ButtonGroup group;

    public MCQ(Question questionData) {
        setLayout(new BorderLayout());

        questionLabel = new JLabel("<html><h3>" + questionData.question + "</h3></html>", SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        options = new JRadioButton[4];
        group = new ButtonGroup();

        options[0] = new JRadioButton(questionData.optionA);
        options[1] = new JRadioButton(questionData.optionB);
        options[2] = new JRadioButton(questionData.optionC);
        options[3] = new JRadioButton(questionData.optionD);

        for (int i = 0; i < 4; i++) {
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);
    }
    public static String getSelectedAnswer() {
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                return String.valueOf((char) ('A' + i));                
            }
        }
        return null;
    }
}

