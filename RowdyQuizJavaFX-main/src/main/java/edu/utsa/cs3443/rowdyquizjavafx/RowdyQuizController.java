package edu.utsa.cs3443.rowdyquizjavafx;
/**
 * Controller that handles Button events
 */

import edu.utsa.cs3443.rowdyquizjavafx.model.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RowdyQuizController {

        // GUI controls defined in FXML and used by the controller's code
        @FXML private Label answerIndicatorLabel;

        @FXML private Label promptLabel;

        // model references
        private Quiz quiz;


        // if present, called by FXMLLoader to initialize the controller
        @FXML
        private void initialize() {
            quiz = new Quiz();
            quiz.loadQuestions();
            updateQuestionDisplay();
        }

        @FXML
        public void trueButtonPressed(ActionEvent event) {

            if(quiz.isCorrectAnswer("true"))
                answerIndicatorLabel.setText("Correct!");
            else
                answerIndicatorLabel.setText("Incorrect!");
        }

        @FXML
        public void falseButtonPressed(ActionEvent event) {

            if(quiz.isCorrectAnswer("false"))
                answerIndicatorLabel.setText("Correct!");
            else
                answerIndicatorLabel.setText("Incorrect!");
        }

        @FXML
        public void nextButtonPressed(ActionEvent event) {
            updateQuestionDisplay();
        }

        private void updateQuestionDisplay(){
            quiz.updateCurrentQuestion();
            promptLabel.setText(quiz.getCurrentQuestion().getPrompt());
            answerIndicatorLabel.setText("");
        }
    }

