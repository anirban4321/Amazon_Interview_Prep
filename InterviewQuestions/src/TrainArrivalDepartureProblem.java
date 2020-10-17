import java.util.Arrays;

public class TrainArrivalDepartureProblem {

  public static void main(String[] args) {
    int arr[] = { 900, 940, 950, 1100, 1500, 1800, 1900 };
    int dep[] = { 910, 1200, 1120, 1130, 1900, 2000, 1930 };
    int n = arr.length;
    System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
  }

  private static int findPlatform(int[] arr, int[] dep, int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);
    int i = 1, j = 0, plt_no = 1, result = 1;
    while (i < n && j < n) {
      if (arr[i] < dep[j]) {
        plt_no++;
        i++;
        if (result < plt_no)
          result = plt_no;
      } else {
        plt_no--;
        j++;
      }
    }
    return result;
  }
}
