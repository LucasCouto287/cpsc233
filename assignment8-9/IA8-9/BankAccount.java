import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BankAccount{ //public abstract class BankAccount

  private double balance;
  private String accountNumber;
  private Customer accountHolder;

  public BankAccount(BufferedReader reader) throws IOException {
      String line = reader.readLine();
      this.balance = Double.parseDouble(line);
      line = reader.readLine();
      this.accountNumber = line;
      try {
        this.accountHolder = new Customer(reader);
      } 
      catch (IOException e) {
        this.accountHolder = null;
      }
  }

  public void saveToTextFile(String filename) throws IOException{
    PrintWriter writer = new PrintWriter(new FileOutputStream(filename));
    writer.println(String.valueOf(this.balance));
    writer.println(this.accountNumber);
    if(this.accountHolder == null) {
      writer.println("null");
    }
    else {
      this.accountHolder.save(writer);
    }
    writer.close();
  }

  protected abstract double getMonthlyFeesAndInterest();

  /**
  *Add boolean method that takes double and checks if there is enough funds to withdraw the amount
  */
  public Boolean sufficientFunds(double funds){
    if(funds <= this.balance && funds >0){
      return true;
    }
    return false;
  }

  /**
  *
  */
  public void monthEndUpdate() {
	  double amount= getMonthlyFeesAndInterest();
	  balance+=amount;
  }

  /**
  *constructor
  */
  public BankAccount(){
    balance=0.0;
    accountNumber="0001";
  }

  /**
   * constructor with a balance parameter
   * @param newBalance
   */
  public BankAccount(double newBalance){
    balance= newBalance;
    accountNumber= "0001";
  }

  /**
   * constructor with balance and account number parameter
   * @param newBalance
   * @param account
   */
  public BankAccount(double newBalance, String account){
    balance= newBalance;
    accountNumber= account;
  }

  /**
   * constructor with a BankACcount object as parameter
   * @param bAccount
   */
  public BankAccount(BankAccount bAccount) {
	  this.balance=bAccount.balance;
	  this.accountNumber=bAccount.accountNumber;
	  this.accountHolder=bAccount.accountHolder;
  }

  /**
   * constructor with Customer object and balance parameters
   * @param newAccount
   * @param newBalance
   */
  public BankAccount(Customer newCustomer, double newBalance){
    accountHolder= newCustomer;
    balance=newBalance;
    accountNumber="0001";
  }

  /**
   * adds money to the current balance
   * @param money
   */
  public void deposit(double money){
      if(money > 0) {
          balance += money;
      }
  }

  //update to use boolean method before doing withdraw
  /**
  *takes money out of the account
  */
  public void withdraw(double money){
    if(sufficientFunds(money)) {
        balance -=money;
    }
  }

  //update to use boolean method before doing withdraw
  /**
   * transfers money from one account to another
   */
  public void transfer(double money, BankAccount account2){
    if(sufficientFunds(money)) {
        withdraw(money);
        account2.deposit(money);
    }
  }

  /**
   * returns current balance
   * @return
   */
  public double getBalance(){
    return balance;
  }

  /**
   * returns account number
   * @return
   */
  public String getAccountNumber(){
    return accountNumber;
  }

  public void setAccountHolder(Customer newCustomer){
    accountHolder=newCustomer;
  }

  /**
   * returns a Customer object
   * @return
   */
  public Customer getAccountHolder() {
	  return accountHolder;
  }

  /**
   * returns a string representation of the Customer name, id and bank account number and balance
   */
  public String toString(){
    String info= "("+ accountHolder.getName()+" "+accountHolder.getID()+") "+accountNumber +": "+ String.valueOf(balance);
    return info;
  }

}
