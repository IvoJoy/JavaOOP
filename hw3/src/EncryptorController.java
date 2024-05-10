import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EncryptorController {

    private RouteCipher route;
    private int key;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDecrypt;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnQuit;

    @FXML
    private TextArea txaInput;

    @FXML
    private TextArea txaOutput;

    @FXML
    private TextField txfKey;

    @FXML
    void btnDecryptOnAction(ActionEvent event) {
        if(!txfKey.getText().isEmpty()) {
            key = Integer.parseInt(txfKey.getText());
            route.setKey(key);
        }
        if(!txaOutput.getText().isEmpty()) {
            String text = txaOutput.getText();
            txaInput.setText(route.decrypt(text));
        } else {
            txaInput.setText("Insert text!");
        }


    }

    @FXML
    void btnEncryptOnAction(ActionEvent event) {
        if(!txfKey.getText().isEmpty()) {
            key = Integer.parseInt(txfKey.getText());
            route.setKey(key);
        }
        if(!txaInput.getText().isEmpty()) {
            String text = txaInput.getText();
            txaOutput.setText(route.encrypt(text));
        } else {
            txaOutput.setText("Insert text!");
        }

    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnDecrypt != null : "fx:id=\"btnDecrypt\" was not injected: check your FXML file 'view-encryptor.fxml'.";
        assert btnEncrypt != null : "fx:id=\"btnEncrypt\" was not injected: check your FXML file 'view-encryptor.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'view-encryptor.fxml'.";
        assert txaInput != null : "fx:id=\"txaInput\" was not injected: check your FXML file 'view-encryptor.fxml'.";
        assert txaOutput != null : "fx:id=\"txaOutput\" was not injected: check your FXML file 'view-encryptor.fxml'.";
        assert txfKey != null : "fx:id=\"txfKey\" was not injected: check your FXML file 'view-encryptor.fxml'.";

        route = new RouteCipher(2); // set default key 2

    }

}
