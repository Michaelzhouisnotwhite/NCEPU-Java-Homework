public class HomeWork_3 {
    public static void main(String[] args) {

        /*
        编程顺序输出1到100之间所有能被11整除的整数
         */
        System.out.println("\n==== 编程顺序输出1到100之间所有能被11整除的整数 ====\n");
        int IntNum;
        for (IntNum = 1; IntNum <= 100; IntNum++)
        {
            if (IntNum % 11 == 0)
                System.out.print(IntNum + ",");
        }
        System.out.println("\b\n");
    }
}
