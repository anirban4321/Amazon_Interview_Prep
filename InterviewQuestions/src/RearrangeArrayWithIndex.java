import java.util.Arrays;
import java.util.HashSet;

/*
Rearrange an array such that arr[i] = i
Given an array of elements of length N, ranging from 0 to N – 1. All elements may not be present in the array.
If element is not present then there will be -1 present in the array.
Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
 */
public class RearrangeArrayWithIndex {

  public static void main(String[] args) {
    int A[] = {
        -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };

    // Function calling
    System.out.println(Arrays.toString(fix(A)));
    System.out.println("Calling out rearrange method using swap,saving extra memory");
    rearrangeArrayWithIndexUsingSwap(A);
  }

  private static int[] fix(int[] a) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      set.add(a[i]);
    }
    for (int i = 0; i < a.length; i++) {
      if (set.contains(i))
        a[i] = i;
      else
        a[i] = -1;
    }
    return a;
  }

  /*
  Another Approach (Swap elements in Array) :
      1) Iterate through elements in array
      2) If arr[i] >= 0 && arr[i] != i, put arr[i] at i ( swap arr[i] with arr[arr[i]])
   */
  public static void rearrangeArrayWithIndexUsingSwap(int arr[]) {
    for (int i = 0; i < arr.length; ) {
      if (arr[i] >= 0 && arr[i] != i) {
        int ele = arr[arr[i]];
        arr[arr[i]] = arr[i];
        arr[i] = ele;
      } else {
        i++;
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
