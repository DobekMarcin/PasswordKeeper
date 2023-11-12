package md.programy.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import md.programy.controller.DialogInfoController;
import md.programy.stage.LoginStage;

import java.io.IOException;

public class DialogUtils {

    public static final String FXML_DIALOG_INFO_FXML = "/FXML/DialogInfo.fxml";

    public static void informationDialog(String information){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginStage.class.getResource(FXML_DIALOG_INFO_FXML));
        fxmlLoader.setResources(Utils.getResourceBundle());
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage stage1 = new Stage();
        DialogInfoController dialogInfoController = fxmlLoader.getController();
        dialogInfoController.setInfo(information);
        dialogInfoController.setStage(stage1);
        dialogInfoController.init();
        stage1.setScene(scene);
        stage1.setTitle(Utils.getResourceBundle().getString("title.information"));
        stage1.setResizable(false);
        stage1.initModality(Modality.APPLICATION_MODAL);

        stage1.show();
    }
}
