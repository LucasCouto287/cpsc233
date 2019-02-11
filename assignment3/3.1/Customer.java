public class Customer {
  String name;
  int customerID;

  public String toString() {
    return String.valueOf(name + " " + customerID);
  }

  public Customer() {
    this.name = "";
    this.customerID = 0;
  }

  public Customer(String name, int customerID) {
    this.name = name;
    this.customerID = customerID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String newName){
    this.name = newName;
  }

  public int getID() {
    return this.customerID;
  }

  public Customer(Customer customer) {
    this.name = customer.getName();
    this.customerID = customer.getID();
  }

}
