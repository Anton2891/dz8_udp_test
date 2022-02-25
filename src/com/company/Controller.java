package com.company;

import com.company.udp.Server;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        server = new Server(serverMsg);
        server.setDaemon(true);//останавливает поток при закрытие окна
        server.start();
    }

    public void initHandlers(){
        stage.setOnCloseRequest(event -> {
//            server.interrupt();//остановка потока
//            server.stop();
        });
    }

    private Server server;

    @FXML
    private TextField sendAdr;
    @FXML
    private TextArea serverMsg;
    @FXML
    private TextArea clientMsg;

    @FXML
    public void sendHandler(){
        clientMsg.setText("Start text");
    }

    @FXML
    public void stopHandler(){
        server.stopRun();
    }

    @FXML
    public void clearServer(){
        serverMsg.clear();
    }

    @FXML
    public void clearClient(){
        clientMsg.clear();
    }
}
