package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/resources/main.fxml"));
            Pane root = loader.load();
            Controller controller = loader.getController();
            controller.setStage(stage);
            controller.initHandlers();//остановка потока с закрытием окна
            Scene scene = new Scene(root);//установка размера окна
            scene.getStylesheets().clear();//отчистка коллекции стилей
            scene.getStylesheets().add(getClass()
                    .getResource("/resources/style.css").toExternalForm());
            //добавляем коллекции стилей
            stage.setScene(scene);
            stage.setTitle("Udp Chat");//установка названия окна
            stage.show();//показ окна
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);//закрывает все приложения (закрывает все потоки)
            //Platform.exit();//закрывает только оконные приложения
            //stage.close();
        }

    }
}
