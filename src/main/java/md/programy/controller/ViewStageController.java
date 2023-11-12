package md.programy.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import md.programy.modelFX.PasswordModel;

public class ViewStageController {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField linkTextField;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextArea descriptionTextArea;
    private Stage stage;
    private PasswordModel passwordModel = new PasswordModel();

    public void initialize(){

        setEditableFalse();

    }
    public void init(){
        bindings();
    }

    private void bindings() {
        nameTextField.textProperty().bind(passwordModel.getPasswordFX().nameProperty());
        linkTextField.textProperty().bind(passwordModel.getPasswordFX().linkProperty());
        loginTextField.textProperty().bind(passwordModel.getPasswordFX().loginProperty());
        passwordTextField.textProperty().bind(passwordModel.getPasswordFX().passwordProperty());
        descriptionTextArea.textProperty().bind(passwordModel.getPasswordFX().descriptionProperty());
    }

    private void setEditableFalse() {
        nameTextField.setEditable(false);
        linkTextField.setEditable(false);
        loginTextField.setEditable(false);
        passwordTextField.setEditable(false);
        descriptionTextArea.setEditable(false);
    }


    public void okButtonOnAction() {
        stage.close();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public PasswordModel getPasswordModel() {
        return passwordModel;
    }

    public void setPasswordModel(PasswordModel passwordModel) {
        this.passwordModel = passwordModel;
    }
}
