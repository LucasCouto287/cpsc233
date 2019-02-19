public class SavingsAccount extends BankAccount{
  public static void main(String[] args) {

  }

  private double annualInterestRate = 0.05;
  private double minimumBalance;

  // getter for minimumBalance
  public double getAnnualInterestRate() {
    return this.annualInterestRate;
  }

  // setter for annualInterestRate (checks if the input is between 0 and 1)
  public void setAnnualInterestRate(double interestRate) {
    if(interestRate >= 0.0 && interestRate <= 1.0) {
      this.annualInterestRate = interestRate;
    }
  }

  public void withdraw(double amount) {
    // if withdrawal is valid
    if(amount <= balance && amount >= 0) {
      // if withdrawing amount will not cause the balance to fall below minimumBalance
      if(balance - amount >= minimumBalance) {
        balance -= amount;
      }
    }
  }

  // deposit interestRate to BankAccount's balance
  public void depositMonthlyInterest() {
    super.deposit((annualInterestRate / 12.0) * super.balance);
  }

  // setter for minimumBalance
  public void setMinimumBalance(double minBalance) {
    this.minimumBalance = minBalance;
  }
}
