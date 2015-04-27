import java.util.Scanner;

public class SimpleMethod {

    public static void main(String[] args) {

        long number;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        number = in.nextLong();

        System.out.println(searchPalindrome(number));
    }

    // Bruteforce =)
    public static long searchPalindrome(long number) {
        while (!isPalindrome(String.valueOf(number))) {
            number++;
        }
        return number;
    }

    // Palindrome checker
    public static boolean isPalindrome(String text) {
        String reverse = new StringBuilder(text).reverse().toString();
              if (text.equals(reverse))
            return true;
        else
            return false;
    }

}

