package test;

public class FRQQuestion extends BaseQuestion {
    String response;
    String[] answerKey;

    public FRQQuestion(String question) {
        super(question);
        this.response = "";
    }

    public FRQQuestion(String question, String A1) {
        this(question);
        answerKey = new String[]{A1};
    }

    public FRQQuestion(String question, String A1, String A2) {
        this(question);
        answerKey = new String[]{A1, A2};
    }

    public FRQQuestion(String question, String A1, String A2, String A3) {
        this(question);
        answerKey = new String[]{A1, A2, A3};
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
