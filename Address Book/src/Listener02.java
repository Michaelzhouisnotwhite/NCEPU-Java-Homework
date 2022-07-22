import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

/**
 * @author Michael
 * @version 2020/11/26 18:22
 */
public class Listener02 implements ActionListener {
    
    Menu m;
    public Listener02(Menu m) {
        this.m = m;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "OPEN":
                var filter = new FileNameExtensionFilter("文本文件 *.txt", "txt");
                m.fileChooser = new JFileChooser();
                m.fileChooser.setFileFilter(filter);
                try {
                    m.fileChooser.setCurrentDirectory(new File(new File("").getCanonicalPath() + "/src"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (m.fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    m.file = m.fileChooser.getSelectedFile();

                    try {
                        m.fileReader = new FileReader(m.file);
                        m.bufferedReader = new BufferedReader(m.fileReader);
                        int c;

                        System.out.println("--------内容--------");
                        while ((c = m.bufferedReader.read()) != -1) {
                            System.out.println((char) c);
                        }
                        System.out.println("Path: " + m.file);
                        m.bufferedReader.close();
                        m.fileReader.close();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            case "SAVE":
                String[] content = new String[1024];
                for (int i=0; i < Default.order; i++) {
                    content[i] += "#" + m.cont[i].name;
                    content[i] += "*" + m.cont[i].num;
                    content[i] += "*" + m.cont[i].sex;
                }
                try {
                    m.file = new File(new File("").getCanonicalFile() + "src/data.txt");
                    if (!m.file.exists()) {
                        System.out.println(m.file.createNewFile());
                    }
                    System.out.println("Path: " + m.file);
                    m.fileWriter = new FileWriter(m.file);
                    m.bufferedWriter = new BufferedWriter(m.fileWriter);

                    m.bufferedWriter.write(Arrays.toString(content));
                    m.bufferedWriter.close();
                    m.fileWriter.close();
                } catch (IOException | NullPointerException exception) {
                    exception.printStackTrace();
                    System.out.println("保存失败！");
                }

        }
    }
}
