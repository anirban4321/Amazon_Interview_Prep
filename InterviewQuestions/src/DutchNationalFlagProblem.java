//used in 3 way partitioning

/*
Sort an array of 0s, 1s and 2s (Simple Counting)
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
The functions should put all 0s first, then all 1s and all 2s in last.
--------------------------------------------------------------------------------------------

Count the number of 0’s, 1’s and 2’s. After Counting, put all 0’s first, then 1’s and lastly 2’s in the array. We traverse the array two times. Time complexity will be O(n).
// Simple Java program
// to sort an array of 0s
// 1s and 2s.
import java.util.*;
import java.lang.*;

public class GfG{

    public static void sort012(int arr[], int n)
    {
        // Variables to maintain
        // the count of 0's,
        // 1's and 2's in the array
        int count0 = 0, count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count0++;
            if (arr[i] == 1)
                count1++;
            if (arr[i] == 2)
                count2++;
        }

        // Putting the 0's in the
        // array in starting.
        for (int i = 0; i < count0; i++)
            arr[i] = 0;

        // Putting the 1's in the
        // array after the 0's.
        for (int i = count0; i <
            (count0 + count1); i++)
            arr[i] = 1;

        // Putting the 2's in the
        // array after the 1's
        for (int i = (count0 + count1);
            i < n; i++)
            arr[i] = 2;

        printArray(arr, n);
    }

    // Prints the array
    public static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver function
    public static void main(String argc[])
    {

        int arr[] = { 0, 1, 1, 0, 1, 2, 1,
                    2, 0, 0, 0, 1 };
        int n = 12;
        sort012(arr, n);
    }
}
----------------------------------------------------------------------------------------------------
*/


public class DutchNationalFlagProblem {

  public static void sort012(int[] a) {
    int low = 0;
    int mid = 0;
    int high = a.length - 1;
    int temp = 0;

    while (mid <= high) {
      // if(a[mid]==0)
      switch (a[mid]) {
        case 0: {
          temp = a[low];
          a[low] = a[mid];
          a[mid] = temp;
          low++;
          mid++;
          break;
        }

        case 1: {
          mid++;
          break;
        }
        case 2: {
          temp = a[mid];
          a[mid] = a[high];
          a[high] = temp;
          high--;
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
    sort012(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

  }
}
