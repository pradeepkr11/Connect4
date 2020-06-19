package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();

        controller = loader.getController();
        controller.createPlayground();

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        MenuBar menuBar= createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
        createMenu();
    }

    private MenuBar createMenu(){
        MenuBar menuBar= new MenuBar();

        Menu file= new Menu("File");
        MenuItem newGame= new MenuItem("New Game");

        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");

        resetGame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
        MenuItem exit = new MenuItem("Exit");

        exit.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        file.getItems().addAll(newGame,resetGame,separatorMenuItem,exit);

        Menu help = new Menu("Help");
        MenuItem aboutGame=new MenuItem("AboutConnect4");

        aboutGame.setOnAction(event -> aboutConnect4());

        SeparatorMenuItem separatorMenuItem1= new SeparatorMenuItem();
        MenuItem about= new MenuItem("About Me");

        about.setOnAction(event -> aboutMe());

        help.getItems().addAll(aboutGame,separatorMenuItem1,about);

        menuBar.getMenus().addAll(file,help);
        return menuBar;



    }

    private void aboutMe() {
        Alert aboutGame= new Alert(Alert.AlertType.INFORMATION);
        aboutGame.setTitle("About the Developer");
        aboutGame.setHeaderText("Pradeep Kumar");
        aboutGame.setContentText(" I am learning Java\n");
        aboutGame.show();
    }

    private void aboutConnect4() {

        Alert aboutGame= new Alert(Alert.AlertType.INFORMATION);
        aboutGame.setTitle("About Connect4");
        aboutGame.setHeaderText("How to Play");
        aboutGame.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.\n" +
                "\n");
        aboutGame.show();
    }

    private void exitGame(){

    	Platform.exit();
    	System.exit(0);
    }
    private void resetGame() {


    }


    public static void main(String[] args) {
        launch(args);
    }
}
