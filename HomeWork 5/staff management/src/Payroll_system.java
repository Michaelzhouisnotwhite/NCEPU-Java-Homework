/**
 * @Author: Michael
 * @Date: 2020/10/10 19:17
 */

class Employee {
    /*
    出生月份
    姓名
     */
    String name;
    int birth_month, total_salary=0;
    int Tmonth;
    int awardMoney=100;
    public Employee(String name, int birth_month) {
        setName(name);
        setBirth_month(birth_month);
    }


    public void setBirth_month(int birth_month) {
        this.birth_month = birth_month;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 如果该月员工过生日，则公司会额外奖励100元。
    public void getSalary(int Tmonth) {
        this.Tmonth = Tmonth;
        if (Tmonth == this.birth_month) {
            this.total_salary += awardMoney;
        }
    }
    public void Show() {
        boolean flag = this.birth_month==this.Tmonth;
        System.out.println("name:" + name);
        System.out.println("this month:" + Tmonth);
        System.out.println("Is birth month? :" + flag);
        if (flag){
            System.out.printf("total salary:%d (%d + %d)\n",
                    total_salary, total_salary-awardMoney, awardMoney);
        }
        else {
            System.out.println("total salary:" + total_salary);
        }

    }
}

// 拿固定工资的员工
class SalariedEmployee extends Employee {
    int fixedSalary;
    public SalariedEmployee(String name, int birth_month, int fixedSalary) {
        super(name, birth_month);
        setFixedSalary(fixedSalary);
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    // 输入固定工资:月薪
    @Override
    public void getSalary(int Tmonth) {
        super.getSalary(Tmonth);
        super.total_salary += fixedSalary;
    }
}


// 每月工作超出160小时的部分按照1.5倍工资发放。
class HourlyEmployee extends Employee {
    int hourSalary, workingHours;
    public HourlyEmployee(String name, int birth_month, int hourSalary, int workingHours) {
        super(name, birth_month);
        setHourSalary(hourSalary);
        setWorkingHours(workingHours);
    }

    // 每小时工资
    public void setHourSalary(int hourSalary) {
        this.hourSalary = hourSalary;
    }

    // 小时数
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    // 工作小时数,月薪
    @Override
    public void getSalary(int Tmonth) {
        super.getSalary(Tmonth);
        if (workingHours > 160) {
            super.total_salary = (int) ((workingHours - 160) * 1.5 * hourSalary + 160 * workingHours);
        }
    }
}