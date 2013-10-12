public class stackMain {
    public static void main(String args[])
    {
        //test client..
        // read string from standard input
        //. if string equals "-", pop string from stack and print
        //. otherwise push string onto stack

        String arr[] = new String[]{"to","be","or","not","to","-","be","-","-","that","-","-","-","is"};
        stackLinkedList ob = new stackLinkedList();
        for (String str:arr)
        {
            if(str == "-")
                System.out.print(ob.pop()+" ");
            else ob.push(str);
        }
    }
}
