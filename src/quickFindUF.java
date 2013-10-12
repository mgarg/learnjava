public class quickFindUF {
    //this does not work...
    private int id[];
    public quickFindUF(int n)
    {
         id= new int[n];
        for (int i =0;i<n;++i)
            id[i] = i;

    }
    public boolean find(int p,int q)
    {
        return (id[p]==id[q]);
    }
    public void union(int p,int q)
    {
        for (int i=0;i<id.length;i++)
        {
            if(id[i] == id[p])
            {
                id[i]= id[q];
                System.out.print("i="+id[i]);

            }
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
        quickFindUF ob = new quickFindUF(10);
        ob.union(2,4);
        //ob.showID();

        ob.union(2,6);
        ob.showID();

//        ob.union(6,8);
//        ob.showID();
//
//        ob.union(0,6);
//        ob.showID();
//
//        ob.union(5,8);
//        ob.showID();
//
//        ob.union(9,4);
//        ob.showID();
//
//
//        ob.showID();
    }

}
