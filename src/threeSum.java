public class threeSum {
    int[] arr;
    threeSum()
    {
        arr = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
    }
    void sort()
    {
        for (int i =0;i<arr.length-1;i++)
        {
            for (int j =i+1;j<arr.length;j++)
            {
                if(arr[j] < arr[i])
                {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
    void disp()
    {
        for (int i:arr)
            System.out.print(i+" ");
        System.out.println();

    }
    boolean bSearch(int k)
    {
        int lo = 0;
        int hi = arr.length-1;
        while (lo<=hi)
        {
            int m = lo + (hi-lo)/2;
            if (arr[m] == k) return true;
            else if (k < arr[m]) hi = m-1;
            else lo = m+1;
        }
        return false;
    }
    int countSum()
    {
        int c = 0;
        sort();
        for (int i =0;i<arr.length;i++)
        {
            for (int j =i+1;j<arr.length;j++)
            {
                int k = -(arr[i]+arr[j]);
                //System.out.println("k ="+k);
                if(arr[i] <arr[j] && arr[j] < k) // this condition is very important to avoid double counting...
                      if(bSearch(k)) c++;
            }
        }
        return c;
    }
    int cs()
    {
        int c = 0;
        for (int i =0;i<arr.length;i++)
        {
            for (int j =i+1;j<arr.length;j++)
            {
                for (int k=j+1;k<arr.length;k++)
                {
                    if((arr[i] + arr[j] + arr[k]) == 0) c++;
                }
            }
        }
        return c;
    }
    public static void main(String args[])
    {
        threeSum ob = new threeSum();
        //System.out.print(ob.cs());
       System.out.print(ob.countSum());
//        ob.sort();
//       for (int i:ob.arr)
//           System.out.println(ob.bSearch(i));
        //ob.disp();
    }
}
