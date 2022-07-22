import java.util.Scanner;

class matrix {
    double Length = 0, Width = 0;
    matrix (double Length, double Width) {
        this.Length = Length;
        this.Width = Width;
    }
    double GetPerimeter() {
        return (Length + Width) / 2; // get perimeter
    }
    double GetArea() {
        return Length * Width; // get area
    }
}

public class MatrixTest {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("------计算矩形的周长和面积-----");
        System.out.print("请输入矩形的长：");
        double Length = Input.nextDouble();
        System.out.print("请输入矩阵的宽：");
        double Width  = Input.nextDouble();
        matrix matrix = new matrix(Length, Width);
        double P = matrix.GetPerimeter();
        double A = matrix.GetArea();
        System.out.printf("矩阵的面积是：%.2f\n",  A);
        System.out.println("矩阵的周长是：" + String.format("%.2f", P));
    }
}
