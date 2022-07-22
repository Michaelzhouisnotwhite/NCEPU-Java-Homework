package Note02.Demo02;

/**
 * @author Michael
 * @version 2020/12/3 21:22
 */
public class Demo02Test {
    public static void main(String[] args) {
        TicketsSelling ts = new TicketsSelling();
        System.out.println(new Thread(ts).getPriority());
        System.out.println(new Thread(ts).getPriority());
        System.out.println(new Thread(ts).getPriority());
    }
}
