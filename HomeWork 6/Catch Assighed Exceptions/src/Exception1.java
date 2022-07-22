import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Time : 2020/10/16 23:29
 * @Author : Michael
 */

public class Exception1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入星期几：");
        int day = 0;
        try {
            day = sc.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("类型不匹配异常!");
        }
        if (day>7 || day <0) {
            throw new Exception("输入的值不合理");

        }
//        else
            System.out.println("星期 " + day);
    }
}
