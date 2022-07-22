/**
 * @Author: Michael
 * @Date: 2020/9/30 22:11
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;


class Complex {
    float x, y;
    double module;
    void setComplex(float x, float y) {
        setX(x);
        setY(y);
    }

    public String getModule() {
        module =  Math.sqrt(this.x * this.x + this.y * this.y);
        BigDecimal bd = new BigDecimal(module);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getX() {
        NumberFormat nf = NumberFormat.getInstance(); // 去除末尾的0
        return nf.format(x);
    }

    public String getY() {
        NumberFormat nf = NumberFormat.getInstance(); // 去除末尾的0
        return nf.format(y);
    }
}

class Sort {
    float[] copy;
    Complex[] num;
    Sort(float[] all, Complex[] num) {
        this.copy = Arrays.copyOf(all, all.length);
        this.num = Arrays.copyOf(num, num.length);
    }
    Complex[] sort() {
        // 冒泡排序

        for (int i = 0; i < this.copy.length-1; i++) {
            for (int j = 0; j < this.copy.length-1-i; j++) {
                if (this.copy[j] < this.copy[j+1]) {
                    float t1 = this.copy[j];
                    this.copy[j] = this.copy[j+1];
                    this.copy[j+1] = t1;
                    Complex t2 = this.num[j];
                    this.num[j] = this.num[j+1];
                    this.num[j+1] = t2;
                }
            }
        }
        return this.num;
    }
}

public class BigComplexTest {
    public static void main(String[] args) {

        System.out.println("----Welcome!----");
        System.out.println("====程序流程：====\n" +
                "1、输入复数元素的个数\n" +
                "2、输入每个复数元素的实部和虚部\n" +
                "3、按照模的大小从大到小排序\n" +
                "4、按照大到小的顺序输出各个复数的值");

        // Complex[][] cplx = new Complex[3][2];
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n输入复数元素的个数:"); // num
        int num = sc.nextInt();
        sc.nextLine();

        if (num < 0)
            System.exit(999);
        Complex[] cplx = new Complex[num];

        float[] module = new float[num];

        for (int i = 0; i < num; i++) {
            float x = 0; // 实部
            float y = 0; // 虚部
            System.out.printf("第 %d 个元素(a+bi)\n", i+1);
            System.out.println("实部：");
            x = sc.nextFloat();
            System.out.println("虚部：");
            y = sc.nextFloat();
            cplx[i] = new Complex();
            cplx[i].setComplex(x, y);
            module[i] = (float) cplx[i].module;
        }
        Sort st = new Sort(module, cplx);
        Complex[] newcplx = st.sort();
        System.out.println("\n\n\n\n----按照模大到小的顺序输出各个复数的值----");
        for (Complex i : newcplx) {
            System.out.printf("%s + %si\n", i.getX(), i.getY());
            /*
                        ----Welcome!----
                        ====程序流程：====
                        1、输入复数元素的个数
                        2、输入每个复数元素的实部和虚部
                        3、按照模的大小从大到小排序
                        4、按照大到小的顺序输出各个复数的值



                        输入复数元素的个数:
                        4
                        第 1 个元素(a+bi)
                        实部：
                        1
                        虚部：
                        2
                        第 2 个元素(a+bi)
                        实部：
                        0.989
                        虚部：
                        3.345
                        第 3 个元素(a+bi)
                        实部：
                        2
                        虚部：
                        3.14
                        第 4 个元素(a+bi)
                        实部：
                        34.5
                        虚部：
                        0.1111




                        ----按照模大到小的顺序输出各个复数的值----
                        1 + 2i
                        0.989 + 3.345i
                        2 + 3.14i
                        34.5 + 0.111i

                        Process finished with exit code 0

         */
        }


    }
}
