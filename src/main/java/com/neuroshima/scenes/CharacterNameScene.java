package com.neuroshima.scenes;

import com.neuroshima.controllers.MainController;
import com.neuroshima.model.Hero;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CharacterNameScene implements SceneEssentials
{
    private Hero hero;
    private TextField nameInput;
    private TextField surnameInput;
    private TextField nicknameInput;
    private Text errorText;
    private GridPane grid;
    private Scene scene;
    private MainController mainController;

    public CharacterNameScene(MainController mainController, Hero hero)
    {
        this.mainController = mainController;
        this.hero = hero;

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text header = new Text("Character name");
        header.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(header, 0, 0, 2, 1);

        Label name = new Label("Name:");
        grid.add(name, 0, 1);
        nameInput = new TextField();
        grid.add(nameInput, 1, 1);

        Label surname = new Label("Surname:");
        grid.add(surname, 0, 2);
        surnameInput = new TextField();
        grid.add(surnameInput, 1, 2);

        Label nickname = new Label("Nickname:");
        grid.add(nickname, 0, 3);
        nicknameInput = new TextField();
        grid.add(nicknameInput, 1, 3);

        Button button = new Button("Next");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(button);
        grid.add(hBox, 1, 4);

        errorText = new Text();
        grid.add(errorText, 1, 6);

        button.setOnAction(this::nextScene);

        scene = new Scene(grid, 400, 300);
        grid.requestFocus();
    }

    @Override
    public Scene getScene()
    {
        return scene;
    }

    @Override
    public void refreshScene()
    {
    }

    private void nextScene(ActionEvent event)
    {
        if(nameInput.getText().isEmpty() && surnameInput.getText().isEmpty() && nicknameInput.getText().isEmpty())
        {
            errorText.setFill(Color.FIREBRICK);
            errorText.setText("Fill at least one field");
        }
        else
        {
            errorText.setText("");

            hero.name = nameInput.getText();
            hero.surname = surnameInput.getText();
            hero.nickname = nicknameInput.getText();

            grid.requestFocus();
            mainController.nextScene();
        }
    }
}