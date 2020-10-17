/*
Program to Encrypt a String using ! and @
Given a string, the task is to encrypt this string using ! and @ symbols, alternatively.
While encrypting the message the encrypted format must repeat the symbol as many times as the letter position in
Alphabetical order.

Examples:

Input: string = "Ab"
Output: !@@
Explanation:
Position of 'A' in alphabetical order is 1
and in String is odd position
so encrypted message will have 1 '!'

Position of 'b' in alphabetical order is 2
and in String is even position
so encrypted message will have 2 '@'

Therefore, the output "!@@"

Input: string = "CDE"
Output: !!!@@@@!!!!
 */


public class EncodeString {

   static void encodeString(char[] input)
    {
        char evenpos='!';
        char oddpos='@';
        String s="";
        //char[] ch =new char[input.length];
        int repeat=0;
        for(int i=0;i<input.length;i++)
        {
            int ascii=input[i];
            repeat= ascii>=97? ascii-96:ascii-64;
            for(int j=0;j<repeat;j++) {
                if (i % 2 == 0)
                    System.out.printf("%c",evenpos);
                else
                    System.out.printf("%c",oddpos);
            }

        }
    }
    public static void main(String[] args) {
       String s="CDE";
       char[] ch = s.toCharArray();
       encodeString(ch);
    }

}
