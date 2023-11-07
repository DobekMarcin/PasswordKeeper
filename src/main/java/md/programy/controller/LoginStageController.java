package md.programy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import md.programy.modelFX.UserModel;
import md.programy.stage.LoginStage;

import java.io.IOException;
import java.util.ResourceBundle;


public class LoginStageController {


    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwordTextField;
    private UserModel userModel = new UserModel();
    private Stage stage;


    public void initialize(){
        userModel.createAdmin();
        bindings();
    }

    private void bindings() {
        userModel.getUserFx().loginProperty().bind(loginTextField.textProperty());
        userModel.getUserFx().passwordProperty().bind(passwordTextField.textProperty());
    }

    @FXML
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        Boolean result = userModel.checkUser();
        if(result==true){
            stage.close();

        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
