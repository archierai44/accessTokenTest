package edu.utsa.cs3443.rowdyquizjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RowdyQuizApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("layouts/rowdy_quiz_main.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        stage.setTitle("Rowdy Quiz"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.show(); // display the stage
    }

    public static void main(String[] args) {
        // create a RowdyQuiz object and call its start method
        launch(args);
    }
}