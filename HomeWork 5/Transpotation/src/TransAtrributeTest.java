/**
 * @Author: Michael
 * @Date: 2020/10/11 18:22
 */
public class TransAtrributeTest {
    public static void main(String[] args) {
        TransAttribute plane = new Plane();
        TransAttribute ship = new Ship();
        TransAttribute automobile = new Automobile();

        System.out.println("----Plane----");
        System.out.println("-Driving way:" + plane.drivingWay());
        System.out.println("-Manned number:" + plane.mannedNumber());
        System.out.println("-Driving speed:" + plane.drivingSpeed());
        System.out.println("-Open windows?:" + plane.isWinOpen());
        System.out.println();
        System.out.println("----Ship----");
        System.out.println("-Driving way:" + ship.drivingWay());
        System.out.println("-Manned number:" + ship.mannedNumber());
        System.out.println("-Driving speed:" + ship.drivingSpeed());
        System.out.println("-Open windows?:" + ship.isWinOpen());
        System.out.println();
        System.out.println("----Automobile----");
        System.out.println("-Driving way:" + automobile.drivingWay());
        System.out.println("-Manned number:" + automobile.mannedNumber());
        System.out.println("-Driving speed:" + automobile.drivingSpeed());
        System.out.println("-Open windows?:" + automobile.isWinOpen());

        /*
        ----Plane----
        -Driving way:in Sky
        -Manned number:117
        -Driving speed:890
        -Open windows?:false

        ----Ship----
        -Driving way:on Water
        -Manned number:2300
        -Driving speed:55
        -Open windows?:true

        ----Automobile----
        -Driving way:on Road
        -Manned number:7
        -Driving speed:60
        -Open windows?:true
         */
    }
}
