import java.util.Scanner;

public class OptimalMethod {
    public static void main(String[] args) {
        long number;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        number = in.nextLong();

        System.out.println(searchPalindrome(number));
    }

    public static String searchPalindrome(long number) {

        String num = String.valueOf(number);
        int length = num.length();

        // Odd or even? There are different methods
        if (length % 2 == 0) {
            return evenPalindrome(number, num, length);
        } else {

            return oddPalindrome(number, num, length);
        }
    }

    // For even-digit numbers
    public static String evenPalindrome(long source, String number, int length) {
        int halfLength = length / 2;

        String halfOfNumber = number.substring(0, halfLength);
        long half = Long.parseLong(halfOfNumber);

        String result = number;

        if (isPalindrome(result)) {
            return result;
        }

        // Do palindrome using reverse characters
        result = halfOfNumber.concat(new StringBuilder(halfOfNumber)
                .reverse().toString());

        // If it isn't bigger than source number add +1
        if (Long.parseLong(result) > source) {
            return result;
        } else {
            half++;
            halfOfNumber = String.valueOf(half);
            return halfOfNumber.concat(new StringBuilder(halfOfNumber)
                    .reverse().toString());
        }
    }

    // For odd-digit numbers
    public static String oddPalindrome(long source, String number, int length) {
        int halfLength = length / 2;
        String halfOfNumber = number.substring(0, halfLength + 1);

        long half = Long.parseLong(halfOfNumber);

        String result = number;

        if (isPalindrome(result)) {
            return result;
        }

        // Do palindrome using reverse characters
        result = halfOfNumber
                .concat(new StringBuilder(halfOfNumber
                        .substring(0, halfLength))
                        .reverse()
                        .toString());

        // If it isn't bigger than source number add +1
        if (Long.parseLong(result) > source) {
            return result;
        } else {
            half++;
            halfOfNumber = String.valueOf(half);
            return halfOfNumber.concat(new StringBuilder(halfOfNumber
                    .substring(0, halfLength))
                    .reverse()
                    .toString());
        }
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
