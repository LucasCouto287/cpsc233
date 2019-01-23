public class Expressions2 {
  public static void main(String[] args) {

  }

  public static boolean isLower(char aChar) {
    boolean tmp1 =  'a' <= aChar;
    boolean tmp2 =  aChar <= 'z';

    return tmp1 && tmp2;
  }

  public static double computePolynomial(double x) {
    return (2 * (x * x * x)) + (3 * (7 - x) * (7 - x)) - 100;
  }

  public static double division(int num1, int num2) {
    return (double)(num1) / (double)(num2);
  }

  public static String convertToString(int fiveDigitNum) {
    int num = Integer.valueOf(Integer.toString(fiveDigitNum, 10), 10);
    int count = 5;
    String string = "";
    while (count > 0) {
        int lastDigit = num % 10;
        string += lastDigit;
        num /= 10;
        count--;
    }

    return new StringBuilder(string).reverse().toString();
  }
}
