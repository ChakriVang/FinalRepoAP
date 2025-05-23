package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
    public static ArrayList<Question> QUESTIONS = new ArrayList<>(Arrays.asList(
        new Question("What is 2 + 2?", "3", "4", "5", "6", "B"),
        new Question("What is the capital of France?", "Berlin", "London", "Paris", "Rome", "C")
    ));

    public static ArrayList<FRQQuestion> FRQ_QUESTIONS = new ArrayList<>(Arrays.asList(
        new FRQQuestion("What is life?", "Hello")
    ));
}
