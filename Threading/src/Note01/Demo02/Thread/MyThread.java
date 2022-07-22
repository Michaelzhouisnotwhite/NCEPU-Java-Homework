package Note01.Demo02.Thread;

/**
 * @author Michael
 * @version 2020/11/26 16:27
 */
public class MyThread extends Thread {
    @Override //重写run方法
    public void run() {
        //获取线程名称
        // String name = getName();
        // System.out.println(name);

//        Thread t = Thread.currentThread();
//        System.out.println(t); // Thread[Thread-0,5,main]

        System.out.println(Thread.currentThread().getName());
    }
}
