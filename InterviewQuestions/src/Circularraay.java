public class Circularraay {

  public static int countCycles(int[] data) {
    int[] counters = new int[data.length];
    int index = 0;
    int count = 0;
    while (counters[index] == 0) {
      counters[index] = count++;
            /*System.out.println("yiigsasigosa"+counters[index]);
            System.out.println("sgyufsuf"+count);*/
      index = data[index];
      System.out.println("index at the end " + index);
    }
    System.out.println(index + ":::::" + count);
    System.out.println("_______________________________________________");
    for (int i = 0; i < counters.length; i++)
      System.out.println(counters[i]);
    return count - counters[index];
  }

  public static void main(String[] args) {
    System.out.println(countCycles(new int[] { 1, 2, 3 }));
  }
}
