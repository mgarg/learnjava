public class quickSort {
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
    void sort(Comparable a[])
    {
        sort(a,0,a.length-1);
    }
    void sort(Comparable a[],int i,int j)
    {
        if(i<j)
        {   disp(a);
            int k = partition(a,i,j);
            sort(a,i,k-1);
            sort(a,k+1,j);
        }
    }
    int partition(Comparable a[],int lo,int hi)
    {
        int i = lo+1;
        int j = hi;
        while (true)
        {
            while(less(a[i++],a[lo]))
                if(i == hi) break;
            while (less(a[lo],a[--j]))
                if (j == lo) break;

            if(i>=j) break;
            exchange(a,i,j);
        }
        exchange(a,lo,j);
        return j;
    }
    public static void main(String args[])
    {
        quickSort ob = new quickSort();
        String[] a = new String[]{"ab","aa","aab","ad","ca"};
        //System.out.println(ob.partition(a,0,a.length-1));
        ob.sort(a);
        //ob.disp(a);
    }
}
