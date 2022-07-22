import java.util.Scanner;

class complex {
    float u, v;
    void Input(float u, float v) {
        this.u = u;
        this.v = v;
    }
    void output() {
        System.out.println(u + "+" + v +"i");
    }
}


public class complexTest {
    public static void main(String[] args) {
        float u = 0, v = 0;
        System.out.println("=========创建复数对象并输出===========");
        System.out.print("请输入创建的对象个数：");
        Scanner inNum = new Scanner(System.in);
        int iNum = inNum.nextInt();
        complex[] in = new complex[iNum];

        for (int i=0; i < iNum; i++)
        {
            System.out.printf("请输入第%d个复数的值:\n", i +1);
            System.out.print("----请输入实部：");
            u = inNum.nextFloat();
            System.out.print("----请输入虚部：");
            v = inNum.nextFloat();
            in[i] = new complex();
            in[i].Input(u, v);
        }

        System.out.println("复数输出为：");
        for (int i=0; i < iNum; i++) {
            in[i].output();
        }
        /*
        =========创建复数对象并输出===========
        请输入创建的对象个数：2
        请输入第1个复数的值:
        ----请输入实部：2.34
        ----请输入虚部：3.45
        请输入第2个复数的值:
        ----请输入实部：34.56
        ----请输入虚部：78.999
        复数输出为：
        2.34+3.45i
        34.56+78.999i

        Process finished with exit code 0

         */
    }
}
