public class Customer {
  String name;
  int customerID;

  public String toString() {
    return String.valueOf(customerID) + ": " + name;
  }

  public Customer() {
    this.name = getName();
    this.customerID = getID();
  }

  public Customer(String name, int customerID) {
    this.name = name;
    this.customerID = customerID;
  }

  public String getName() {
    return name;
  }

  public int getID() {
    return customerID;
  }

  public Customer(Customer customer) {
    name = customer.name;
    customerID = customer.customerID;
  }



}
