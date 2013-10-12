import java.util.HashMap;
import java.util.Map;

// a map in java is nothing but an associative array
public class Histogram {
    Map<Comparable ,Integer> freqTable(Comparable a[])
    {
        Map<Comparable,Integer> map = new HashMap<>();
        Sorting sorting = new Sorting();
        sorting.insertionSort(a);
       // sorting.disp(a);
        int i=0,c;
        Comparable item = a[0];
        while (i<a.length-1) // we are always leaving the last element here...
        {
            c =0;
            while (item == a[i])
            {
                 c++;
                i++;
            }
            map.put(item,c);
            item = a[i];

        }
       // if(a[a.length-1] == item) map.
        return map;
    }
    void disp(Map<Comparable,Integer> map)
    {
        //System.out.print(map.toString());
        for (Map.Entry<Comparable, Integer> c : map.entrySet())
        {   System.out.print(c.getKey());
            for (int i=0;i<c.getValue();i++)
                System.out.print("+");
            System.out.println();
        }


    }
    public static void main(String args[])
    {
        Histogram histogram = new Histogram();
        String a[] = new String[]{"200","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2", "2","3","4","1","5","4","3","6","5"};
        histogram.disp(histogram.freqTable(a));
    }
}

