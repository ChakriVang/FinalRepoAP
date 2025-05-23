package test;

public abstract class BaseQuestion {
    protected String question;

    public BaseQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}

