package game;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import cards.StackOfCards;
import com.sun.source.tree.IfTree;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameTestController {

    private StackOfCards stack;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnHand;

    @FXML
    private Button btnHas5Q;

    @FXML
    private Button btnHasQK;

    @FXML
    private Button btnQuit;

    @FXML
    private TextArea txaHand;

    @FXML
    private TextArea txaHas;

    @FXML
    void btnHandOnClick(ActionEvent event) {
        txaHand.setText("");

        if (stack.dealHand()) {
            txaHand.setText(stack.printCards());
        } else {
            btnHand.setDisable(true);
        }


    }

    @FXML
    void btnHas5QOnClick(ActionEvent event) {
        if(stack.hasFiveQueen()) {
            txaHas.setText(stack.printCards());
            txaHas.appendText("В изтеглената ръка има пет QUEEN");
        } else {
            txaHas.setText(stack.printCards());
            txaHas.appendText("В изтеглената ръка няма пет QUEEN");
        }
    }

    @FXML
    void btnHasQKOnClick(ActionEvent event) {
        if(stack.hasQueenAndKing()) {
            txaHas.setText(stack.printCards());
            txaHas.appendText("В изтеглената ръка има двойка QUEEN-KING");
        } else {
            txaHas.setText(stack.printCards());
            txaHas.appendText("В изтеглената ръка няма двойка QUEEN-KING");
        }
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnHand != null : "fx:id=\"btnHand\" was not injected: check your FXML file 'vue-fxml.fxml'.";
        assert btnHas5Q != null : "fx:id=\"btnHas5Q\" was not injected: check your FXML file 'vue-fxml.fxml'.";
        assert btnHasQK != null : "fx:id=\"btnHasQK\" was not injected: check your FXML file 'vue-fxml.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'vue-fxml.fxml'.";
        assert txaHand != null : "fx:id=\"txaHand\" was not injected: check your FXML file 'vue-fxml.fxml'.";
        assert txaHas != null : "fx:id=\"txaHas\" was not injected: check your FXML file 'vue-fxml.fxml'.";

        stack = new StackOfCards();
        stack.make2packs();

    }

}
