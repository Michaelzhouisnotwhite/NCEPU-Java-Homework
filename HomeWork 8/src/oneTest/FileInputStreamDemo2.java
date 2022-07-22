package oneTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Michael
 * @version 2020/11/6 21:45
 */

public class FileInputStreamDemo2 {
    public static void main(String[] args) {
        try {
            File file = new File(DefaultFigure.file);
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[(int) (file.length())];
            int length = fis.read(bytes);
            if (length == -1) {
                System.out.println("未读到数据！");
            }
            String str = new String(bytes);
            System.out.print(str);
            fis.close();
        } catch (IOException e) {
            System.out.println("文件打开失败！");
//            e.printStackTrace();
        }
    }
}
