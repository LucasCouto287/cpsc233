import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Customer {
  private String name;
  private int customerID;

  /**
   * constructor
   */
  public Customer() {
    this.name="";
    this.customerID=0;
  }

  public Customer(BufferedReader reader) throws IOException {
    String line = reader.readLine();
    if (line.contains("null")) {
      throw new IOException("Customer is null in file");
    }
    this.setName(line);
    line = reader.readLine();
    if(line != null) {
      this.customerID = Integer.parseInt(line);
    }
    else {
      throw new IOException("No customer ID found in file");
    }
  }

  public void save(PrintWriter writer) {
    writer.println(this.name);
    writer.println(this.customerID);
  }

  /**
   * constructor with name and id as parameters
   * @param name
   * @param id
   */
  public Customer(String name, int id){
    this.name=name;
    this.customerID=id;
  }

  /**
   * constructor with a Customer object as parameter
   * @param newCustomer
   */
  public Customer(Customer newCustomer) {
    this.name=newCustomer.name;
    this.customerID=newCustomer.customerID;
  }

  public void setName(String name){
      this.name=name;
    }

  public String getName() {
    return this.name;
  }

  public int getID(){
    return this.customerID;
  }

  /**
  *returns a string representation of the name and customer id
  */
  public String toString(){
    String info=this.name+" "+this.customerID;
    return info;
  }

}
