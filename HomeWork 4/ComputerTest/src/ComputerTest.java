import javax.swing.*;
import java.util.Scanner;

/**
 * @ Author: Michael
 * @ Date: 2020/10/1 16:49
 */

class Computer {
    int price;
    float screen_size;
    public Computer(int price, float screen_size) {
        this.price = price;
        this.screen_size = screen_size;
    }

    void rankingP() {
        int p = this.price;
        if ( 2000 <= p && p <= 4000) {
            System.out.println("电脑价格的等级是：C");
        }
        else if ( 4000 < p && p <= 6000) {
            System.out.println("电脑价格的等级是：B");
        }
        else if ( 6000 < p && p <= 8000) {
            System.out.println("电脑价格的等级是：A");
        }
        else if ( 8000 < p) {
            System.out.println("电脑价格的等级是：SuperA");
        }
    }

    void rankingS() {
        float p = this.screen_size;
        if ( 13 <= p && p <= 20) {
            System.out.println("电脑屏幕的等级是：C");
        }
        else if ( 20 < p && p <= 30) {
            System.out.println("电脑屏幕的等级是：B");
        }
        else if ( 30 < p) {
            System.out.println("电脑屏幕的等级是：SuperA");
        }
    }
}

class Laptop extends Computer {

    public Laptop(int price, float screen_size) {
        super(price-500, screen_size);
    }

}

class Desktop extends Computer {

    public Desktop(int price, float screen_size) {
        super(price+500, screen_size);
    }
}

public class ComputerTest {
    public static void main(String[] args) {
        System.out.println("请选择你的电脑品种:");
        System.out.println("1、台式机\n" +
                "2、笔记本");
        Scanner sc = new Scanner(System.in);
        int alt = sc.nextInt();
        switch (alt) {
            case 2 -> {
                System.out.println("请输入笔记本的价格和屏幕尺寸:");
                int priceL = sc.nextInt();
                float screen_sizeL = sc.nextFloat();
                Laptop L = new Laptop(priceL, screen_sizeL);
                L.rankingP();
                L.rankingS();
            }
            case 1 -> {
                System.out.println("请输入台式机的价格和屏幕尺寸:");
                int priceD = sc.nextInt();
                float screen_sizeD = sc.nextFloat();
                Desktop D = new Desktop(priceD, screen_sizeD);
                D.rankingP();
                D.rankingS();
            }
        }
    }
}
