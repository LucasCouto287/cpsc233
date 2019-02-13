// Abdullah Khan (UCID 30074457)

public class Employee {
  public static void main(String[] args) {

  }

  private char rank;
  private int yearsOfService;
  private double score;

  public Employee(char rank, double score) {
    // if given a negative score, convert to positive before setting
    score = (score < 0.0) ? 1.0 : score;
    if (rank == 101 || rank == 109 || rank == 117 || rank == 120) {
      this.rank = rank;
    }
    else {
      this.rank = 101;
    }
    this.score = score;
    this.yearsOfService = 0;
  }

  public Employee(Employee copyEmployee) {
    this.rank = copyEmployee.getRank();
    this.score = copyEmployee.getScore();
    this.yearsOfService = copyEmployee.getYearsOfService();
  }

  public char getRank() {
    return rank;
  }

  public int getYearsOfService() {
    return yearsOfService;
  }

  public double getScore() {
    return score;
  }

  public void setRank(char rank) {
    if (rank == 101 || rank == 109 || rank == 117 || rank == 120) {
      this.rank = rank;
    }
    else {
      this.rank = 101;
    }
  }

  public void setScore(double score) {
    // if given a negative score, convert to 1.0 before setting
    score = (score < 0.0) ? 1.0 : score;
    this.score = score;
  }

  public void updateYearsOfService() {
    this.yearsOfService ++;
  }

  public double getValue() {
    return this.yearsOfService * this.score;
  }
}
