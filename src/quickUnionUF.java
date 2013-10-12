public class quickUnionUF {
    private int[] id;
    private int[] weights;
    public quickUnionUF(int n) {
        id= new int[n];
        weights= new int[n];
        for (int i =0;i<n;++i)
        {
            weights[i] = 1;
            id[i] = i;
        }
    }
    public boolean find(int p,int q)
    {
        return (root(p)==root(q));
    }
    public int root(int p)
    {
//        while (id[p] != p)
//        {
//            //id[p] = id[id[p]];
//            p = id[p];
//            //id[p] = root(p);
//
//        }
//        return p;
        if(id[p] == p) return p;
        else {
            id[p]=id[id[p]];
            return (root(id[p]));
        }
    }
    public void union(int p,int q)
    {
        if(weights[p] < weights[q])
        {
            id[root(p)] = root(q);
            weights[q] += weights[p];
        }
        else
        {
            id[root(q)] = root(p);
            weights[p] += weights[q];
        }
    }
    private void showID()
    {
        for (int i=0;i<id.length;i++)
            System.out.print(id[i]);
        System.out.println();
    }
    public static void main(String args[])
    {
        quickUnionUF ob = new quickUnionUF(10);
//        ob.union(4,3);
//        ob.union(3,8);
//        ob.union(6,5);
//        ob.union(9,4);
//        ob.union(2,1);
//
//        System.out.println(ob.find(8, 9));
//        ob.union(5,0);
//        ob.union(7,2);
//        ob.union(6,1);
//        for (int i=0;i<ob.id.length;i++)
//            System.out.print(ob.id[i]);
        ob.union(4,5);
        ob.union(9,7);
        ob.union(0,8);
        ob.union(2,1);
        ob.union(8,7);
        ob.union(4,6);
        ob.union(5,3);
        ob.union(5,2);
        ob.union(0,5);

        ob.showID();

    }
}
