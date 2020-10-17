/*
Count the triplets such that A[i] < B[j] < C[k]
Given three array A[], B[] and C[] of N integers each.
The task is to find the count of triplets (A[i], B[j], C[k]) such that A[i] < B[j] < C[k].

Input: A[] = {1, 5}, B[] = {2, 4}, C[] = {3, 6}
Output: 3
Triplets are (1, 2, 3), (1, 4, 6) and (1, 2, 6)

Input: A[] = {1, 1, 1}, B[] = {2, 2, 2}, C[] = {3, 3, 3}
Output: 27
 */

import java.util.Arrays;

public class CountTriplets {

    static int countTriplets(int a[],int b[],int c[])
    {
        int n= a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int count =0;

        for(int i=0;i<n;i++)
        {
            int x = b[i];
            int low = countLessThanB(a,n,x);
            int high = countGreaterThanB(c,n,x);
            count += (low*high);
            //System.out.print(count);
        }
        return count;
    }

    private static int countGreaterThanB(int[] c, int n, int x) {
        int l=0;
        int r = n-1;
        int index =0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(c[mid]<=x) {
                l= mid+1;
            }
            else{
                r = mid - 1;
                index =mid;
            }
        }
        //System.out.println(index);
        return n-index;
    }

    private static int countLessThanB(int[] a, int n, int x) {
        int l = 0;
        int r = n-1;
        int index = 0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(a[mid]<x)
            {
                l=mid+1;
                index =mid;
            }
            else
                r=mid-1;
        }
        //System.out.println(index+1);
        return index+1;
    }

    public static void main(String[] args) {
        int a[] = { 1, 5 };
        int b[] = { 2, 4 };
        int c[] = { 3, 6 };
        System.out.println(countTriplets(a, b, c));
    }

}
