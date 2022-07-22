import java.util.Scanner;

public class HomeWork_4 {
    public static void main(String[] args) {

        int score;
        Scanner Input = new Scanner(System.in);
        System.out.println("=== 从键盘输入一个0-100的整数来的到等级划分 ===\n\n");
        while (true)
        {
            while (true) {
                System.out.println("请输入成绩：");
                score = Input.nextInt();

                if (100 < score || score < 0) {
                    System.out.println("输入错误，请重新输入");
                }
                else
                    break;
            }

            if (90 <= score)
            {
                System.out.println('A');
            }

            if (80 <= score && score < 90)
            {
                System.out.println('B');
            }

            if (70 <= score && score < 80)
            {
                System.out.println('C');
            }

            if (60 <= score && score < 70)
            {
                System.out.println('D');
            }

            if (score < 60)
            {
                System.out.println('E');
            }

            System.out.println("是否需要继续输入：");
            while (true){
                String str = Input.next();
                if (str.equals("N"))
                {
                    System.out.println("程序以退出！");
                    System.exit(0);
                }
                if (!str.equals("Y"))
                {
                    System.out.println("输入错误请重新输入！");
                }
                else
                    break;
            }

        }
    }
}
