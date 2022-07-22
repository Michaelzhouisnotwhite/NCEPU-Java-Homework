import javax.swing.*;
import java.io.*;

/**
 * @author Michael
 * @version 2020/11/26 18:14
 */
public class Menu extends AddressBook{
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem open, save;
    FileReader fileReader;
    JFileChooser fileChooser;
    File file;
    BufferedReader bufferedReader;

    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    Menu() {
        JMenu();
        Actions();
    }

    private void JMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("文件");
        open = new JMenuItem("导入");
        save = new JMenuItem("导出");

        open.setActionCommand("OPEN");
        save.setActionCommand("SAVE");

        menu.add(open);
        menu.add(save);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void Actions() {
        open.addActionListener(new Listener02(this));
        save.addActionListener(new Listener02(this));
    }
}
