// Abdullah Khan (UCID 30074457)
// CPSC233 Individual Assignment 5

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BankAccountGUI extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) {
    // set window title
    primaryStage.setTitle("Bank Account | Bank Account");

    Text heading = new Text(120, 35, "Account Holder: John Doe");
    Text balanceText = new Text(180, 80, "Balance: $0.00");
    Text inputLabel = new Text(195, 130, "Enter an amount");
    TextField amountInput = new TextField();
    amountInput.setPromptText("Enter amount...");
    Button depositButton = new Button();
    depositButton.setText("Deposit");
    Button withdrawButton = new Button();
    withdrawButton.setText("Withdraw");

    Pane root = new Pane();
    // styling for all elements (root, account holder heading, balance heading, input field + its label, deposit/withdraw buttons)
    root.setStyle("-fx-background-color: #3C3F45;");
    heading.setStyle("-fx-font-size: 23px; -fx-fill: #FBFBFC");
    balanceText.setStyle("-fx-font-size: 21px; -fx-fill: #FBFBFC");
    inputLabel.setStyle("-fx-font-size: 16px; -fx-fill: #FBFBFC");
    amountInput.setStyle("-fx-font-size: 20px; -fx-padding: 8px 4px 8px 4px; -fx-focus-color: #39EA49;");
    depositButton.setStyle("-fx-background-color: #FBFBFC; -fx-text-fill: #474747; -fx-font-size: 18px; -fx-cursor: hand; -fx-focus-color: transparent;");
    withdrawButton.setStyle("-fx-background-color: #FBFBFC; -fx-text-fill: #474747; -fx-font-size: 18px; -fx-cursor: hand; -fx-focus-color: red;");
    // set the text field size
    amountInput.setPrefSize(300, 10);
    // positioning for the elements
    amountInput.setLayoutX(110);
    amountInput.setLayoutY(140);
    depositButton.setLayoutX(160);
    depositButton.setLayoutY(230);
    withdrawButton.setLayoutX(260);
    withdrawButton.setLayoutY(230);
    // add all elements into the root pane
    root.getChildren().add(heading);
    root.getChildren().add(balanceText);
    root.getChildren().add(inputLabel);
    root.getChildren().add(amountInput);
    root.getChildren().add(depositButton);
    root.getChildren().add(withdrawButton);
    // disable windo resizing
    primaryStage.setResizable(false);
    // set window (Scene) with the root pane and set the height and width
    primaryStage.setScene(new Scene(root, 500, 300));
    primaryStage.show();
  }
}
