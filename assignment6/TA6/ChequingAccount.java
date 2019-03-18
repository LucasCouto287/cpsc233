
import java.lang.Math;
public class ChequingAccount extends BankAccount{

    private double overdraftFee;
    private double overdraftAmount;

    /**
    *constructor with
    */
    public ChequingAccount(Customer aCust, double startBalance, double overdraftFee){
      super(aCust,startBalance);
      setOverdraftFee(overdraftFee);
    }


    public void setOverdraftFee(double overdraftFee){
      if(overdraftFee >= 0){
        this.overdraftFee = overdraftFee;
      }
      else {
        this.overdraftFee = 1.0;
      }
    }


    public void setOverdraftAmount(double overdraftAmount){
      //if(overdraftAmount > 0){
        this.overdraftAmount = overdraftAmount;
      //}
    }

    //non negative
    public double getOverdraftFee(){

      return Math.abs(this.overdraftFee);

    }

    //non negative
    public double getOverDraftAmount(){

      return Math.abs(this.overdraftAmount);

    }

    /**
    *override sufficientfunds
    * returns true if the amount specified (for withdrawal) will result in a balance that
    * might be less than zero, but never more than overdraftAmount below zero.
    */
    public Boolean sufficientFunds(double funds){
      if(funds >= getBalance()) {
        return true;
      }
      else if(funds <= getBalance()+overdraftAmount) {
        return true;
      }
      return false;

    }

    /**
    *override withdraw
    *updates the amount to withdraw to add the overdraftFee if the withdraw would
    * result in a negative balance.  (It should invoke withdraw in the parent to do the
    *actual withdrawal.)
    */
    public void withdraw(double money){
      if (getBalance() - money >= 0){
        super.withdraw(money);
      }
      else if (getBalance() + overdraftAmount - money > 0){
        super.withdraw(money+overdraftFee);
      }
    }

    /**
    *override getMonthlyFeesAndInterest
    *returns 0 if the balance is greater than or equal to zero but returns 20% of
    * the balance if the balance is less than zero
    */
    public double getMonthlyFeesAndInterest(){
      if((getBalance()) >= 0.0){
        return 0.0;
      }
      // else if () {
      //
      // }
      return getBalance() * 0.2;
    }

}
