package edu.utsa.cs3443.rowdyquizjavafx.model;

public class Question {

    private final String prompt; // is today a quiet day?
    private final String answer; // t/f

    public Question(String prompt, String answer) {
        this.prompt = prompt;
        this.answer = answer;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getAnswer() {
        return answer;
    }
}