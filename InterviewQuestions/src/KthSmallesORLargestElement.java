/*
K’th Smallest/Largest Element in Unsorted Array

Given an array and a number k where k is smaller than the size of the array,
we need to find the k’th smallest element in the given array.
It is given that all array elements are distinct.
 */



public class KthSmallesORLargestElement {

    public static void main(String[] args) {
        int[] array = new int[]{10, 4, 5, 8, 6, 11, 26};
        int[] arraycopy = new int[]{10, 4, 5, 8, 6, 11, 26};

        int kPosition = 3;
        int length = array.length;

        if(kPosition > length)
        {
            System.out.println("Index out of bound");
        }
        else
        {
            // find kth smallest value
            System.out.println("K-th smallest element in array : " +
                    kthSmallest(arraycopy, 0, length - 1,
                            kPosition - 1));
        }
    }

    private static int kthSmallest(int[] a, int low, int high, int k) {
        int partition =partition(a,low,high);
        if(partition ==k )
            return a[partition];
        else if(k<partition)
            return kthSmallest(a,low,partition-1,k);
        else
            return  kthSmallest(a,partition+1,high,k);


    }

    private static int partition(int[] a, int low, int high) {
        //int pivot = (int)(Math.random()) * (a.length-1);
        int pivot = a[high];
        int pivotloc = low;
        for(int i=low;i<=high;i++) {
            if (a[i] < pivot) {
                //swap(a[i], a[pivotloc]);
                int temp = a[i];
                a[i] = a[pivotloc];
                a[pivotloc] = temp;
                pivotloc++;
                //pivotloc++;
            }
        }
            //swap(a[pivotloc],a[high]);
        int temp = a[high];
        a[high] = a[pivotloc];
        a[pivotloc] = temp;
          return pivotloc;

    }

    private static void swap(int a, int b) {
        int temp= a;
        a=b;
        b=temp;
    }
}
