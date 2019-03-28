import java.io.BufferedReader;

public class SavingsAccount extends BankAccount{

  private double annualInterestRate; //between 0 and 1
  private double minimumBalance;

  /**
   *default constructor.
   */
  public SavingsAccount(){
    super();
    this.annualInterestRate = 0.05;
  }

  public SavingsAccount(BufferedReader reader) {

  }
  
  /**
   *second constructor with annualInterestRate parameter
   */
  public SavingsAccount(double annualInterestRate){
    this();
    this.annualInterestRate=annualInterestRate;

  }

  public SavingsAccount(Customer accountHolder, double balance){
    super(accountHolder, balance);
    this.annualInterestRate = 0.05;
  }

  public SavingsAccount(double balance, double annualInterestRate){
    super(balance);
    this.annualInterestRate=annualInterestRate;
  }

  /**
   *third constructor with accountHolder, balance and annualInterestRate parameter
   */
  public SavingsAccount(Customer accountHolder,double balance,double annualInterestRate){
    super(accountHolder,balance);
    this.annualInterestRate=annualInterestRate;

  }

  /**
   *withdraws the amount if the withdrawal doesn't result in a balance below the
   *minimum
   */
  public void withdraw(double amount){
    if (getBalance() - amount >= minimumBalance){
      super.withdraw(amount);
    }
  }

  /**
   *returns the minimum balance
   */
  public double getMinimumBalance(){
    return this.minimumBalance;
  }

  /**
   *returns the annual interest rate
   */
  public double getAnnualInterestRate(){
    return this.annualInterestRate;
  }

  /**
   *sets the minimum balance
   */
  public void setMinimumBalance(double balance){
    if (balance > 0){
      this.minimumBalance = balance;
    }
  }

  /**
   *sets the annual interest rate
   */
  public void setAnnualInterestRate(double rate){
    if (0.0 <= rate && rate <= 1.0){
      this.annualInterestRate = rate;
    }
    else{
      this.annualInterestRate = 0.05;
    }
  }

@Override
protected double getMonthlyFeesAndInterest() {
  // TODO Auto-generated method stub
  return (annualInterestRate/12)*getBalance();
}

}
