/*
Count the number of vowels occurring in all the substrings of given string
Given a string of length N of lowercase characters containing 0 or more vowels,
the task is to find the count of vowels occurred in all the substrings of the given string.

Examples:

Input: str = “abc”
Output: 3





The given string “abc” contains only one vowel = ‘a’
Substrings of “abc” are = {“a”, “b”, “c”, “ab”, “bc, “abc”}
Hence, the sum of occurrences of the vowel in these strings = 3.(‘a’ occurred 3 times)

Input: str = “daceh”
Output: 16
 */
public class CountVowelsInSubstring {
    public static void main(String args[])
    {
        String s = "daceh";
        System.out.println(vowel_calc(s));
    }

    private static int vowel_calc(String s) {
        int count=0;
        int a[]=new int [s.length()];
        for(int i=0;i<s.length();i++)
        {
             if(i==0)
                 a[i]=s.length();
             else
                 a[i]=(s.length()-i)+a[i-1]-i;
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                count+=a[i];
        }
        return count;
    }
}
