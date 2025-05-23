package test;

public class FRQQuestion {
    String question;
    String response;
    String answerKey[];

    public FRQQuestion(String question) {
        this.question = question;
        this.response = "";
    }
    public FRQQuestion(String question,String A1) {
        this.question = question;
        this.response = "";
        answerKey=new String[1];
        answerKey[0]=A1;
    }
    public FRQQuestion(String question,String A1,String A2) {
        this.question = question;
        this.response = "";
        answerKey=new String[2];
        answerKey[0]=A1;
        answerKey[1]=A2;
    }
    public FRQQuestion(String question,String A1,String A2,String A3) {
        this.question = question;
        this.response = "";
        answerKey=new String[3];
        answerKey[0]=A1;
        answerKey[1]=A2;
        answerKey[2]=A3;
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
