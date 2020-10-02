import animatefx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppIntializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        Parent stage = FXMLLoader.load(this.getClass().getResource("view/InstructorForm.fxml"));
        primaryStage.setScene(new Scene(stage));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        new FadeIn(stage).play();


    }
}
