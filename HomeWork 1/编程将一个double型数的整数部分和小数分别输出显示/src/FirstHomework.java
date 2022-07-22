import java.util.Scanner;

public class FirstHomework {
    public static void main(String[] args) {
        System.out.println("====输入一个浮点数并分别输出它的整数部分和小数部分====");
        double input;
        System.out.println("请输入一个浮点数：");
        Scanner scanf = new Scanner(System.in);
        input = scanf.nextDouble();


        // split以“.”分割字符串
        // String[] = {'a', 'bc'};
        // String = 'abc';
        String[] decimal = String.valueOf(input).split("\\.", 2);
        System.out.println("整数部分是：" + decimal[0]);
        System.out.println("小数部分是：" + 0 + '.' + decimal[1]);
    }
}
