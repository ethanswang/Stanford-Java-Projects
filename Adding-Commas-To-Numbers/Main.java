import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Input a number: ");
    String digits = s.nextLine();
    int intValue = 0;
    try {
      intValue = Integer.parseInt(digits);
      if (digits.length() != 0) {
        System.out.println(addCommasToNumericString(digits));
      }
    } catch (NumberFormatException e) {
      System.out.println("Input String cannot be parsed to Integer.");
    }
  }

  public static String addCommasToNumericString(String num) {
      if (num.length() <= 3) {
        return num;
      }
      else {
        for (int i = num.length() - 4; i >= 0; i -= 3) {
          num = num.substring(0, i + 1) + "," + num.substring(i + 1, num.length());
        }
        return num;
      }
  }
}