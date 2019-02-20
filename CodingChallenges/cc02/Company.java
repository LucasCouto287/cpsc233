// Abdullah Khan (UCID 30074457)

import java.util.ArrayList;

public class Company {
  public static void main(String[] args) {

  }

  private String name;
  private ArrayList<Employee> employeeList = new ArrayList<Employee>();

  public Company(String name) {
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public ArrayList<Employee> getEmployeeList(){
    ArrayList<Employee> copyEmployeeList = new ArrayList<Employee>();
    for(int index = 0; index < this.employeeList.size(); index++){
      copyEmployeeList.add(this.employeeList.get(index));
    }
    return copyEmployeeList;
  }

  public void addEmployee(Employee employee) {
    this.employeeList.add(new Employee(employee));
  }

  public Employee getBestEmployee() {
    if (this.employeeList.size() == 0) {
      return null;
    }
    else if(this.employeeList.size() == 1) {
      return this.employeeList.get(0);
    }

    ArrayList<Double> valueList = new ArrayList<Double>();
    for(int index = 0; index < this.employeeList.size(); index++) {
      valueList.add(this.employeeList.get(index).getValue());
    // System.out.print(this.employeeList.get(index).getRank());
    }

    // get highest value from the employee value list
    double max = Double.MIN_VALUE;
    for(int i = 0; i < valueList.size(); i++){
        if(valueList.get(i) > max){
            max = valueList.get(i);
        }
    }
    // get highest value employee from employeeList based on valueList
    return new Employee(this.employeeList.get(valueList.indexOf(max)));
    // return null;
  }

  public Employee getBestEmployeeByRank(char rank) {
    if (this.employeeList.size() == 0){
      return null;
    }
    if (this.employeeList.size() == 1){
      return new Employee(employeeList.get(0));
    }
    ArrayList<Double> valueList = new ArrayList<Double>();
    for(int index = 0; index < this.employeeList.size(); index++){
      if (this.employeeList.get(index).getRank() == rank){
        valueList.add(this.employeeList.get(index).getValue());
      }
    }

    // if there is no employee in the list of specified rank
    if(valueList.size() == 0){
      return null;
    }
    if(valueList.size() == 1){
      return new Employee(employeeList.get(employeeList.indexOf(rank)));
    }
    return new Employee(employeeList.get(valueList.indexOf(rank)));
    // return null;
  }
}
