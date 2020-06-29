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
    private int gambleBalance;
    private ArrayList<Label> standardRulesRollsAssignment;
    private ArrayList<Label> standardRulesDiceRolls;
    private ArrayList<Label> standardRulesBonus;
    private ArrayList<Label> standardRulesFinal;
    private ArrayList<Button> standardRulesPlus;
    private ArrayList<Button> standardRulesMinus;
    private Label standardRulesTotalSumLabel;
    private Label standardRulesFinalSum;
    private Random generator;
    private Label gamblesAmountLabel;
    private Label gambleBalanceLabel;
    private GridPane mainGrid;
    private MainController mainController;
    private Scene scene;

    public StatisticsScene(MainController mainController, Hero hero)
    {
        this.mainController = mainController;
        this.hero = hero;
        gambleBalance = 0;

        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.TOP_CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));

        Label gamblesLabel = new Label("Gambles");
        gamblesAmountLabel = new Label(String.valueOf(hero.gambles));
        gambleBalanceLabel = new Label("(" + gambleBalance + " balance)");

        mainGrid.add(gamblesLabel, 0, 0);
        mainGrid.add(gamblesAmountLabel, 1, 0);
        mainGrid.add(gambleBalanceLabel, 2, 0);

        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton standardRulesButton = new ToggleButton("Standard rules");
        ToggleButton alternativeRulesButton = new ToggleButton("Alternative rules");
        standardRulesButton.setToggleGroup(toggleGroup);
        alternativeRulesButton.setToggleGroup(toggleGroup);

        standardRulesButton.setOnAction(this::standardRulesView);
        alternativeRulesButton.setOnAction(this::alternativeRulesView);

        HBox toggleButtonsHBox = new HBox(standardRulesButton, alternativeRulesButton);
        mainGrid.add(toggleButtonsHBox, 0, 1, 3, 1);

        GridPane standardRulesGrid = new GridPane();
        standardRulesGrid.setHgap(10);
        standardRulesGrid.setVgap(10);

        generator = new Random();
        standardRulesBonus = new ArrayList<>();
        standardRulesFinal = new ArrayList<>();
        standardRulesPlus = new ArrayList<>();
        standardRulesMinus = new ArrayList<>();
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
        standardRulesGrid.add(dragLabel, 2, 0);
        Label dropLabel = new Label("Drop here");
        standardRulesGrid.add(dropLabel,4, 0);
        Label bonusLabel = new Label("Bonus");
        standardRulesGrid.add(bonusLabel, 6, 0);
        Label finalLabel = new Label("Final");
        standardRulesGrid.add(finalLabel, 8, 0);

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

            standardRulesRollsAssignment.add(new Label("  "));
            standardRulesRollsAssignment.get(i).setBorder(border);
            standardRulesRollsAssignment.get(i).setOnDragDetected(this::dragDetected);
            standardRulesRollsAssignment.get(i).setOnDragOver(this::dragOver);
            standardRulesRollsAssignment.get(i).setOnDragDropped(this::dragDropped);

            standardRulesBonus.add(new Label(""));
            standardRulesFinal.add(new Label(""));

            standardRulesPlus.add(new Button("+"));
            standardRulesMinus.add(new Button("-"));
            standardRulesPlus.get(i).setOnAction(this::addStat);
            standardRulesMinus.get(i).setOnAction(this::subtractStat);

            standardRulesGrid.add(standardRulesDiceRolls.get(i), 2, i + 1);
            standardRulesGrid.add(standardRulesRollsAssignment.get(i), 4, i + 1);
            standardRulesGrid.add(standardRulesBonus.get(i), 6 , i + 1);
            standardRulesGrid.add(standardRulesMinus.get(i), 7, i + 1);
            standardRulesGrid.add(standardRulesFinal.get(i), 8, i + 1);
            standardRulesGrid.add(standardRulesPlus.get(i), 9, i + 1);
        }

        standardRulesTotalSumLabel = new Label("");
        Label standardRulesTotalLabel = new Label("Total");
        standardRulesFinalSum = new Label("");
        standardRulesGrid.add(standardRulesTotalLabel, 0, standardRulesDiceRolls.size() + 1);
        standardRulesGrid.add(standardRulesTotalSumLabel, 2, standardRulesLabels.size() + 1);
        standardRulesGrid.add(standardRulesFinalSum, 8, standardRulesLabels.size() + 1);

        mainGrid.add(standardRulesGrid, 0, 2, 4, 1);

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
        setBonusLabels();
        finalStats();
    }

    private void setBonusLabels()
    {
        standardRulesBonus.get(0).setText(String.valueOf(hero.heroOrigin.origin.statBonus.build));
        standardRulesBonus.get(1).setText(String.valueOf(hero.heroOrigin.origin.statBonus.dexterity));
        standardRulesBonus.get(2).setText(String.valueOf(hero.heroOrigin.origin.statBonus.character));
        standardRulesBonus.get(3).setText(String.valueOf(hero.heroOrigin.origin.statBonus.perception));
        standardRulesBonus.get(4).setText(String.valueOf(hero.heroOrigin.origin.statBonus.cleverness));
    }

    private void finalStats()
    {
        int sum = 0;
        for(int i = 0; i < standardRulesFinal.size(); i++)
        {
            int rollAssignment = 0;
            String assignment = standardRulesRollsAssignment.get(i).getText();
            if(!assignment.equals("  "))
            {
                rollAssignment = Integer.parseInt(assignment);
            }

            int bonus = Integer.parseInt(standardRulesBonus.get(i).getText());
            int finalValue = Math.min(rollAssignment + bonus, 20);
            standardRulesFinal.get(i).setText(String.valueOf(finalValue));
            sum += finalValue;
        }

        standardRulesFinalSum.setText(String.valueOf(sum));
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
            standardRulesRollsAssignment.get(i).setText("  ");
            standardRulesFinal.get(i).setText("");
            standardRulesDiceRolls.get(i).setText(String.valueOf(rolls.get(i)));
            sum += rolls.get(i);
        }

        standardRulesTotalSumLabel.setText(String.valueOf(sum));
        standardRulesFinalSum.setText("");
        gambleBalance = 0;
        gambleBalanceLabel.setText("(" + gambleBalance + " balance)");
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

        if(dragboard.hasString())
        {
            Label sourceLabel = (Label)event.getGestureTarget();
            Label targetLabel = (Label)event.getGestureSource();

            String swapText = sourceLabel.getText();
            sourceLabel.setText(dragboard.getString());
            targetLabel.setText(swapText);

        }

        finalStats();
        event.consume();
    }

    private void addStat(ActionEvent event)
    {
        Button b = (Button)event.getSource();
        int index = standardRulesPlus.indexOf(b);

        if(!standardRulesFinal.get(index).getText().equals(""))
        {
            int stat = Integer.parseInt(standardRulesFinal.get(index).getText());
            if(stat < 15 && Math.abs(gambleBalance - 50) <= hero.gambles)
            {
                standardRulesFinal.get(index).setText(String.valueOf(stat + 1));
                int finalSum = Integer.parseInt(standardRulesFinalSum.getText());
                standardRulesFinalSum.setText(String.valueOf(finalSum + 1));
                gambleBalance -= 50;
                gambleBalanceLabel.setText("(" + gambleBalance + " balance)");
            }
        }

        mainGrid.requestFocus();
    }

    private void subtractStat(ActionEvent event)
    {
        Button b = (Button)event.getSource();
        int index = standardRulesMinus.indexOf(b);

        if(!standardRulesFinal.get(index).getText().equals(""))
        {
            int stat = Integer.parseInt(standardRulesFinal.get(index).getText());
            if(stat > 6)
            {
                standardRulesFinal.get(index).setText(String.valueOf(stat - 1));
                int finalSum = Integer.parseInt(standardRulesFinalSum.getText());
                standardRulesFinalSum.setText(String.valueOf(finalSum - 1));
                gambleBalance += 20;
                gambleBalanceLabel.setText("(" + gambleBalance + " balance)");
            }
        }
    }
}