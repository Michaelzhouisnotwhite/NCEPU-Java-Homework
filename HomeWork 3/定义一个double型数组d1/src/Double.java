
import java.util.Arrays;

public class Double {
    public static void main(String[] args) {
        double[] d1 = {1, 2, 3, 4, 6, 6};
        double[] d2 = Arrays.copyOf(d1, d1.length);
        System.out.println(Arrays.toString(d1) + "\n" + Arrays.toString(d2));
    }
}
