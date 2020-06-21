package com.neuroshima.scenes;

import com.neuroshima.MainController;
import com.neuroshima.jobs.*;
import com.neuroshima.model.HeroJob;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class JobScene
{
    private HeroJob heroJob;
    private ArrayList<Job> jobs;
    private ArrayList<TitledPane> titledPanes;
    private ArrayList<ArrayList<Button>> buttons;
    private Label chosenJobLabel;
    private Label chosenFeatureLabel;
    private Label gamblesAmountLabel;
    private GridPane mainGrid;
    private MainController mainController;
    private Scene scene;

    public JobScene(MainController mainController)
    {
        this.mainController = mainController;

        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.TOP_CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));

        ScrollPane scrollPane = new ScrollPane();
        GridPane scrollPaneGrid = new GridPane();

        Label gamblesLabel = new Label("Gambles");
        gamblesAmountLabel = new Label("TODO take value from model");
        Label originLabel = new Label("Origin");
        chosenJobLabel = new Label("");
        Label qualityLabel = new Label("Quality");
        chosenFeatureLabel = new Label("");

        mainGrid.add(gamblesLabel, 0, 0);
        mainGrid.add(gamblesAmountLabel, 1, 0);
        mainGrid.add(originLabel, 0, 1);
        mainGrid.add(chosenJobLabel, 1, 1);
        mainGrid.add(qualityLabel, 0, 2);
        mainGrid.add(chosenFeatureLabel, 1, 2);

        heroJob = new HeroJob(null, "");
        jobs = new ArrayList<>();
        jobs.add(new Chemist());
        jobs.add(new Ganger());
        jobs.add(new Gladiator());
        jobs.add(new Trader());

        titledPanes = new ArrayList<>();
        buttons = new ArrayList<>();

        for(int i = 0; i < jobs.size(); i++)
        {
            TitledPane titledPane = new TitledPane();
            titledPanes.add(titledPane);
            GridPane gridPane = new GridPane();
            buttons.add(new ArrayList<>());
            titledPane.setOnMousePressed(this::setJob);

            for(int j = 0; j < jobs.get(i).features.size(); j++)
            {
                buttons.get(i).add(new Button(jobs.get(i).features.get(j)));
                buttons.get(i).get(j).setOnAction(this::setJobAndFeature);

                gridPane.add(buttons.get(i).get(j), 0, j);
            }

            Label label = new Label("    ");

            titledPane.setContent(gridPane);
            titledPane.setText(jobs.get(i).name);
            titledPane.setExpanded(false);
            titledPane.setOnMouseClicked(this::focusMainGrid);

            scrollPaneGrid.add(titledPane, 0, i);
            scrollPaneGrid.add(label, 1, i);
        }

        scrollPane.setContent(scrollPaneGrid);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setOnMouseClicked(this::focusMainGrid);
        mainGrid.add(scrollPane, 1, 3);

        Button prevButton = new Button("Prev");
        HBox prevButtonBox = new HBox(10);
        prevButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        prevButtonBox.getChildren().add(prevButton);
        mainGrid.add(prevButtonBox, 0, 4);

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

    private void setJob(MouseEvent event)
    {
        TitledPane tp = (TitledPane) event.getSource();

        if(!tp.isExpanded())
        {
            heroJob.job = jobs.get(titledPanes.indexOf(tp));
            chosenJobLabel.setText(heroJob.job.name);

            for(int i = 0; i < heroJob.job.features.size(); i++)
            {
                if(heroJob.feature.equals(heroJob.job.features.get(i)))
                {
                    return;
                }
            }

            heroJob.feature = "";
            chosenFeatureLabel.setText("");
        }
    }

    private void setJobAndFeature(ActionEvent event)
    {
        System.out.println("TODO");
    }

    private void focusMainGrid(MouseEvent event)
    {
        mainGrid.requestFocus();
    }
}