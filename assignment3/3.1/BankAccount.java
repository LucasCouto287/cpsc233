public class BankAccount {

  double balance;
  int accNumber = 1;
  String accountNumber;

  public static void main(String[] args) {
    Customer accountHolder = new Customer();
  }

  public BankAccount(double accountBalance) {
    balance = accountBalance;
    accountNumber = String.format("%04d", accNumber);
    accNumber ++;
  }

  public BankAccount(Customer customer, )

  public BankAccount() {
    balance = 0;
    accountNumber = String.format("%04d", accNumber);
    accNumber ++;
  }

  public BankAccount(double accountBalance, String bankAccountNumber) {
    if (accountBalance > 0) {
      balance = accountBalance;
      accountNumber = bankAccountNumber;
    }
  }

  public void deposit(double amount) {
    if(amount > 0) {
      balance += amount;
    }
  }

  public void withdraw(double amount) {
    if(amount <= balance && amount >= 0) {
      balance -= amount;
    }
  }


  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String toString() {
    return accountNumber + ": " + balance;
  }
}
