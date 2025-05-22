package test;

public class FRQQuestion {
    String question;
    String response;

    public FRQQuestion(String question) {
        this.question = question;
        this.response = "";
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public String getQuestion() {
        return question;
    }
}
