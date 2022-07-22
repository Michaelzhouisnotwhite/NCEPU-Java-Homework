public class HomeWork_2 {
    public static void main(String[] args) {

        int nn = 0;
        /*
        编程求出自然数101~999中的所有素数，每行显示10个数。
        */
        System.out.print("\n");
        System.out.println("===求出自然数101~999中的所有素数===");
        System.out.print("\n\n");
        for (int i=0; i < 1000;i++)
        {
            int flag = 1;

            // flag判断是否是素数；是‘1’， 非‘0’
            for (int n=2; n < i; n++)
            {
                if (i % n == 0) {
                    flag = 0;
                    break;
                }

            }


            if (flag == 1) {
                nn++;
                System.out.print(i + ",");
                if (nn % 10 == 0 && nn != 0) {
                    System.out.print("\b\n");
            }
            }

        }
        System.out.print("\b\n\n");
    }
}
