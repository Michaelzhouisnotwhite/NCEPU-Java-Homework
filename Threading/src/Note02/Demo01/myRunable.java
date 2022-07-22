package Note02.Demo01;

/**
 * @author Michael
 * @version 2020/12/3 21:06
 */
public class myRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("myRunable线程：" + i);
        }
    }
}
