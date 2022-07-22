import java.util.Scanner;

class Mpoint{
    double x;
    double y;
    Mpoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    void output(){
        System.out.println("当前的坐标是：");
        System.out.println("(" + x + "," + y + ")");
    }
    void revise(double x, double y){
        this.x = x;
        this.y = y;
    }
}

public class Point {
    public static void main(String[] args) {
        System.out.println("请输入坐标的值（默认(0,0)）:");
        Scanner Input = new Scanner(System.in);
        System.out.print("x = ");
        double x = Input.nextDouble();
        System.out.print("y = ");
        double y = Input.nextDouble();
        Mpoint myPoint = new Mpoint(x, y);


        while (true){
            System.out.println("是否继续(1/0):");
            int flag = Input.nextInt();
            if (flag != 0 && flag != 1) {
                System.out.println("错误，请重新输入！");
            }
            else if (flag == 0) {
                System.out.println("已退出");
                System.exit(1);
            }
            else {
                // myPoint.output();
                System.out.println("修改坐标值：");
                System.out.print("x = ");
                x = Input.nextDouble();
                System.out.print("y = ");
                y = Input.nextDouble();
                myPoint.revise(x, y);
                myPoint.output();
            }
        }
    }
}

