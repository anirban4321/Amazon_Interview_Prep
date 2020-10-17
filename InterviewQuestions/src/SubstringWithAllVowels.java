import java.util.HashSet;

/*
Find substrings that contain all vowels
We have been given a string in lowercase alphabets. We need to print substrings that
contain all the vowels at-least one time and there are no consonants (non-vowel characters) present in the substrings.
 */
public class SubstringWithAllVowels {

    public static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            return true;
        else
            return false;
    }
    static void findSubstringWithAllVowels(String s)
    {
        HashSet<Character> set=new HashSet<>();
        int start=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
                if(isVowel(s.charAt(i)))
                {
                    set.add(s.charAt(i));
                    if(set.size()==5){
                        count++;
                        System.out.println(s.substring(start,i+1)+" ");}
                }else{
                    start =i+1;
                    set.clear();
                }

        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        //String str = "aeoibsddaeiouudb";
        String str= "aeouisddaaeeiouua";
        findSubstringWithAllVowels(str);
    }
}
