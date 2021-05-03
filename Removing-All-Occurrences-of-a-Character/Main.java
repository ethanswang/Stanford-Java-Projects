import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Input a string:");
    String str = s.nextLine();
    System.out.println("Input a character:");
    String ch = s.nextLine();
    String ch2 = ch.toUpperCase();
    for (int i = 0; i < str.length(); i ++) {
      if (String.valueOf(str.charAt(i)).equals(ch) || String.valueOf(str.charAt(i)).equals(ch2)) {
        str = str.substring(0, i) + str.substring(i + 1);
      }
    }
    System.out.println("The resulting string is " + str);
  }
}