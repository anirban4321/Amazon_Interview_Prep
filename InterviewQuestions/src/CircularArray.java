import java.util.List;

public class CircularArray {


    static boolean functionCyclic(int a[])
    {

        int p=0,q=0;
        int n= a.length;
        while(true)
        {
            if(p<0||q<0||p>=n||q>=n)
                return false;
            p=a[p];
            if(p==q) return true;
            if(p<0||q<0||p>=n||q>=n)
                return false;
            p=a[p];
            if(p==q) return true;
            q=a[q];
            if(p==q) return true;
        }

    }
    static int count(int a[])
    {
        if(functionCyclic(a))
        {
            int counterArray[] = new int[a.length];
            for(int i =0 ;i<counterArray.length;i++){
                System.out.print(counterArray[i]+" ");

            }
            System.out.println();
            int count =0;int index=0;
            while(counterArray[index]==0)
            {
                counterArray[index] = count++;
                for(int i =0 ;i<counterArray.length;i++){
                    System.out.print(counterArray[i]+" ");

                }
                System.out.println();
                index = a[index];
                System.out.println("index final"+index);
                System.out.println();
            }
            return count-counterArray[index];
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] ={1,2,1,3,4,8};
        int b[]={1,0};
        boolean isCyclic = functionCyclic(a);
       // System.out.print(isCyclic);
        int length = count(b);
        System.out.println(length);
    }

}
