public class Sorting {

    boolean less(Comparable a,Comparable b)
    {
        return a.compareTo(b) < 0;
    }
    void exchange(Comparable a[],int i,int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    void disp(Comparable a[])
    {
        for (int i=0;i<a.length;i++)    // if instead we write for(Comparable a1:a)...it doesnt work..why????
        {
            System.out.println(a[i]);
        }
    }
    void selSort(Comparable a[])
    {
        int N = a.length;
        for (int i= 0;i<N-1;i++)
        {
            int min = i;
            for (int j = i+1;j<N;j++)
            {
                if(less(a[j],a[min]))
                    min = j;
            }
            exchange(a,i,min);
        }
    }
    void insertionSort(Comparable a[])
    {
        int N = a.length;
        for (int i = 1;i<N;i++)
        {
            for (int j = i;j>0 && less(a[j],a[j-1]);j--)
                    exchange(a,j,j-1);
        }
    }
    public static void main(String args[])
    {
        Sorting ob = new Sorting();
        //Comparable[] a = new Comparable<Integer>[]{};
        String[] a = new String[]{"ab","aa","aab","ad","ca"};
        //ob.disp(a);
//        ob.selSort(a);
        ob.insertionSort(a);

        ob.disp(a);
    }
}
