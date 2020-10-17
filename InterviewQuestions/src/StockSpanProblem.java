/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock
and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just
before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}

 */

import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);
        System.out.println("Printing the values using stack");
        calculateSpanWithStack(price,n,S);
    }

    private static void calculateSpan(int[] price, int n, int[] s) {
        s[0] = 1;

        for (int i = 1; i < n; i++) {
            s[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (price[j] <= price[i]) {
                    s[i]++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(s[i] + " ");
        System.out.println();
    }
   private static void calculateSpanWithStack(int[] price, int n, int[] s){
       Stack<Integer> st =new Stack();
       st.push(0);
       for(int i=0;i<n;i++) {
           while (!st.empty() && price[st.peek()] <= price[i])
               st.pop();
           if(st.empty())
               s[i]=i+1;
           else
              s[i]= i-st.peek();
           st.push(i);
       }
       for(int i=0;i<n;i++)
           System.out.print(s[i]+" ");
   }
}
