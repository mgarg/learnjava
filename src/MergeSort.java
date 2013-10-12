public class MergeSort {
    boolean less(Comparable a,Comparable b)
    {
        return a.compareTo(b) < 0;
    }
    void disp(Comparable a[])
    {
        for (int i=0;i<a.length;i++)    // if instead we write for(Comparable a1:a)...it doesnt work..why????
        {
            System.out.println(a[i]);
        }
    }
    Comparable[] merge(Comparable a[],Comparable b[])
    {
        int p1 = 0,p2 =0,count =0;
        Comparable c[] = new Comparable[a.length+b.length];
        while (p1<a.length && p2<b.length)
        {
             if(less(a[p1],b[p2])) c[count++] = a[p1++];
             else c[count++] = b[p2++];
        }
        if (p1 == a.length)
            while (p2<b.length) c[count++] = b[p2++];
        else
            while (p1<a.length) c[count++] = a[p1++];
        return c;
    }
    Comparable[] mergeSortRec(Comparable a[])
    {
         return mergeSortRecH(a, 0, a.length - 1);
    }

    Comparable[] mergeSortRecH(Comparable a[],int p,int q)
    {
        if(p<q)
        {
            int mid = (q-p)/2 + p;
            return merge(mergeSortRecH(a,p,mid-1),mergeSortRecH(a,mid+1,q));
        }
        return new Comparable[]{a[p]};
    }
    public static void main(String args[])
    {
        String[] a = new String[]{"ab","aa","aab","ad","ca"};
        String[] b = new String[]{"a","aaa","ada","ca"};
        MergeSort m = new MergeSort();
//        Sorting s = new Sorting();
//        s.insertionSort(a);
//        s.insertionSort(b);
        m.disp(m.mergeSortRec(a));
        //m.disp(m.merge(a,b));
    }
}
