/*
Largest Sum Contiguous Subarray
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
kadane-algorithm
 */

public class LongestContiguousSubarrayWithMaxSumIncludingNegative {
    public static void main (String[] args)
    {
       // int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int [] a = {2,-3,4,3,6,-4,4,3,1,2};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a)[0]+" "+maxSubArraySum(a)[1]+" "+maxSubArraySum(a)[2]);
    }

    private static int[] maxSubArraySum(int[] a) {
        int max_till_now=Integer.MIN_VALUE;
        int max_ending__here=0;
        int begin=0;
        int temp[]=new int[3];
        for(int i=0;i<a.length;i++)
        {
            max_ending__here+=a[i];
            if(max_till_now<max_ending__here) {
                max_till_now = max_ending__here;
                temp[0] =begin;
                temp[1] = i;
                temp[2]=max_ending__here;
            }
            if(max_ending__here<0)
            {
                max_ending__here=0;
                begin=i+1;
            }
        }
        return temp;
    }

}
