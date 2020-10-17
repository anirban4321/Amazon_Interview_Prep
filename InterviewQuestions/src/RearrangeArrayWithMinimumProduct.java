/*
Rearrange an array to minimize sum of product of consecutive pair elements
We are given an array of even size,
we have to sort the array in such a way that the sum of product of alternate elements is minimum
also we have to find that minimum sum
 */

import java.util.Arrays;

public class RearrangeArrayWithMinimumProduct {

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 6, 7, 3, 4, 2, 0,10};
        int n = arr.length;
        System.out.println("Minimum required sum = "
                + minSum(arr, n));
        System.out.println("Sorted array in required format : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static int minSum(int[] arr, int n) {
        Arrays.sort(arr);
        int[] even = new int[n/2+1];
        int[] odd = new int[n/2+1];
        int sum = 0;
        int max_index = n - 1;
        int min_index = 0;
        int max_element = arr[n - 1] + 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[max_index] % max_element) * max_element;
                max_index--;
            } else {
                arr[i] += (arr[min_index] % max_element) * max_element;
                min_index++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max_element;
        }
        int j=0,k=0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[j] = arr[i];
                j++;
            }
            else {
                odd[k] = arr[i];
                k++;
            }
        }
        for (int i = 0; i < n/2+1; i++)
        {
            System.out.print(even[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n/2+1; i++){
            System.out.print(odd[i]+" ");
        }
        for (int i = 0; i < n/2+1; i++) {
            sum += (even[i] * odd[i]);
        }
        return sum;

    }
}
