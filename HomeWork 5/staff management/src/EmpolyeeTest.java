import java.util.Calendar;
import java.util.Scanner;

/**
 * @Author: Michael
 * @Date: 2020/10/11 0:56
 */

public class EmpolyeeTest {
    public static void main(String[] args) {

        int fixedSalary = 10000; // 固定工资：10000
        int hourSalary = 10; // 每小时工资：10
        String[] name = new String[4];
        int[] birthMonth = new int[4];

        Calendar cal = Calendar.getInstance(); // 获取当前月份
        int Tmonth = cal.get(Calendar.MONTH) + 1;
        System.out.println("当前月份是：" + Tmonth);

        Employee[] staff1 = new SalariedEmployee[2];
        Employee[] staff2 = new HourlyEmployee[2];
        Scanner sc = new Scanner(System.in);

        for (int i = 0, j = 0, k = 0; i < 4; i++) {
            int working_hours;
            System.out.printf("请输入第 %d 个员工的姓名：\n", i + 1);
            name[i] = sc.next();
            System.out.println("请输入 他/她 的生日月份");
            birthMonth[i] = sc.nextInt();
            System.out.println("请输入 他/她 的工资结算方法：\n" +
                    "1、月固定工资(每月10000)\n" +
                    "2、按小时结算(每小时10)");
            int flag = sc.nextInt();

            // 拿固定工资
            if (flag == 1) {
                staff1[j] = new SalariedEmployee(name[i], birthMonth[i], fixedSalary);
                staff1[j].getSalary(Tmonth);
                j++;
            }

            // 按小时结工资
            else if (flag == 2){
                System.out.printf("请输入 “%s” 当月的工作时间: \n", name[i]);
                working_hours = sc.nextInt();
                staff2[k] = new HourlyEmployee(name[i], birthMonth[i], hourSalary, working_hours);
                staff2[k].getSalary(Tmonth);
                k++;
            }
        }
        System.out.println("================");
        System.out.println("Output:");
        System.out.println("================");
        // OutPut
        for (int i = 0; i < 2; i++) {
            staff1[i].Show();
            System.out.println("---------");
            staff2[i].Show();
            System.out.println("---------");
        }
        /*
            D:\Java\Jdk\bin\java.exe "-javaagent:D:\IntelliJ IDEA 2020.1\lib\idea_rt.jar=5859:D:\IntelliJ IDEA 2020.1\bin" -Dfile.encoding=UTF-8 -classpath "D:\User_Michael's\JAVA projects\HomeWork 5\staff management\out\production\staff management" EmpolyeeTest
            当前月份是：10
            请输入第 1 个员工的姓名：
            Michael
            请输入 他/她 的生日月份
            12
            请输入 他/她 的工资结算方法：
            1、月固定工资(每月10000)
            2、按小时结算(每小时10)
            1
            请输入第 2 个员工的姓名：
            Jason
            请输入 他/她 的生日月份
            12
            请输入 他/她 的工资结算方法：
            1、月固定工资(每月10000)
            2、按小时结算(每小时10)
            2
            请输入 “Jason” 当月的工作时间:
            2400
            请输入第 3 个员工的姓名：
            周袁卿
            请输入 他/她 的生日月份
            10
            请输入 他/她 的工资结算方法：
            1、月固定工资(每月10000)
            2、按小时结算(每小时10)
            1
            请输入第 4 个员工的姓名：
            闫琦
            请输入 他/她 的生日月份
            10
            请输入 他/她 的工资结算方法：
            1、月固定工资(每月10000)
            2、按小时结算(每小时10)
            2
            请输入 “闫琦” 当月的工作时间:
            1400
            ================
            Output:
            ================
            name:Michael
            this month:10
            Is birth month? :false
            total salary:10000
            ---------
            name:Jason
            this month:10
            Is birth month? :false
            total salary:417600
            ---------
            name:周袁卿
            this month:10
            Is birth month? :true
            total salary:10100 (10000 + 100)
            ---------
            name:闫琦
            this month:10
            Is birth month? :true
            total salary:242600 (242500 + 100)
            ---------

            Process finished with exit code 0

         */
    }
}
