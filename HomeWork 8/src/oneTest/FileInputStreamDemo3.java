package oneTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Michael
 * @version 2020/11/6 22:14
 */
public class FileInputStreamDemo3 {
    public static void main(String[] args) {
        try {
            File file = new File(DefaultFigure.file);
            FileInputStream fis = new FileInputStream(file);
            int n = 10, count;
            byte[] bytes = new byte[n];
            while ((count = fis.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, count));
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件打开失败！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
