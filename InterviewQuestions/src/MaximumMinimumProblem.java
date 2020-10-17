/*
Given a sorted array of positive integers,rearrange the array alternately
i.e first element should be maximum value, second minimum value, third second max, fourth second min and so on.

Examples:

Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
Output: arr[] = {7, 1, 6, 2, 5, 3, 4}

Input: arr[] = {1, 2, 3, 4, 5, 6}
Output: arr[] = {6, 1, 5, 2, 4, 3}
 */


public class MaximumMinimumProblem {

  //BruteForce
  //0(n)--timeCom
  //0(n)--spacecomp

  public static void rearrangeArrayWithMaximumMinimum(int a[]) {
    int low = 0;
    int n = a.length;
    int high = n - 1;
    int temp[] = new int[n];
    boolean flag = true;
    for (int i = 0; i < n; i++) {
      if (flag)
        temp[i] = a[high--];
      else
        temp[i] = a[low++];
      flag = !flag;
    }
    System.out.println("MaximumMinimum Rearrange Array is::");
    for (int i = 0; i < n; i++) {
      System.out.print(temp[i] + " ");
    }
    System.out.println();
  }

  //With  multiplication And modular trick to store two elements at an index
  public static void rearrangeArrayWithMaxMinFormat(int a[]) {
    int n = a.length;
    int max_index = n - 1;
    int min_index = 0;
    int max_element = a[n - 1] + 1;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        a[i] += (a[max_index] % max_element) * max_element;
        max_index--;
      } else {
        a[i] += (a[min_index] % max_element) * max_element;
        min_index++;
      }
    }
    for (int i = 0; i < n; i++) {
      a[i] = a[i] / max_element;
      System.out.print(a[i] + " ");
    }
  }

  public static void main(String[] args) {
    int a[] = { 1, 2, 3, 4, 5, 6 };
    rearrangeArrayWithMaximumMinimum(a);
    System.out.println("Calling out modularTrickImplementation");
    rearrangeArrayWithMaxMinFormat(a);
  }
}
