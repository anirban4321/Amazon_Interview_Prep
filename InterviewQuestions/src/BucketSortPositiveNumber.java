import java.util.ArrayList;
import java.util.Collections;

public class BucketSortPositiveNumber {

  public static void main(String[] args) {
    double arr[] = { 0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434 };
    bucketSort(arr);
  }

  private static void bucketSort(double[] arr) {

    ArrayList<Double>[] buckets = new ArrayList[arr.length];
    for (int i = 0; i < buckets.length; i++)
      buckets[i] = new ArrayList<Double>();
    for (int i = 0; i < arr.length; i++) {
      double bucketIndex = (arr.length * arr[i]);
      System.out.println(bucketIndex);
      buckets[(int) bucketIndex].add(arr[i]);
    }
    for (ArrayList<Double> bucket : buckets) {
      Collections.sort(bucket);
    }
    System.out.println("\n\nPrinting buckets after Sorting...");
    printBucket(buckets);
    int index = 0;
    for (ArrayList<Double> list : buckets) {
      for (double value : list) {
        arr[index] = value;
        index++;
      }
    }
    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i]);
    System.out.println();

  }

  private static void printBucket(ArrayList<Double>[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      for (int j = 0; j < buckets[i].size(); j++)
        System.out.print(buckets[i].get(j));
    }
    System.out.println();
  }
}
