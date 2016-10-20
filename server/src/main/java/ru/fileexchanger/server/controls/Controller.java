package ru.fileexchanger.server.controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import ru.fileexchanger.server.Main;

import java.util.List;

public class Controller {
    @FXML
    private Button startServerButton;
    @FXML
    private Button stopServerButton;
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private ListView<String> clientListView;

    @FXML
    public void initialize() {
        Main.setController(this);
        stopServerButton.setDisable(true);

        startServerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            startServerButton.setDisable(true);
            stopServerButton.setDisable(false);
            Main.startServer();
        });

        stopServerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Main.stopServer();
            startServerButton.setDisable(false);
            stopServerButton.setDisable(true);
        });
    }

    public void updateListView(List<String> list) {
        if (list != null) {
            ObservableList<String> clients = FXCollections.observableArrayList(list);
            clientListView.setItems(clients);
        }
    }
}