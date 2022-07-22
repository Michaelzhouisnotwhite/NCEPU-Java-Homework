/**
 * @Author: Michael
 * @Date: 2020/10/11 16:56
 */
public class MyRectengle implements Area{
    double a, b;

    public MyRectengle(double a, double b) {
        setA(a);
        setB(b);
    }
    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double clacArea() {
        return a*b;
    }
}
