
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
