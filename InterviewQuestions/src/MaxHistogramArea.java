/* Given an array representing height of bar in bar graph, find max histogram
 * area in the bar graph. Max histogram will be max rectangular area in the
 * graph.
 *
 * Maintain a stack
 *
 * If stack is empty or value at index of stack is less than or equal to value at current
 * index, push this into stack.
 * Otherwise keep removing values from stack till value at index at top of stack is
 * less than value at current index.
 * While removing value from stack calculate area
 * if stack is empty
 * it means that till this point value just removed has to be smallest element
 * so area = input[top] * i
 * if stack is not empty then this value at index top is less than or equal to
 * everything from stack top + 1 till i. So area will
 * area = input[top] * (i - stack.peek() - 1);
 * Finally maxArea is area if area is greater than maxArea.
 *
 *
 * Time complexity is O(n)
 * Space complexity is O(n)
 *
 * References:
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxHistogramArea {

  public static int calculateMaxHistArea(int[] barGraphHeight) {
    Deque<Integer> indexHeight = new LinkedList<>();
    int maxArea = 0;
    int area = 0;
    int top = 0;
    int i;
    for (i = 0; i < barGraphHeight.length; ) {
      if (indexHeight.isEmpty() || barGraphHeight[indexHeight.peekFirst()] <= barGraphHeight[i])
        indexHeight.offerFirst(i++);
      else {
        top = indexHeight.pollFirst();
        if (indexHeight.isEmpty())
          area = barGraphHeight[top] * i;
        else
          area = barGraphHeight[top] * (i - indexHeight.peekFirst() - 1);
        if (area > maxArea)
          maxArea = area;
      }
    }
    while (!indexHeight.isEmpty()) {
      top = indexHeight.pollFirst();
      if (indexHeight.isEmpty())
        area = barGraphHeight[top] * i;
      else
        area = barGraphHeight[top] * (i - indexHeight.peekFirst() - 1);
      if (area > maxArea)
        maxArea = area;
    }
    return maxArea;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int barGraphHeight[] = new int[n];
    for (int i = 0; i < n; i++) {
      barGraphHeight[i] = sc.nextInt();
    }
    int result = calculateMaxHistArea(barGraphHeight);
    System.out.println(result);
  }

}
