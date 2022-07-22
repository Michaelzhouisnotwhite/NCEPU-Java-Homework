/**
 * @Author: Michael
 * @Date: 2020/10/11 16:56
 */
public class Mycircle implements Area{
    double r;

    public Mycircle(double r) {
        setR(r);
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double clacArea() {
        return r * r * 3.1415926;
    }
}
