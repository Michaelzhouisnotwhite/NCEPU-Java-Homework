import java.util.Scanner;

public class Int {
    public static void main(String[] args) {
        int[] in = new int[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < in.length; i++) {
            System.out.printf("第%d个数：", i+1);
            in[i] = input.nextInt();
        }
        for (int n : in) {
            System.out.print(n + " ");
        }
    }
}
