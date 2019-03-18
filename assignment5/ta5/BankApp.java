// CPSC233 Group 11 T03
// CPSC233 Team Assignment 5

/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BankAccountGUI extends Application {

  BankAccount bankAccountUser; //instance variable for BankAccount
  TextField enterAmount; //instance variable for text field
  Text displayAccBalance;

  // inner class for event handling for buttons (can't be in the same class)
  private class handleEvents {

    public void deposit(ActionEvent event){

    }


  }

  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) {
    // set window title
    primaryStage.setTitle("Bank Account | Bank Account");

    //change variables to match instance ones
    Text heading = new Text(120, 35, "Account Holder: John Doe");
    Text balanceText = new Text(180, 80, "Balance: $0.00");
    Text inputLabel = new Text(195, 130, "Enter an amount");
    TextField amountInput = new TextField(); //allows user to enter amount of money to deposit or withdraw
    amountInput.setPromptText("Enter amount...");
    Button depositButton = new Button();
    depositButton.setText("Deposit");
    Button withdrawButton = new Button();
    withdrawButton.setText("Withdraw");

    AnchorPane root = new AnchorPane();
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
    root.setLeftAnchor(amountInput, 110.0);
    root.setBottomAnchor(amountInput, 120.0);
    root.setBottomAnchor(depositButton, 40.0);
    root.setRightAnchor(depositButton, 260.0);
    root.setRightAnchor(withdrawButton, 140.0);
    root.setBottomAnchor(withdrawButton, 40.0);
    // add all elements into the root pane
    root.getChildren().addAll(heading, balanceText, inputLabel, amountInput, depositButton, withdrawButton);
    // disable window resizing
    // primaryStage.setResizable(false);
    // set window (Scene) with the root pane and set the height and width
    primaryStage.setScene(new Scene(root, 500, 300));
    primaryStage.show();
  }
}
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class BankApp extends Application{

  Customer user = new Customer("John Doe", 1);
  BankAccount bankAccountUser = new BankAccount(user, 100); //instance variable for BankAccount
  TextField enterAmount; //instance variable for text field
  Label displayAccBalance;

  public static void main(String[] args){
    launch(args);
  }

  public void start(Stage primaryStage) throws Exception {

    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 250, 200);
    primaryStage.setScene(scene);

    // vertical box to display account information centered at the top
    VBox labelRoot = new VBox();
    String accName = bankAccountUser.getAccountHolder().getName();
    Double accBalance = bankAccountUser.getBalance();
    Label accHolder = new Label("Account Holder: " + accName);
    Label accBalanceLabel = new Label("Balance: " + accBalance);
    labelRoot.setAlignment(Pos.CENTER);
    labelRoot.getChildren().addAll(accHolder, accBalanceLabel);

    // text field to deposit a certain amount centered in the middle of the pane
    HBox textFieldRoot = new HBox();
    Label amount = new Label("Enter amount: ");
    TextField console = new TextField();
    textFieldRoot.setAlignment(Pos.CENTER);
    textFieldRoot.getChildren().addAll(amount, console);

    // horizontal box with deposit and withdraw buttons centered at the bottom
    HBox buttonsRoot = new HBox();
    buttonsRoot.setAlignment(Pos.CENTER);
    buttonsRoot.getChildren().add(new Button("Deposit"));
    buttonsRoot.getChildren().add(new Button("Withdraw"));

    root.setCenter(textFieldRoot);
    root.setBottom(buttonsRoot);
    root.setTop(labelRoot);
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}
