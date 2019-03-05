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

  /**
   *second constructor with annualInterestRate parameter
   */
  public SavingsAccount(double annualInterestRate){
    this();
    this.annualInterestRate=annualInterestRate;

  }

  /**
   *third constructor with accountHolder, balance and annualInterestRate parameter
   */
  public SavingsAccount(Customer accountholder,double balance,double annualInterestRate){
    super(accountHolder,balance);
    this.annualInterestRate = annualInterestRate;
  }

  /**
   *calculates amount of interest earned on the balance and adds to balance, monthly
   */
  public void depositMonthlyInterest(){
    double monthlyRate = annualInterestRate / 12 * getBalance();
    deposit(monthlyRate);
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

}
