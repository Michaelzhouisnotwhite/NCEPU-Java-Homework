import java.util.Scanner;

class student {
    long  sNum;
    String name;
    long ID;
    public void Input(long  sNum, String name, long ID) {
        this.sNum = sNum;
        this.name = name;
        this.ID = ID;
    }
    public long GetsNum() {
        return sNum;
    }
    public String GetName() {
        return name;
    }
    public long GetID() {
        return ID;
    }

}
public class StudentTest {
    public static void main(String[] args) {
        System.out.println("请输入学生的学号、姓名和身份证号:");
        Scanner Input = new Scanner(System.in);
        System.out.print("学号：");
        long sNum = Input.nextLong();
        System.out.print("姓名：");
        String name = Input.next();
        System.out.print("身份证号：");
        long ID = Input.nextLong();
        student stu = new student();
        stu.Input(sNum, name, ID);
        System.out.println("\n\n您输入的信息是：");
        System.out.println("学号：" +  stu.GetsNum());
        System.out.println("姓名：" +  stu.GetName());
        System.out.println("身份证号：" +  stu.GetID());
    }
}
