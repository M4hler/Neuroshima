package com.neuroshima.scenes;

import com.neuroshima.controllers.MainController;
import com.neuroshima.model.Hero;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StatisticsScene implements SceneEssentials
{
    private Hero hero;
    private Label gamblesAmountLabel;
    private GridPane mainGrid;
    private MainController mainController;
    private Scene scene;

    public StatisticsScene(MainController mainController, Hero hero)
    {
        this.mainController = mainController;
        this.hero = hero;

        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.TOP_CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));

        Label gamblesLabel = new Label("Gambles");
        gamblesAmountLabel = new Label(String.valueOf(hero.gambles));

        mainGrid.add(gamblesLabel, 0, 0);
        mainGrid.add(gamblesAmountLabel, 1, 0);

        Button prevButton = new Button("Prev");
        HBox prevButtonBox = new HBox(10);
        prevButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        prevButtonBox.getChildren().add(prevButton);
        mainGrid.add(prevButtonBox, 0, 4);

        prevButton.setOnAction(this::previousScene);

        scene = new Scene(mainGrid, 800, 600);
        mainGrid.requestFocus();
    }

    @Override
    public Scene getScene()
    {
        return scene;
    }

    @Override
    public void refreshScene()
    {
        gamblesAmountLabel.setText(String.valueOf(hero.gambles));
    }

    private void previousScene(ActionEvent event)
    {
        mainGrid.requestFocus();
        mainController.previousScene();
    }
}
