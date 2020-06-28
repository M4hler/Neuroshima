package com.neuroshima.scenes;

import com.neuroshima.controllers.MainController;
import com.neuroshima.model.Hero;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class StatisticsScene implements SceneEssentials
{
    private Hero hero;
    private ArrayList<Label> standardRulesRollsAssignment;
    private ArrayList<Label> standardRulesDiceRolls;
    private Label standardRulesTotalSumLabel;
    private Random generator;
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

        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton standardRulesButton = new ToggleButton("Standard rules");
        ToggleButton alternativeRulesButton = new ToggleButton("Alternative rules");
        standardRulesButton.setToggleGroup(toggleGroup);
        alternativeRulesButton.setToggleGroup(toggleGroup);

        standardRulesButton.setOnAction(this::standardRulesView);
        alternativeRulesButton.setOnAction(this::alternativeRulesView);

        HBox toggleButtonsHBox = new HBox(standardRulesButton, alternativeRulesButton);
        mainGrid.add(toggleButtonsHBox, 0, 1, 2, 1);

        GridPane standardRulesGrid = new GridPane();
        standardRulesGrid.setHgap(10);
        standardRulesGrid.setVgap(10);

        generator = new Random();
        standardRulesDiceRolls = new ArrayList<>();
        standardRulesRollsAssignment = new ArrayList<>();
        ArrayList<Label> standardRulesLabels = new ArrayList<>();
        standardRulesLabels.add(new Label("Build"));
        standardRulesLabels.add(new Label("Dexterity"));
        standardRulesLabels.add(new Label("Character"));
        standardRulesLabels.add(new Label("Perception"));
        standardRulesLabels.add(new Label("Cleverness"));

        Button rollButton = new Button("Roll");
        rollButton.setOnAction(this::roll);
        standardRulesGrid.add(rollButton, 0, 0);

        Label dragLabel = new Label("Drag");
        standardRulesGrid.add(dragLabel, 1, 0);
        Label dropLabel = new Label("Drop here");
        standardRulesGrid.add(dropLabel,2, 0);

        Border border = new Border(
                        new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        BorderWidths.DEFAULT));
        for(int i = 0; i < standardRulesLabels.size(); i++)
        {
            standardRulesGrid.add(standardRulesLabels.get(i), 0, i + 1);
            standardRulesDiceRolls.add(new Label("  "));
            standardRulesDiceRolls.get(i).setBorder(border);
            standardRulesDiceRolls.get(i).setOnDragDetected(this::dragDetected);
            standardRulesDiceRolls.get(i).setOnDragOver(this::dragOver);
            standardRulesDiceRolls.get(i).setOnDragDropped(this::dragDropped);
            standardRulesDiceRolls.get(i).setOnDragDone(this::dragDone);

            standardRulesRollsAssignment.add(new Label("  "));
            standardRulesRollsAssignment.get(i).setBorder(border);
            standardRulesRollsAssignment.get(i).setOnDragDetected(this::dragDetected);
            standardRulesRollsAssignment.get(i).setOnDragOver(this::dragOver);
            standardRulesRollsAssignment.get(i).setOnDragDropped(this::dragDropped);
            standardRulesRollsAssignment.get(i).setOnDragDone(this::dragDone);

            standardRulesGrid.add(standardRulesDiceRolls.get(i), 1, i + 1);
            standardRulesGrid.add(standardRulesRollsAssignment.get(i), 2, i + 1);
        }

        standardRulesTotalSumLabel = new Label("");
        Label standardRulesTotalLabel = new Label("Total");
        standardRulesGrid.add(standardRulesTotalLabel, 0, standardRulesDiceRolls.size() + 1);
        standardRulesGrid.add(standardRulesTotalSumLabel, 1, standardRulesLabels.size() + 1);

        mainGrid.add(standardRulesGrid, 0, 2);

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

    private void standardRulesView(ActionEvent event)
    {
        System.out.println("Standard");
    }

    private void alternativeRulesView(ActionEvent event)
    {
        System.out.println("Alternative");
    }

    private void roll(ActionEvent event)
    {
        ArrayList<Integer> rolls = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 6; i++)
        {
            int averageValue = 0;
            for(int j = 0; j < 3; j++)
            {
                averageValue += Math.abs(generator.nextInt()) % 21;
            }

            averageValue = Math.max(6, (int)((double)(averageValue + 2) / 3));

            if(averageValue < min)
            {
                min = averageValue;
            }

            rolls.add(averageValue);
        }

        rolls.remove((Integer)min);
        int sum = 0;
        for(int i = 0; i < standardRulesDiceRolls.size(); i++)
        {
            standardRulesDiceRolls.get(i).setText(String.valueOf(rolls.get(i)));
            sum += rolls.get(i);
        }

        standardRulesTotalSumLabel.setText(String.valueOf(sum));
        mainGrid.requestFocus();
    }

    private void previousScene(ActionEvent event)
    {
        mainGrid.requestFocus();
        mainController.previousScene();
    }

    private void dragDetected(MouseEvent event)
    {
        Label label = (Label)event.getSource();

        if(!label.getText().equals("  "))
        {
            Dragboard dragboard = label.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(label.getText());
            dragboard.setContent(content);
        }
        event.consume();
    }

    private void dragDone(DragEvent event)
    {
        if(event.getTransferMode() == TransferMode.MOVE)
        {
            ((Label)event.getSource()).setText("  ");
        }
    }

    private void dragOver(DragEvent event)
    {
        if(event.getGestureSource() != event.getTarget()
            && event.getDragboard().hasString())
        {
            event.acceptTransferModes(TransferMode.MOVE);
            event.consume();
        }
    }

    private void dragDropped(DragEvent event)
    {
        Dragboard dragboard = event.getDragboard();
        boolean success = false;

        if(dragboard.hasString())
        {
            success = true;

            Label label = (Label)event.getGestureTarget();
            label.setText(dragboard.getString());
        }

        event.setDropCompleted(success);
        event.consume();
    }
}