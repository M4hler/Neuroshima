package com.neuroshima.scenes;

import com.neuroshima.MainController;
import com.neuroshima.model.HeroOrigin;
import com.neuroshima.origins.*;
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

public class OriginScene
{
    private HeroOrigin origin;
    private ArrayList<Origin> origins;
    private ArrayList<TitledPane> titledPanes;
    private ArrayList<ArrayList<Button>> buttons;
    private Label chosenOriginLabel;
    private Label chosenQualityLabel;
    private Label gamblesAmountLabel;
    private GridPane mainGrid;
    private Scene scene;
    private MainController mainController;

    public OriginScene(MainController mainController)
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
        gamblesAmountLabel = new Label("100");
        Label originLabel = new Label("Origin");
        chosenOriginLabel = new Label("");
        Label qualityLabel = new Label("Quality");
        chosenQualityLabel = new Label("");

        mainGrid.add(gamblesLabel, 0, 0);
        mainGrid.add(gamblesAmountLabel, 1, 0);
        mainGrid.add(originLabel, 0, 1);
        mainGrid.add(chosenOriginLabel, 1, 1);
        mainGrid.add(qualityLabel, 0, 2);
        mainGrid.add(chosenQualityLabel, 1, 2);

        origin = new HeroOrigin(null, "");
        origins = new ArrayList<>();
        origins.add(new SouthHegemony());
        origins.add(new Vegas());
        origins.add(new DesertsMan());
        origins.add(new NewYork());
        origins.add(new Texas());
        origins.add(new AppalachsFederation());
        origins.add(new Miami());
        origins.add(new AManFromNotYourBusiness());
        origins.add(new SaltLakeCity());
        origins.add(new Mississippi());
        origins.add(new Post());
        origins.add(new Detroit());

        titledPanes = new ArrayList<>();
        buttons = new ArrayList<>();

        for(int i = 0; i < origins.size(); i++)
        {
            TitledPane titledPane = new TitledPane();
            titledPanes.add(titledPane);
            GridPane gridPane = new GridPane();
            buttons.add(new ArrayList<>());
            titledPane.setOnMousePressed(this::setOrigin);

            for(int j = 0; j < origins.get(i).qualities.size(); j++)
            {
                buttons.get(i).add(new Button(origins.get(i).qualities.get(j)));
                buttons.get(i).get(j).setOnAction(this::setOriginAndQuality);

                gridPane.add(buttons.get(i).get(j), 0, j);
            }

            //some additional spacing is needed to push the bar a bit further
            Label label = new Label("+1 " + origins.get(i).getBonusStat() + "    ");

            titledPane.setContent(gridPane);
            titledPane.setText(origins.get(i).name);
            titledPane.setExpanded(false);
            titledPane.setOnMouseClicked(this::focusMainGrid);

            scrollPaneGrid.add(titledPane, 0, i);
            scrollPaneGrid.add(label, 1, i);
        }

        Button noQualityButton = new Button("No quality");
        noQualityButton.setOnAction(this::giveUpQuality);
        HBox noQualityBox = new HBox();
        noQualityBox.setAlignment(Pos.CENTER);
        noQualityBox.getChildren().add(noQualityButton);
        Label noQualityLabel = new Label("+50 gambles");
        scrollPaneGrid.add(noQualityBox, 0, origins.size() + 1);
        scrollPaneGrid.add(noQualityLabel, 1, origins.size() + 1);

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
        if(origin.origin != null &&
                (origin.origin.qualities.contains(origin.quality) || gamblesAmountLabel.getText().equals("150")))
        {
            mainGrid.requestFocus();
            mainController.nextScene();
        }
    }

    private void focusMainGrid(MouseEvent event)
    {
        mainGrid.requestFocus();
    }

    private void setOriginAndQuality(ActionEvent event)
    {
        Button b = (Button)event.getSource();

        for(int i = 0; i < buttons.size(); i++)
        {
            int buttonIndex = buttons.get(i).indexOf(b);
            if(buttonIndex >= 0)
            {
                origin.origin = origins.get(i);
                origin.quality = origins.get(i).qualities.get(buttonIndex);
                chosenOriginLabel.setText(origin.origin.name + " (+1 " + origin.origin.getBonusStat() + ")");
                chosenQualityLabel.setText(origin.quality);
                break;
            }
        }

        gamblesAmountLabel.setText("100");
    }

    private void setOrigin(MouseEvent event)
    {
        TitledPane tp = (TitledPane) event.getSource();

        if(!tp.isExpanded())
        {
            origin.origin = origins.get(titledPanes.indexOf(tp));
            chosenOriginLabel.setText(origin.origin.name + " (+1 " + origin.origin.getBonusStat() + ")");

            for(int i = 0; i < origin.origin.qualities.size(); i++)
            {
                if(origin.quality.equals(origin.origin.qualities.get(i)))
                {
                    return;
                }
            }

            origin.quality = "";
            chosenQualityLabel.setText("");
        }
    }

    private void giveUpQuality(ActionEvent event)
    {
        gamblesAmountLabel.setText("150");
        origin.quality = "";
        chosenQualityLabel.setText("No quality from origin");
        mainGrid.requestFocus();
    }
}