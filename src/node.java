public class node {
    int key;
    node left;
    node right;

    node()
    {
        key = -99999;
        left = null;
        right = null;
    }
    node(int key,node left,node right)
    {
        this.key = key;
        this.left = left;
        this.right = right;
    }
    node insert(node r,int val)
    {
        if(r == null)
            return new node(val,null,null);
        else if(val > r.key)
            return (insert(r.right,val));
        else return (insert(r.left,val));

    }
    void inorder(node r)
    {
        if(r != null)
        {
            inorder(r.left);
            System.out.println(r.key);
            inorder(r.right);
        }
    }
    public static void main(String args[])
    {
       node n = new node(-99999,null,null);
       node n1 = n.insert(n,2);
       n.inorder(n1.insert(n, 3));

    }
}
