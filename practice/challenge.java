// reverse countdown printer challenge

import java.util.Scanner;

public class challenge {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int inputNum = input.nextInt();
    for(int i = inputNum; i >= 0; i--) {
      System.out.println(i);
    }
  }
}
