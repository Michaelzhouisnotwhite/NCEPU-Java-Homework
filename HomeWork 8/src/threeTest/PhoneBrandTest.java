package threeTest;

import java.io.*;

/**
 * @author Michael
 * @version 2020/11/7 18:07
 */

class PhoneBrand implements Serializable {
    String brand;
    int price;
    String processorType;
    void setPhoneBrand(String brand, int price, String processorType) {
        this.brand = brand;
        this.price = price;
        this.processorType = processorType;
    }
}

public class PhoneBrandTest{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var phoneBrand_1 = new PhoneBrand[3];
        for (int i=0; i < phoneBrand_1.length; i++) {
            phoneBrand_1[i] = new PhoneBrand();
        }
        phoneBrand_1[0].setPhoneBrand("iPhone12", 7999, "A14");
        phoneBrand_1[1].setPhoneBrand("Mate 40", 6999, "kirin 9000");
        phoneBrand_1[2].setPhoneBrand("XiaoMi30", 4599, "SnapDragon 865");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Phone.data"));
        oos.writeObject(phoneBrand_1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Phone.data"));
        PhoneBrand[] phoneBrand_2 = (PhoneBrand[]) ois.readObject();
        ois.close();

        for (int i=0; i < phoneBrand_2.length; i++) {
            System.out.println("-------" + (i + 1) + "------");
            System.out.println("Brand: " + phoneBrand_2[i].brand);
            System.out.println("Price: " + phoneBrand_2[i].price);
            System.out.println("Processor Type: " + phoneBrand_2[i].processorType);
            System.out.println();
        }
    }
}
