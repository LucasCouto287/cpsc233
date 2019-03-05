public class BankAccount {

  double balance;
  int accNumber = 1;
  String accountNumber;
  Customer accountHolder;

  public static void main(String[] args) {

  }

  public void setAccountHolder(Customer oldCustomer) {
    accountHolder = oldCustomer;
  }

  public BankAccount(double accountBalance) {
    balance = accountBalance;
    accountNumber = String.format("%04d", accNumber);
    accNumber ++;
  }

  public BankAccount(Customer customer, double accBalance){
    accountHolder = customer;
    balance = accBalance;
    accountNumber = String.format("%04d", accNumber);
    accNumber ++;
  }

  public BankAccount() {
    balance = 0;
    accountNumber = String.format("%04d", accNumber);
    accNumber ++;
  }

  public BankAccount(BankAccount oldAccount) {
    accountHolder = oldAccount.getAccountHolder();
    balance = oldAccount.getBalance();
    accountNumber = oldAccount.getAccountNumber();
  }

  public BankAccount(double accountBalance, String bankAccountNumber) {
    if (accountBalance >= 0) {
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

  public void transfer(double transferAmount, BankAccount account){
    if(balance >= transferAmount) {
      withdraw(transferAmount);
      account.deposit(transferAmount);
    }
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public Customer getAccountHolder() {
    return accountHolder;
  }

  public String toString() {
    return "(" + accountHolder.toString() + ")" + " " + accountNumber + ": " + balance;
  }
}
