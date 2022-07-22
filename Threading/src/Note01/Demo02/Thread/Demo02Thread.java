package Note01.Demo02.Thread;

/**
 * @author Michael
 * @version 2020/11/26 16:25
 */

/*
    线程并发执行，一个线程只能调用一次，多次调用是非法的
    java程序属于抢占式调度，哪个线程优先级高，哪个线程就优先执行
 */

/*
    主线程：main
    新线程：Thread-0, Thread-1, Thread-2
 */
public class Demo02Thread {
    public static void main(String[] args) {
        // 创建Thread的子类对象
        var mt = new MyThread();
        // 调用start方法开启新线程，执行run方法
        mt.start();

//        new MyThread().start();
//        new MyThread().start();
//        new MyThread().start();

        System.out.println(Thread.currentThread().getName());
    }
}
