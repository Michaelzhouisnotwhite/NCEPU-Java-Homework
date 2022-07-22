/**
 * @ Author: Michael
 * @ Date: 2020/10/1 16:35
 */



public class CompareTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcd";
        String s3 = "abh";
        String s4 = "abedf";
        String s5 = "cdfg";
        String s6 = "cdfg";
        System.out.println( "String s1 = \"abc\";\n" +
                            "String s2 = \"abcd\";\n" +
                            "String s3 = \"abcdfg\";\n" +
                            "String s4 = \"abedf\";\n" +
                            "String s5 = \"cdfg\";\n" +
                            "String s6 = \"cdfg\";");
        System.out.println("----------------------------");
        System.out.println("compare(s1, s2): " + Compare.compare(s1, s2));
        System.out.println("compare(s3, s4): " + Compare.compare(s3, s4));
        System.out.println("compare(s5, s6): " + Compare.compare(s5, s6));
    }

    public static class Compare{
        public static int compare(String string1, String string2){
//            char[] list1=this.string1.toCharArray();
//            char[] list2=this.string2.toCharArray();
            return string1.compareTo(string2);
        }
    }
}