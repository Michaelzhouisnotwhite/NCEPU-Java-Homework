import java.util.Scanner;

class Dog {
    public static int i = 0;
    String breed;
    int age;
    Dog(String breed, int age) {
        this.breed = breed;
        this.age = age;
        i++;
    }
    int GetCount() {
        return i;
    }
}


public class DOGTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dog[] dog = new Dog[100];
        int in = 0;
        outer:while (true) {

            System.out.println("请输入狗的品种和年龄");
            String breed = input.next();
            int age = input.nextInt();
            dog[in] = new Dog(breed, age);
            int flag;
            in++;
            while (true) {
                System.out.println("是否继续，请输入1或0：");
                flag = input.nextInt();

                if (flag == 0) {
                    System.out.println("您一共创建的对象的次数是：" + dog[in - 1].GetCount());
                    /*
                    请输入狗的品种和年龄
                    柴犬
                    2
                    是否继续，请输入1或0：
                    1
                    请输入狗的品种和年龄
                    土狗
                    3
                    是否继续，请输入1或0：
                    1
                    请输入狗的品种和年龄
                    雪橇犬
                    4
                    是否继续，请输入1或0：
                    4
                    输入错误！！！
                    是否继续，请输入1或0：
                    0
                    您一共创建的对象的次数是：3

                    Process finished with exit code 0

                     */
                    break outer;

                } else if (flag != 1) {
                    System.out.println("输入错误！！！");
                }
                else
                    break;

            }

        }


    }
}
