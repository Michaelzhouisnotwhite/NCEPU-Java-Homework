package Note01.Person;

/**
 * @author Michael
 * @version 2020/11/26 16:13
 */
public class Demo01MainThread {
    public static void main(String[] args) {
        var p1 = new Person("小强");
        p1.run();
        var p2 = new Person("小明");
        p2.run();

    }
}
