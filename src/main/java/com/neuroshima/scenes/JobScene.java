package com.neuroshima.scenes;

import com.neuroshima.controllers.MainController;
import com.neuroshima.jobs.*;
import com.neuroshima.model.Hero;
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
    private Hero hero;
    private ArrayList<Job> jobs;
    private ArrayList<TitledPane> titledPanes;
    private ArrayList<ArrayList<Button>> buttons;
    private Label chosenJobLabel;
    private Label chosenFeatureLabel;
    private Label gamblesAmountLabel;
    private GridPane mainGrid;
    private MainController mainController;
    private Scene scene;

    public JobScene(MainController mainController, Hero hero)
    {
        this.mainController = mainController;
        this.hero = hero;

        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.TOP_CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));

        ScrollPane scrollPane = new ScrollPane();
        GridPane scrollPaneGrid = new GridPane();

        Label gamblesLabel = new Label("Gambles");
        gamblesAmountLabel = new Label(String.valueOf(hero.gambles));
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

        jobs = new ArrayList<>();
        jobs.add(new Chemist());
        jobs.add(new Ganger());
        jobs.add(new Gladiator());
        jobs.add(new Trader());
        jobs.add(new NewEraPreacher());
        jobs.add(new Cowboy());
        jobs.add(new Courier());
        jobs.add(new Hunter());
        jobs.add(new MutantHunter());
        jobs.add(new Mafioso());
        jobs.add(new Medic());
        jobs.add(new Fixer());
        jobs.add(new Mercenary());
        jobs.add(new SecurityGuard());
        jobs.add(new Judge());
        jobs.add(new Spec());
        jobs.add(new Shaman());
        jobs.add(new Rat());
        jobs.add(new BeastsTrainer());
        jobs.add(new Trailer());
        jobs.add(new HighwayWarrior());
        jobs.add(new ClanWarrior());
        jobs.add(new Killer());
        jobs.add(new MachineKiller());
        jobs.add(new Thief());
        jobs.add(new Soldier());

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

        Button noFeatureButton = new Button("No feature (+50 gambles)");
        noFeatureButton.setOnAction(this::giveUpFeature);
        HBox noFeatureBox = new HBox();
        noFeatureBox.setAlignment(Pos.CENTER);
        noFeatureBox.getChildren().add(noFeatureButton);
        scrollPaneGrid.add(noFeatureBox, 0, jobs.size() + 1);

        scrollPane.setContent(scrollPaneGrid);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setOnMouseClicked(this::focusMainGrid);
        mainGrid.add(scrollPane, 1, 3);

        Button prevButton = new Button("Prev");
        HBox prevButtonBox = new HBox(10);
        prevButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        prevButtonBox.getChildren().add(prevButton);
        mainGrid.add(prevButtonBox, 0, 4);

        Button nextButton = new Button("Next");
        HBox nextButtonBox = new HBox(10);
        nextButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        nextButtonBox.getChildren().add(nextButton);
        mainGrid.add(nextButtonBox, 1, 4);

        prevButton.setOnAction(this::previousScene);
        nextButton.setOnAction(this::nextScene);

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

    private void nextScene(ActionEvent event)
    {
        //TODO
    }

    private void setJob(MouseEvent event)
    {
        TitledPane tp = (TitledPane) event.getSource();

        if(!tp.isExpanded())
        {
            hero.manageHeroJob(jobs.get(titledPanes.indexOf(tp)));
            chosenJobLabel.setText(hero.heroJob.job.name);
            chosenFeatureLabel.setText(hero.heroJob.feature);
        }

        gamblesAmountLabel.setText(String.valueOf(hero.gambles));
    }

    private void setJobAndFeature(ActionEvent event)
    {
        Button b = (Button)event.getSource();

        for(int i = 0; i < buttons.size(); i++)
        {
            int buttonIndex = buttons.get(i).indexOf(b);
            if(buttonIndex >= 0)
            {
                hero.manageHeroJob(jobs.get(i), jobs.get(i).features.get(buttonIndex));
                chosenJobLabel.setText(hero.heroJob.job.name);
                chosenFeatureLabel.setText(hero.heroJob.feature);
                break;
            }
        }

        gamblesAmountLabel.setText(String.valueOf(hero.gambles));
    }

    private void focusMainGrid(MouseEvent event)
    {
        mainGrid.requestFocus();
    }

    private void giveUpFeature(ActionEvent event)
    {
        hero.giveUpFeature();

        if(hero.heroJob != null && hero.heroJob.job != null)
        {
            chosenJobLabel.setText(hero.heroJob.job.name);
        }

        chosenFeatureLabel.setText("No feature from job");
        gamblesAmountLabel.setText(String.valueOf(hero.gambles));
        mainGrid.requestFocus();
    }
}