/**
 * @Author: Michael
 * @Date: 2020/10/11 18:17
 */
public class Ship extends TransAttribute{

    @Override
    public int mannedNumber() {
        return 2300;
    }

    @Override
    public String drivingWay() {
        return "on Water";
    }

    @Override
    public int drivingSpeed() {
        return 55;
    }

    public boolean isWinOpen() {
        return true;
    }
}
