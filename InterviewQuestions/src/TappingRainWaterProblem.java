/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
Examples:

Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_|
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2
and 4.  See below diagram also.

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
       |
   |   || |
_|_||_||||||
Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2
 */
public class TappingRainWaterProblem {

    public static int countWaterDrops(int a[])
    {
        int count =0;
        int n= a.length;
        int left[] = new int[n];
        int right[] =  new int [n];
        left[0]=a[0];
        right[n-1]=a[n-1];
        for(int i=1;i<n;i++)
        {
            if(a[i]<left[i-1])
                left[i]=left[i-1];
            else
                left[i]=a[i];
        }
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]<right[i+1])
                right[i]=right[i+1];
            else
                right[i]=a[i];
        }
        for(int i=0;i<n;i++) {
            if (left[i] < right[i])
                count += left[i] - a[i];
            else
                count += right[i] - a[i];
        }

        return count;
    }


    /*
    Space Optimization in above solution:
    Instead of maintaing two arrays of size n for storing left and right max of each element,
    we will just maintain two variables to store the maximum till that point.
    Since water trapped at any element = min( max_left, max_right) – arr[i]
    we will calculate water trapped on smaller element out of A[lo] and A[hi] first
    and move the pointers till lo doesn’t cross hi.
     */
    public static int countWaterDropsWithoutSpace(int[] a)
    {
        int count =0;
        int n= a.length;
        int low =0;
        int high=n-1;
        int left_max=0;
        int right_max=0;
        while(low<=high)
        {
            if(a[low]<a[high])
            {
                if(a[low]>left_max)
                    left_max=a[low];
                else
                {
                    count+=left_max-a[low];
                }
                low++;
            }
            else{
                if(a[high]>right_max)
                    right_max=a[high];
                else
                {
                    count+=right_max-a[high];
                }
                high--;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Maximum water that can be accumulated is " +
                countWaterDrops(arr));
        System.out.println("Maximum water that can be accumulated is " +
                countWaterDropsWithoutSpace(arr));

    }

}
