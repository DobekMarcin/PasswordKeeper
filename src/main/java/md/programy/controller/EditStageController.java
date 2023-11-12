package md.programy.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import md.programy.modelFX.PasswordModel;

public class EditStageController {
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
nameTextField.setEditable(true);
    }
    public void init(){
        bindings();
    }

    private void bindings() {
        nameTextField.textProperty().bindBidirectional(passwordModel.getPasswordFX().nameProperty());
        linkTextField.textProperty().bindBidirectional(passwordModel.getPasswordFX().linkProperty());
        loginTextField.textProperty().bindBidirectional(passwordModel.getPasswordFX().loginProperty());
        passwordTextField.textProperty().bindBidirectional(passwordModel.getPasswordFX().passwordProperty());
        descriptionTextArea.textProperty().bindBidirectional(passwordModel.getPasswordFX().descriptionProperty());
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
