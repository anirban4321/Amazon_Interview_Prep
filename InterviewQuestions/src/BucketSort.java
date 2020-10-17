import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BucketSort {

  public static void main(String[] args) {
    int arr[] = new int[10];

    //Generating 100 random numbers in the range of 0-100
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      arr[i] = random.nextInt(10) + 10;

    }
    bucketSort(arr);
  }

  public static void bucketSort(int a[]) {
    int numberOfBuckets = (int) Math.ceil(Math.sqrt(a.length));
    int maxValue = Integer.MIN_VALUE;
    int minValue = Integer.MAX_VALUE;

    for (int value : a) {
      if (value > maxValue)
        maxValue = value;
      else if (value < minValue)
        minValue = value;
    }
    ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
    for (int i = 0; i < buckets.length; i++)
      buckets[i] = new ArrayList<Integer>();
    for (int value : a) {
      int bucketNumber = (int) Math.ceil(value * numberOfBuckets / maxValue);
      buckets[bucketNumber - 1].add(value);
    }
    System.out.println("\n\nPrinting buckets before Sorting...");
    printBucket(buckets);

    for (ArrayList<Integer> bucket : buckets)
      Collections.sort(bucket);
    System.out.println("\n\nPrinting buckets after Sorting...");
    printBucket(buckets);

    int index = 0;
    for (ArrayList<Integer> list : buckets) {
      for (int value : list) {
        a[index] = value;
        index++;
      }
    }
  }

  private static void printBucket(ArrayList<Integer>[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      for (int j = 0; j < buckets[i].size(); j++)
        System.out.print(buckets[i].get(j) + " ");
    }
    System.out.println();
  }
}
