package 异常类;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Time : 2020/10/17 0:08
 * @Author : Michael
 */
class ExceptionClass {
    int avg;
    public ExceptionClass(int avg) {
       setAvg(avg);
    }

    public void setAvg(int avg) { // setAvg
        this.avg = avg;
    }

    public int unPass() throws Exception {
        System.out.println("average:" + avg);
        if (avg < 60) {

            throw new Exception("异常！成绩低于60分！");
        }
        return 0;
    }
}


public class ExceptionClassTest {
    public static void main(String[] args) throws Exception {
        int[] scorePass = {90, 80, 70, 60, 50, 40};
        int[] scoreUnpass = {0, 1, 2, 4, 5, 6, 70};
        System.out.println("scorePass:" + Arrays.toString(scorePass));
        System.out.println("scoreUnpass:" + Arrays.toString(scoreUnpass));

        ExceptionClass exceptionClass1 = new ExceptionClass(getAverage(scorePass));
        exceptionClass1.unPass();

        ExceptionClass exceptionClass2 = new ExceptionClass(getAverage(scoreUnpass));
        exceptionClass2.unPass();

    }

    public static int getAverage(int[] a) {
        int avg = 0;
        for (int j : a) {
            avg += j / a.length;
        }
        return avg;
    }
}
