// { Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.Scanner;

public class WordBreak {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n;
      n = sc.nextInt();
      ArrayList<String> arr = new ArrayList<String>();
      for (int i = 0; i < n; i++) {
        String p = sc.next();
        arr.add(p);
      }
      String line = sc.next();
      Sol obj = new Sol();
      System.out.println(obj.wordBreak(line, arr));

    }
  }
}// } Driver Code Ends

//User function Template for Java


class Sol {

  static final int ALPHABET_SIZE = 26;

  public static void insert(DictNode root, String word) {
    DictNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      DictNode node = current.dictionaryWords[index];
      if (node == null) {
        node = new DictNode();
        current.dictionaryWords[index] = node;
      }
      current = node;
    }
    current.isEndOfWord = true;
  }

  public static boolean search(DictNode root, String word) {
    DictNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      DictNode node = current.dictionaryWords[index];
      if (node == null)
        return false;
      current = node;
    }
    return (current != null && current.isEndOfWord);
  }

  public static int wordBreak(String A, ArrayList<String> B) {
    DictNode root = new DictNode();
    for (int i = 0; i < B.size(); i++)
      insert(root, B.get(i));
    if (wordBreakUtil(A, root))
      return 1;
    else
      return 0;

  }

  public static boolean wordBreakUtil(String A, DictNode root) {
    int size = A.length();
    if (size == 0)
      return true;
    for (int i = 1; i <= size; i++) {
      if (search(root, A.substring(0, i)) && wordBreakUtil(A.substring(i, size), root))
        return true;
    }
    return false;
  }

  static class DictNode {

    //ArrayList<DictNode> dictionaryWords;
    //Map<>
    DictNode dictionaryWords[];

    boolean isEndOfWord;

    DictNode() {
      // dictionaryWords = new ArrayList<DictNode>(26);
      dictionaryWords = new DictNode[ALPHABET_SIZE];
      for (int i = 0; i < 26; i++)
        dictionaryWords[i] = null;
      isEndOfWord = false;
    }
  }
}