public class Strings {

   static String rev(String str)
    {
        String str1 = "";
        int l = str.length();
        for(int i = l-1;i>= 0 ;i--)
            str1 += str.charAt(i);
        return str1;
    }
    String reverseWords(String str)
    {
        String str1 = rev(str);
        return "";
    }
    public static void main(String args[])
    {
         System.out.println(rev("my"));
    }

}
