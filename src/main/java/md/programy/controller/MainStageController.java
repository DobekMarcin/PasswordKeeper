package md.programy.controller;

import javafx.application.Platform;
import javafx.beans.property.LongProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import md.programy.modelFX.ListPasswordModel;
import md.programy.modelFX.PasswordFX;

public class MainStageController {
    @FXML
    private TableView passwordTable;
    @FXML
    private TableColumn<PasswordFX,String> nameColumn;
    @FXML
    private TableColumn<PasswordFX,String> linkColumn;
    @FXML
    private TableColumn<PasswordFX, Button> copyButtonColumn;

    private ListPasswordModel listPasswordModel = new ListPasswordModel();

    public void initialize(){
        listPasswordModel.init();

        passwordTable.setItems(listPasswordModel.getPasswordFXObservableList());

        nameColumn.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        linkColumn.setCellValueFactory(cellData->cellData.getValue().linkProperty());
        copyButtonColumn.setCellValueFactory(new PropertyValueFactory<PasswordFX,Button>("copyButton"));


    }

    public void closeMenu() {
        Platform.exit();
    }
}
