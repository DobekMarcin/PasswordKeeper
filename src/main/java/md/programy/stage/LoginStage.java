package md.programy.stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import md.programy.controller.LoginStageController;

import java.util.ResourceBundle;

public class LoginStage extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(LoginStage.class.getResource("/FXML/MainStage.fxml"));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("BUNDLES.messages");
        fxmlLoader.setResources(ResourceBundle.getBundle("BUNDLES.messages"));
        Scene scene = new Scene(fxmlLoader.load());
        LoginStageController loginStageController = fxmlLoader.getController();
        loginStageController.setStage(stage);
        stage.setScene(scene);
        stage.setTitle(resourceBundle.getString("title.app"));
        stage.setResizable(false);
        stage.show();
    }
}
