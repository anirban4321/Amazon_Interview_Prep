/**
 * Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’),
 * reverse the string in a way that special characters are not affected.
 * Examples:
 * Input:   str = "a,b$c"
 * Output:  str = "c,b$a"
 * Note that $ and , are not moved anywhere.
 * Only subsequence "abc" is reversed
 * Input:   str = "Ab,c,de!$"
 * Output:  str = "ed,c,bA!$"
 * SOLUTION
 * Simple Solution:
 * Create a temporary character array say temp[].
 * Copy alphabetic characters from given array to temp[].
 * Reverse temp[] using standard string reversal algorithm.
 * Now traverse input string and temp in a single loop.
 * Wherever there is alphabetic character is input string, replace it with current character of temp[].
 * TimeComplexity O(n) Space Complexity O(n)
 * Efficient Solution
 * Let input string be 'str[]' and length of string be 'n'
 * l = 0, r = n-1
 * While l is smaller than r, do following
 * If str[l] is not an alphabetic character, do l++
 * Else If str[r] is not an alphabetic character, do r--
 * Else swap str[l] and str[r]
 */
public class ReverseStrCharacter {

  public static void reverseString(char input[]) {
    int low = 0, high = input.length - 1;
    while (low < high) {
      if (!Character.isAlphabetic(input[low]))
        low++;
      else if (!Character.isAlphabetic(input[high]))
        high--;
      else {
        char temp = input[low];
        input[low] = input[high];
        input[high] = temp;

        low++;
        high--;
      }

    }
  }

  /*private static boolean  isAlphabeticCharacter(char ch) {
      return ((ch >= 'A' && ch <= 'Z') || (ch >= 'A' && ch <= 'Z'));
  }
*/
  public static void main(String[] args) {
    String str = "a!!!b.c.d,e'f,ghi";
    char[] charArray = str.toCharArray();

    System.out.println("Input string: " + str);
    reverseString(charArray);
    String revStr = new String(charArray);

    System.out.println("Output string: " + revStr);

  }
}