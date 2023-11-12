package md.programy.controller;

import javafx.application.Platform;
import javafx.beans.property.LongProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import jdk.jshell.execution.Util;
import md.programy.modelFX.ListPasswordModel;
import md.programy.modelFX.PasswordFX;
import md.programy.modelFX.PasswordModel;
import md.programy.stage.LoginStage;
import md.programy.utils.DialogUtils;
import md.programy.utils.Utils;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainStageController {
    public static final String FXML_VIEW_STAGE_FXML = "/FXML/ViewStage.fxml";
    public static final String FXML_EDIT_STAGE_FXML = "/FXML/EditStage.fxml";
    @FXML
    private TableColumn<PasswordFX, String> descriptionColumn;
    @FXML
    private TableColumn<PasswordFX, String> loginColumn;
    @FXML
    private TableColumn<PasswordFX, String> passwordColumn;
    @FXML
    private TableView passwordTable;
    @FXML
    private TableColumn<PasswordFX, String> nameColumn;
    @FXML
    private TableColumn<PasswordFX, String> linkColumn;

    private ListPasswordModel listPasswordModel = new ListPasswordModel();

    public void initialize() {
        listPasswordModel.init();
        tableInit();
        addMouseActionToTable();
    }

    private void addMouseActionToTable() {
        passwordTable.setRowFactory(tv -> {
            TableRow<PasswordFX> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    PasswordFX rowData = row.getItem();
                    viewOnAction();
                }
            });
            return row;
        });
    }

    private void tableInit() {
        passwordTable.setItems(listPasswordModel.getPasswordFXObservableList());

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        linkColumn.setCellValueFactory(cellData -> cellData.getValue().linkProperty());
        passwordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        loginColumn.setCellValueFactory(cellData -> cellData.getValue().loginProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
    }

    public void closeMenu() {
        Platform.exit();
    }

    public void viewOnAction() {
        if (passwordTable.getSelectionModel().getSelectedItem() == null) {
            DialogUtils.informationDialog(Utils.getResourceBundle().getString("dialog.no.position"));
        } else {
            PasswordModel passwordModel = new PasswordModel();
            passwordModel.setPasswordFX((PasswordFX) passwordTable.getSelectionModel().getSelectedItem());
            FXMLLoader fxmlLoader = new FXMLLoader(LoginStage.class.getResource(FXML_VIEW_STAGE_FXML));
            fxmlLoader.setResources(Utils.getResourceBundle());
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage1 = new Stage();
            ViewStageController viewStageController = fxmlLoader.getController();
            viewStageController.setStage(stage1);
            viewStageController.setPasswordModel(passwordModel);
            viewStageController.init();
            stage1.setScene(scene);
            stage1.setTitle(Utils.getResourceBundle().getString("title.view"));
            stage1.setResizable(false);
            stage1.initModality(Modality.APPLICATION_MODAL);
            //   stage1.initStyle(StageStyle.UNDECORATED);
            stage1.show();
        }
    }


    public void editOnAction() {
        if (passwordTable.getSelectionModel().getSelectedItem() == null) {
            DialogUtils.informationDialog(Utils.getResourceBundle().getString("dialog.no.position"));
        } else {
            PasswordModel passwordModel = new PasswordModel();
            passwordModel.setPasswordFX((PasswordFX) passwordTable.getSelectionModel().getSelectedItem());
            FXMLLoader fxmlLoader = new FXMLLoader(LoginStage.class.getResource(FXML_EDIT_STAGE_FXML));
            fxmlLoader.setResources(Utils.getResourceBundle());
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage1 = new Stage();
            EditStageController editStageController = fxmlLoader.getController();
            editStageController.setStage(stage1);
            editStageController.setPasswordModel(passwordModel);
            editStageController.init();
            stage1.setScene(scene);
            stage1.setTitle(Utils.getResourceBundle().getString("title.view"));
            stage1.setResizable(false);
            stage1.initModality(Modality.APPLICATION_MODAL);
            //   stage1.initStyle(StageStyle.UNDECORATED);
            stage1.show();
        }
    }
}
