// Abdullah Khan - January 29, 2019

public class BasicJava3 {

  public static void main(String[] args) {
    // main method for manual testing
  }

  public static boolean isDigit(char aChar) {
    // using ASCII character codes
    if ((aChar >= 48 && aChar <= 57)) {
      return true;
    }
    else {
      return false;
    }
  }

  public static double computePolynomial(double x) {
    return (0.5 * ((x - 1) * (x - 1))) - (4 * (11 - x)) + 10;
  }

  public static double afterDecimal(double num) {
    // convert double to String to use string operations
    String numString = String.valueOf(num);
    // use substring to find the numbers after the "."
    // also check if the input number is negative and return accordingly
    if (num < 0.0){
      return Double.parseDouble("-" + numString.substring(numString.indexOf(".")));
    }
    else {
      return Double.parseDouble(numString.substring(numString.indexOf(".")));
    }
  }

  public static int count(String str, String chars) {
    int count = 0;
    String character;
    String lowerString = str.toLowerCase();
    for(int i = 0; i < lowerString.length(); i++) {
      // get each character in string and store it for later use (on each iteration)
      character = String.valueOf(lowerString.charAt(i));
      // if the sequence of characters include the single character, increment the counter
      if(chars.contains(character)) {
        count++;
      }
    }

    return count;
  }

  public static int smallestDigit(int num) {
    // convert to a positive number if the given one is negative
    int absNum = (num < 0) ? -num : num;

    // check if input is a single digit number
    if(absNum < 10){
      return absNum;
    }

    // get last digit and compare it with the previous last one, recursively
    int digit = absNum % 10;
    int previousMin = smallestDigit(absNum / 10);
    // return the smallest digit from all the digits that were compared
    return (digit <= previousMin) ? digit : previousMin;
  }

}
