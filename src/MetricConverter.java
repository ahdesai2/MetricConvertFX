import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

 

public class MetricConverter extends Application {

 

    // Create text fields to input values

    private TextField inputField = new TextField();

    private TextField outputField = new TextField();

 

    @Override

    public void start(Stage primaryStage) {

        // Create grid pane to layout components

        GridPane pane = new GridPane();

        pane.setAlignment(Pos.CENTER);

        pane.setPadding(new Insets(10));

        pane.setHgap(10);

        pane.setVgap(10);

 

        // Create labels for input and output fields

        Label inputLabel = new Label("Input:");

        Label outputLabel = new Label("Output:");

 

        // Add labels and text fields to grid pane

        pane.add(inputLabel, 0, 0);

        pane.add(inputField, 1, 0);

        pane.add(outputLabel, 0, 1);

        pane.add(outputField, 1, 1);

 

        // Create conversion buttons

        Button cmToInchesButton = new Button("CM to Inches");

        Button kmToMilesButton = new Button("Km to Miles");

        Button gramsToOuncesButton = new Button("Grams to Ounces");

        Button kgToLbsButton = new Button("Kg to Lbs");

 

        // Add conversion buttons to grid pane

        pane.add(cmToInchesButton, 0, 2);

        pane.add(kmToMilesButton, 1, 2);

        pane.add(gramsToOuncesButton, 0, 3);

        pane.add(kgToLbsButton, 1, 3);

 

        // Add actions to conversion buttons

        cmToInchesButton.setOnAction(e -> convert(2.54));

        kmToMilesButton.setOnAction(e -> convert(0.621371));

        gramsToOuncesButton.setOnAction(e -> convert(0.035274));

        kgToLbsButton.setOnAction(e -> convert(2.20462));

 

        // Create scene and set stage

        Scene scene = new Scene(pane, 300, 200);

        primaryStage.setTitle("Metric Converter");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

 

    // Method to convert values

    private void convert(double conversionFactor) {

        // Get value from input field

        String input = inputField.getText();

 

        // Check if input is a valid number

        try {

            double inputValue = Double.parseDouble(input);

 

            // Perform conversion and set output field

            double outputValue = inputValue * conversionFactor;

            outputField.setText(String.format("%.2f", outputValue));

        } catch (NumberFormatException e) {

            outputField.setText("Invalid input");

        }

    }

 

    public static void main(String[] args) {

        launch(args);

    }

}