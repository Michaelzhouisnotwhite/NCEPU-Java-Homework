import java.util.Scanner;

public class HomeWork_5 {
    public static void main(String[] args) {
        Scanner Input=new Scanner(System.in);
        System.out.println("输入姓名");
        String name=Input.nextLine();
        System.out.println("输入年龄");
        int age=Input.nextInt();
        Input.nextLine();
        System.out.println("输入性别");
        String sex=Input.nextLine();
        System.out.println("输入成绩");
        float grade=Input.nextFloat();
        System.out.println("姓名："+name+"\n年龄："+age+"\n性别："+sex+"\n成绩："+grade);
    }

}
