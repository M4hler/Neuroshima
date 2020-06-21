package com.neuroshima.scenes;

import com.neuroshima.MainController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class JobScene
{
    private GridPane mainGrid;
    private MainController mainController;
    private Scene scene;

    public JobScene(MainController mainController)
    {
        this.mainController = mainController;

        mainGrid = new GridPane();

        Button prevButton = new Button("Prev");
        HBox prevButtonBox = new HBox(10);
        prevButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        prevButtonBox.getChildren().add(prevButton);
        mainGrid.add(prevButtonBox, 0, 0);

        prevButton.setOnAction(this::previousScene);

        scene = new Scene(mainGrid, 800, 600);
        mainGrid.requestFocus();
    }

    public Scene getScene()
    {
        return scene;
    }

    private void previousScene(ActionEvent event)
    {
        mainGrid.requestFocus();
        mainController.previousScene();
    }
}