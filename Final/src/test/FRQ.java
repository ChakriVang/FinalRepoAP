package test;
import javax.swing.*;
import java.awt.*;

public class FRQ extends JPanel {
    private JTextArea responseArea;
    private JLabel questionLabel;
    private FRQQuestion question;

    public FRQ(FRQQuestion question) {
        this.question = question;
        setLayout(new BorderLayout());

        questionLabel = new JLabel("<html><h3>" + question.getQuestion() + "</h3></html>", SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        responseArea = new JTextArea(8, 40);
        responseArea.setLineWrap(true);
        responseArea.setWrapStyleWord(true);
        add(responseArea, BorderLayout.CENTER);
    }

    public String getResponse() {
        return responseArea.getText().trim();
    }
}
