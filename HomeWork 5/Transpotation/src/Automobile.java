/**
 * @Author: Michael
 * @Date: 2020/10/11 18:17
 */
public class Automobile extends TransAttribute {

    @Override
    public int mannedNumber() {
        return 7;
    }

    @Override
    public String drivingWay() {
        return "on Road";
    }

    @Override
    public int drivingSpeed() {
        return 60;
    }

    public boolean isWinOpen() {
        return true;
    }
}
