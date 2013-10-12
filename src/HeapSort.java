public class HeapSort {

    int heapsize;
    HeapSort()
    {
        heapsize = 0;
    }
    boolean odd(int i)
    {
        if(i % 2 != 0) return true;
        return false;
    }
    int parent(int i)
    {
        if(odd(i)) return i/2;
        return i/2 +1;
    }
    int left(int i)
    {
        return 2*i +1;
    }
    int right(int i)
    {
        return 2*i+2;
    }
    void maxHeapify(int a[],int i)
    {
       // heapsize = a.length;

        int l = left(i);
        //System.out.println("left is" +l);
        int r = right(i);
        int largest;
        if(l<heapsize && a[l]>a[i])          ////must check for the heapsize condition first...
                                             ////this is very important else it will create an index out of bounds exception
            largest = l;
        else largest = i;
        if ( r<heapsize && a[r]>a[largest])
            largest = r;
        if(i != largest)
        {
            int t = a[largest];
            a[largest] = a[i];
            a[i] = t;
            maxHeapify(a,largest);
        }
    }
    void makeHeap(int a[])
    {
         heapsize = a.length;
         for (int i = a.length/2-1;i>=0;i--)
             maxHeapify(a,i);
    }
    void heapSort(int a[])
    {
        makeHeap(a);
        for (int i = a.length-1;i>=1;i--)
        {
            int t = a[i];
            a[i] = a[0];
            a[0] = t;
            heapsize--;
            maxHeapify(a,0);
        }
    }
    void disp(int a[])
    {
        for (int i = 0;i<a.length;i++)
            System.out.print(a[i]+", ");
        System.out.println();

    }
    public static void main(String[] args) {

        HeapSort ob = new HeapSort();
        int a[] = {4,1,3,2,16,9,10,14,8,7};
        ob.disp(a);
        ob.heapSort(a);
        ob.disp(a);
    }
}
