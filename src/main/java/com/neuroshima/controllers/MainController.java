package com.neuroshima.controllers;

import com.neuroshima.model.Hero;
import com.neuroshima.scenes.CharacterNameScene;
import com.neuroshima.scenes.JobScene;
import com.neuroshima.scenes.OriginScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainController extends Application
{
    private ArrayList<Scene> scenes;
    private Scene currentScene;
    private Stage stage;

    @Override
    public void start(Stage primaryStage)
    {
        stage = primaryStage;
        stage.setTitle("Neuroshima");

        Hero hero = new Hero();

        scenes = new ArrayList<>();
        scenes.add(new CharacterNameScene(this, hero).getScene());
        scenes.add(new OriginScene(this, hero).getScene());
        scenes.add(new JobScene(this, hero).getScene());

        currentScene = scenes.get(0);

        stage.setScene(currentScene);

        stage.show();
    }

    public static void main(String[] args)
    {
        Application.launch();
    }

    public void nextScene()
    {
        currentScene = scenes.get(scenes.indexOf(currentScene) + 1);
        stage.setScene(currentScene);
    }

    public void previousScene()
    {
        currentScene = scenes.get(scenes.indexOf(currentScene) - 1);
        stage.setScene(currentScene);
    }
}