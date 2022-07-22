package Note02.Demo01;

/**
 * @author Michael
 * @version 2020/12/3 21:10
 */
public class Demo01Test {
    public static void main(String[] args) {
        myRunable mR = new myRunable();
        Thread t = new Thread(mR);
        t.start();
        for (int i=0; i < 10; i++) {
            System.out.println("主线程：" + i);
        }
    }
}
