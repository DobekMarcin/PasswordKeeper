package md.programy.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DialogInfoController {

    @FXML
    private Label infoLabel;
    private String info;
    private Stage stage;

    public void init() {
        infoLabel.textProperty().bind(new SimpleStringProperty(info));
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void okButtonOnAction() {
        stage.close();
    }
}
