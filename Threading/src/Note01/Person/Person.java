package Note01.Person;

/**
 * @author Michael
 * @version 2020/11/26 16:10
 */
public class Person {
    public String name;

    public void run() {
        //定义循环，执行20次
        for (int i=0; i < 20; i++) {
            System.out.println(name + "-->" + i);
        }
    }

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
