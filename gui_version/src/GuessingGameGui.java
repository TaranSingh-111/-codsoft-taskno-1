import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuessingGameGui extends Application {

    public void start(Stage stage)
    {
        GameLogic obj= new GameLogic();
        Label display= new Label("Guess a number between 1 and 100");
        display.setStyle("-fx-border-color: black; -fx-padding:10; -fx-min-width:300;");
        display.setFont(new Font("Arial", 18));

        //HBox
        TextField inputField=new TextField();
        inputField.setPromptText("Enter Guess");
        inputField.setMaxWidth(120);

        Button goBtn=new Button("GO");

        Label attemptsLabel =new Label("Attempts Left:"+ GameLogic.attempts);
        attemptsLabel.setFont(new Font("Arial",16));

        HBox inputBox= new HBox(10,inputField, goBtn,attemptsLabel);
        inputBox.setAlignment(Pos.CENTER);

        //resetButton
        Button resetButton=new Button("reset");
        resetButton.setAlignment(Pos.CENTER);

        //HighScore
        Label highScore=new Label("High Score:"+GameLogic.high);
        highScore.setStyle("-fx-border-color:black; -fx-padding:5;");

        //mainVBox
        VBox mainBox=new VBox(15,display,inputBox,resetButton);
        mainBox.setAlignment(Pos.TOP_CENTER);
        mainBox.setPadding(new Insets(20));

        BorderPane root=new BorderPane();
        root.setCenter(mainBox);
        root.setRight(highScore);
        BorderPane.setMargin(highScore,new Insets(20));

        //eventHandler
        goBtn.setOnAction(event ->
        {
            try{
                int guess= Integer.parseInt(inputField.getText());
                String result=GameLogic.checkGuess(guess);
                display.setText(result);
                attemptsLabel.setText("Attempts Left:"+ GameLogic.attempts);
            }
            catch (NumberFormatException ex){
                display.setText("Please enter a valid number.");
            }
            inputField.clear();
        });

        resetButton.setOnAction(event -> {
            GameLogic.reset();
            display.setText("Game reset! Start Guessing Again.");
            inputField.clear();
            highScore.setText("High Score:"+GameLogic.high);
        });

        Scene scene=new Scene(root,500,300);
        stage.setTitle("The Number Game");
        stage.setScene(scene);
        stage.show();



    }
}
