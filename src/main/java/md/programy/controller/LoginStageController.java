package md.programy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import md.programy.database.repository.UserRepository;
import md.programy.modelFX.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class LoginStageController {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwordTextField;
    private UserModel userModel = new UserModel();

    public void initialize(){
        userModel.getUserFx().loginProperty().bind(loginTextField.textProperty());
        userModel.getUserFx().passwordProperty().bind(passwordTextField.textProperty());
    }

    @FXML
    public void loginOnAction(ActionEvent actionEvent) {

        System.out.println(userModel.getUserFx());

    }
}
