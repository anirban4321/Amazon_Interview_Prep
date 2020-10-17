/*
Largest substring with same Characters
Given a string s of size N. The task is to find the largest substring which consists of same characters

Examples:

Input : s = “abcdddddeff”
Output : 5
Substring is “ddddd”
 */
public class LargestSubStringWithSameCharacter {

  public static void main(String[] args) {
    String s = "abbbbbbbbcdddddeff";

    // Function call
    System.out.println(Substring(s));
  }

  private static int Substring(String s) {
    int count = 1;
    int start = 0;
    int ans = 1;
        /*HashMap<Character,Integer>map=new HashMap<>();
        for(char c : s.toCharArray())
        {
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }*/
    int countArray[] = new int[256];

    // Construct character count array from the input
    // string.
    int len = s.length();
    for (int i = 0; i < len; i++)
      countArray[s.charAt(i)]++;

    int max = -1;  // Initialize max count
    char result = ' ';   // Initialize result

    // Traversing through the string and maintaining
    // the count of each character
    for (int i = 0; i < len; i++) {
      if (max < countArray[s.charAt(i)]) {
        max = countArray[s.charAt(i)];
        result = s.charAt(i);
      }
    }
    System.out.println(max);
    System.out.println(s.substring(s.indexOf(result), s.indexOf(result) + max));

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        count++;

      } else {
        count = 1;
        ans = Math.max(ans, count);
      }
      ans = Math.max(ans, count);
    }
    System.out.println(s.indexOf(result));
    System.out.println(s.substring((s.indexOf(result)), (s.indexOf(result) + ans)));
    return ans;
  }
}
