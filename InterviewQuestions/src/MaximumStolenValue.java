/*
There are n houses build in a line, each of which contains some value in it.
A thief is going to steal the maximal value of these houses,
but he can’t steal in two adjacent houses because owner of the stolen houses
will tell his two neighbour left and right side.
What is the maximum stolen value.
Examples:

Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
Output : 19
Thief will steal 6, 1, 8 and 4 from house.

Input  : hval[] = {5, 3, 4, 11, 2}
Output : 16
Thief will steal 5 and 11
 */

public class MaximumStolenValue {
    static int maximumStolenValueWithSpace(int a[])
    {
        int n =a.length;
        if(n==0)
            return 0;
        if(n==1)
            return a[0];
        if(n==2)
            return Math.max(a[0],a[1]);
        int dp[] =new int[n];
        dp[0] = a[0];
        dp[1]=Math.max(a[0],a[1]);
        for(int i=2;i<n;i++)
            dp[i]=Math.max(a[i]+dp[i-2],dp[i-1]);
        return dp[n-1];
    }

    static int maximumStolenValueWithoutSpace(int a[])
    {
        int n = a.length;
        int value1 = a[0];
        if(n==0)
            return 0;
        if(n==1)
            return value1;
        int value2 = Math.max(a[0],a[1]);
        if(n==2)
            return value2;
        int max_value=0;
        for(int i=2;i<n;i++){
            max_value =Math.max(a[i]+value1,value2);
            value1 = value2;
            value2 = max_value;
        }
        return max_value;
    }

    public static void main(String[] args) {
        int a[] ={6,7,1,3,8,2,4};
        System.out.println(maximumStolenValueWithoutSpace(a));
        System.out.println(maximumStolenValueWithSpace(a));
    }
}
