package edu.utsa.cs3443.rowdyquizjavafx.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions;
    private int qIndex;
    private Question currentQuestion;

    public Quiz(){
        questions = new ArrayList<Question>();
        qIndex = 0;
        currentQuestion = null;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getqIndex() {
        return qIndex;
    }

    public void setqIndex(int qIndex) {
        this.qIndex = qIndex;
    }

    public void updateCurrentQuestion(){
        if(getqIndex() >= 0 && getqIndex() < questions.size() ) {
            currentQuestion = questions.get(getqIndex());
            setqIndex(getqIndex() + 1);
        }
        else{
            setqIndex(0);
            currentQuestion = questions.get(getqIndex());
        }
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public boolean isCorrectAnswer(String answer){
        return currentQuestion.getAnswer().equals(answer);
    }

    public void addQuestion(Question question){

        if(questions != null)
            questions.add(question);
    }

    public void loadQuestions() {
//        addQuestion(new Question("UTSA is an R1 University", "true"));
//        addQuestion(new Question("UTSA colors are green and blue", "false"));
//        addQuestion(new Question("UTSA mascot is a turkey", "false"));

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("data/questions.csv"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                addQuestion(new Question(tokens[0], tokens[1].trim()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }
}
