package md.programy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import md.programy.modelFX.UserModel;
import md.programy.stage.LoginStage;
import md.programy.utils.Utils;

import java.io.IOException;
import java.util.ResourceBundle;


public class LoginStageController {


    public static final String FXML_MAIN_STAGE_FXML = "/FXML/MainStage.fxml";
    @FXML
    private Button logInButton;
    @FXML
    private Label noLogLabel;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwordTextField;
    private UserModel userModel = new UserModel();
    private Stage stage;


    public void initialize(){
        bindings();
        userModel.createAdmin();
        setListeners();
        setToolTip();
    }

    private void setListeners() {
        loginTextField.textProperty().addListener(observable -> noLogLabel.setText(""));
        passwordTextField.textProperty().addListener(observable -> noLogLabel.setText(""));
        loginTextField.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                loginOnAction();
            }
        });
        passwordTextField.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                loginOnAction();
            }
        });
    }

    private void setToolTip() {
        loginTextField.setTooltip(new Tooltip(Utils.getResourceBundle().getString("log.in.default")));
        passwordTextField.setTooltip(new Tooltip(Utils.getResourceBundle().getString("log.in.default")));
    }

    private void bindings() {
        userModel.getUserFx().loginProperty().bind(loginTextField.textProperty());
        userModel.getUserFx().passwordProperty().bind(passwordTextField.textProperty());
    }

    @FXML
    public void loginOnAction() {
        Boolean result = userModel.checkUser();
        if(result==true){
            stage.close();
            openMainStage();
        }else{
            noLogLabel.setText(Utils.getResourceBundle().getString("log.in.error"));
        }
    }

    private void openMainStage() {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginStage.class.getResource(FXML_MAIN_STAGE_FXML));
        fxmlLoader.setResources(Utils.getResourceBundle());
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage1 = new Stage();
         stage1.setScene(scene);
        stage1.setTitle(Utils.getResourceBundle().getString("title.app"));
        stage1.setResizable(true);
     //   stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
