import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Author: Michael
 * @Date: 2020/10/11 17:57
 */
public class calAeraTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====计算面积=====");
        System.out.println("请输入矩形长和宽:");

        System.out.println("长：");
        double a = sc.nextDouble();
        System.out.println("宽：");
        double b = sc.nextDouble();
        // Sr
        MyRectengle myRectengle = new MyRectengle(a, b);
        double Srect = myRectengle.clacArea();

        System.out.println("---------");
        // Sc
        System.out.println("请输入圆的半径");
        double r = sc.nextDouble();
        Mycircle mycircle = new Mycircle(r);
        double Scir = mycircle.clacArea();

        // Output
        System.out.println("矩形的面积是：" + Srect);
        System.out.printf("圆的面积是：%.2f\n" , Scir);
        /*
        =====计算面积=====
        请输入矩形长和宽:
        长：
        2.1
        宽：
        3.14
        ---------
        请输入圆的半径
        3
        矩形的面积是：6.594
        圆的面积是：28.27

        Process finished with exit code 0

         */
    }
}
