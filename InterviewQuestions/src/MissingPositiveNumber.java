import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.PrintStream;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 *
 * We can use sorting to solve it in lesser time complexity.
 * We can sort the array in O(nLogn) time. Once the array is sorted, then all we need to do is a linear scan of the array.
 * So this approach takes O(nLogn + n) time which is O(nLogn).
 *
 * We can also use hashing. We can build a hash table of all positive elements in the given array.
 * Once the hash table is built. We can look in the hash table for all positive integers, starting from 1.
 * As soon as we find a number which is not there in hash table, we return it.
 * This approach may take O(n) time on average, but it requires O(n) extra space.
 */


public class MissingPositiveNumber {

   /* public static int missingNumber(int[] A) {

        *//*int miss=1;
        for(int i=0; i<nums.length; i++){
            miss ^= (i+1) ^nums[i];
        }

        return miss;*//*

        while(A[i]!=i)
        {
            if(A[i]<0 || A[i]>n )
                break;
        }
    }*/

    public static int missingNumber(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            // when the ith element is not i
            while (A[i] != i) {
                // no need to swap when ith element is out of range [0,n]
                if (A[i] <=0 || A[i] >= n)
                    break;

                //handle duplicate elements
                if(A[i]==A[A[i]])
                    break;
                // swap elements
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }
        for(int i=0;i< A.length;i++)
            System.out.print(A[i]+" ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (A[i] != i && i>0)
                return i;
        }

        return n;
    }

    public static void main(String[] args) {
        int [] A = {1,2,2,4};
        //int [] B ={3,4,-1,-2,1,5,5,3,0,2};
       // int number = missingNumber(A);
        System.out.println(missingNumber(A));
    }
}
