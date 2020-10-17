/*
Stock Buy Sell to Maximize Profit
The cost of a stock on each day is given in an array,
find the max profit that you can make by buying and selling in those days.
For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
the maximum profit can earned by buying on day 0, selling on day 3.
Again buy on day 4 and sell on day 6.
If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
*/

import java.util.ArrayList;

public class StockBuySellProblemMaximumProfit {

  //If we are allowed to buy and sell only once, then we can use following algorithm.
  //O(n^2)
  public static int[] MaximumProfit_1(int[] a) {
    int maxdiff = a[1] - a[0];
    int[] b = new int[3];
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (maxdiff < a[j] - a[i]) {
          maxdiff = a[j] - a[i];
          b[0] = i;
          b[1] = j;
          b[2] = maxdiff;
        }
      }

    }
    return b;
  }

  //Efficient algo::
  //If we are allowed to buy and sell only once, then we can use following algorithm.
  //O(n)
  public static int[] MaximumProfit_2(int[] a) {
    int maxdiff = a[1] - a[0];
    int min_element = a[0];
    int[] b = new int[3];
    for (int i = 1; i < a.length; i++) {
      if (a[i] - min_element > maxdiff) {
        maxdiff = a[i] - min_element;
        b[1] = i;
        b[2] = maxdiff;
      }
      if (min_element > a[i]) {
        min_element = a[i];
        b[0] = i;
      }

    }
    return b;
  }

  static void StockBuySell(int[] a) {
    if (a.length == 1)
      return;
    int count = 0;
    ArrayList<Interval> arrayList = new ArrayList<Interval>();
    int profit = 0;
    int i = 0;
    while (i < a.length - 1) {
      while (i < a.length - 1 && a[i + 1] <= a[i])
        i++;
      if (i == a.length - 1)
        break;
      Interval e = new Interval();
      e.buy = i++;

      while (i < a.length && a[i] >= a[i - 1])
        i++;
      e.sell = i - 1;
      arrayList.add(e);
      count++;
    }
    if (count == 0)
      System.out.println("-1");
    else {
      for (int j = 0; j < count; j++) {
        System.out.println("Buy on:  " + arrayList.get(j).buy + " " + "Sell on:  " + arrayList.get(j).sell);
        profit += a[arrayList.get(j).sell] - a[arrayList.get(j).buy];
      }
    }
    System.out.println(profit);
    return;
  }

  public static void main(String[] args) {
    //int price[] = { 100, 180, 260, 310, 40, 535, 695 };
    // int price[] = {1, 2, 90, 10, 110};
    int price[] = { 2, 5, 7, 1, 4, 3, 1, 3 };
    System.out.println("Calling out bruteforce implementation");
    for (int i = 0; i < MaximumProfit_1(price).length; i++)
      System.out.print(MaximumProfit_1(price)[i] + " ");
    System.out.println();
    System.out.println("Printing elements which produced maximum difference ****");
    System.out.println(price[MaximumProfit_1(price)[0]] + " " + price[MaximumProfit_1(price)[1]]);

    System.out.println("*******************************************************************");

    System.out.println("Calling out efficient(O(n)&O(1)) implementation");
    for (int i = 0; i < MaximumProfit_2(price).length; i++)
      System.out.print(MaximumProfit_2(price)[i] + " ");
    System.out.println();
    System.out.println("Printing elements which produced maximum difference ****");
    System.out.println(price[MaximumProfit_2(price)[0]] + " " + price[MaximumProfit_2(price)[1]]);
    System.out.println();

    System.out.println("*******************************************************************");

    System.out.println("Calling out buying and selling stock method multpile times implementation");
    StockBuySell(price);
  }

  //If we are allowed to buy and sell multiple times.
  //ALGORITHM::
    /*

    1. Find the local minima and store it as starting index.If not ,return.
    2.Find the local maxima and store it as ending index.If it reaches the end,set end as the ending index
    3.Update the solution(Increment count of buy sell pairs)
    4.Repeat the steps if end is not reached.

    */
  static class Interval {

    int buy;

    int sell;
  }

}
