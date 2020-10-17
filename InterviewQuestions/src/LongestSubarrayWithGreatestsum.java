public class LongestSubarrayWithGreatestsum {

    public static void longestSubArray(int[] A, int n)
    {
        int max_till_now = 0;
        int max_ending_here=0;
        int start = 0 ,  end =0;
        int begin = 0;

        for(int i=0;i<n;i++) {
            if (A[i] > 0) {
                max_ending_here = max_ending_here + A[i];
            } else {
                max_ending_here = 0;
                begin = i + 1;
            }
            if (max_till_now < max_ending_here) {
                max_till_now = max_ending_here;
                start = begin;
                end = i;
            }
        }
        for(int i=start;i<=end;i++)
        {
            System.out.println(A[i]);
        }
        System.out.println("Length of maximum subarray::" + (end-start+1));
        System.out.println("Maximum Sum is ::" + max_till_now);
    }

    public static void main(String[] args) {
        int [] A = {2,-3,4,3,6,-4,4,3,1,2};
        longestSubArray(A, A.length);
    }
}
