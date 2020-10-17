/*
Given a matrix of integers, task is to find out number of positional elements.
 A positional element is one which is either minimum or maximum in a row or in a column.

*/


public class NumberofPositionalElements {

  public static int findPositional(int a[][], int m, int n) {
    int[] rowmax = new int[m];
    int[] rowmin = new int[m];
    int[] columnmax = new int[n];
    int[] columnmin = new int[n];

    for (int i = 0; i < m; i++) {
      int min_row_value = Integer.MAX_VALUE;
      int max_row_value = Integer.MIN_VALUE;
      for (int j = 0; j < n; j++) {
        if (a[i][j] < min_row_value)
          min_row_value = a[i][j];
        if (a[i][j] > max_row_value)
          max_row_value = a[i][j];
      }
      rowmin[i] = min_row_value;
      rowmax[i] = max_row_value;
    }

    for (int j = 0; j < n; j++) {
      int min_column_value = Integer.MAX_VALUE;
      int max_column_value = Integer.MIN_VALUE;
      for (int i = 0; i < m; i++) {
        if (a[i][j] < min_column_value)
          min_column_value = a[i][j];
        if (a[i][j] > max_column_value)
          max_column_value = a[i][j];
      }
      columnmin[j] = min_column_value;
      columnmax[j] = max_column_value;
    }
    for (int i = 0; i < m; i++) {
      System.out.print(rowmax[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < m; i++) {
      System.out.print(rowmin[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < n; i++) {
      System.out.print(columnmin[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < n; i++) {
      System.out.print(columnmax[i] + " ");
    }
    System.out.println();
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == rowmax[i] || a[i][j] == rowmin[i] || a[i][j] == columnmax[j] || a[i][j] == columnmin[j])
          count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int a[][] = new int[][] { { 1, 3, 4 }, { 5, 2, 9 }, { 8, 7, 6 } };
    int m = 3, n = 3;
    System.out.println(findPositional(a, m, n));
  }
}

