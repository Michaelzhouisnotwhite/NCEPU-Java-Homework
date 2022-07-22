package oneTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Michael
 * @version 2020/11/6 21:15
 */

public class FileInputStreamDemo1 {
    public static void main(String[] args){
        try {
            File file = new File(DefaultFigure.file);
            FileInputStream fis = new FileInputStream(file);
            for (int i=0; i < file.length(); i++) {
                System.out.print((char) (fis.read()));
            }
            fis.close();
        }catch (FileNotFoundException e) {
            System.out.println("文件打开失败！");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
