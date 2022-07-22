/**
 * @Author: Michael
 * @Date: 2020/10/11 18:16
 */
public class Plane extends TransAttribute {

    @Override
    public boolean isWinOpen() {
        return false;
    }

    @Override
    public int mannedNumber() {
        return 117;
    }

    @Override
    public String drivingWay() {
        return "in Sky";
    }

    @Override
    public int drivingSpeed() {
        return 890;
    }
}
