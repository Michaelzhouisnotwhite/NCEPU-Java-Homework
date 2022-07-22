package twoTest;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author Michael
 * @version 2020/11/6 22:25
 */
class Editor extends JFrame {

    JTextArea text;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem open, save;
    FileReader fileReader;
    JFileChooser fileChooser;
    File file;
    BufferedReader bufferedReader;

    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    Editor() {
        JFrame();
        JPanel();
        Actions();
    }

    private void JFrame() {
        setTitle("文本编辑器");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        JMenu();
    }

    private void JPanel() {
        JText();
        scrollPane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 435, 415);
        add(scrollPane);
    }

    private void JText() {
        text = new JTextArea();
        text.setFont(new Font("", Font.PLAIN, 24));
        text.setLineWrap(true);
    }

    private void JMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("文件");
        open = new JMenuItem("打开");
        save = new JMenuItem("保存");

        open.setActionCommand("打开");
        save.setActionCommand("保存");

        menu.add(open);
        menu.add(save);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void Actions() {
//        ActionListener listener = new Listener(this);
        open.addActionListener(new Listener(this));
        save.addActionListener(new Listener(this));
    }

}

class Listener implements ActionListener {
    Editor editor;
    public Listener(Editor editor) {
        this.editor = editor;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "打开":
                var filter = new FileNameExtensionFilter("文本文件 *.txt", "txt");
                editor.fileChooser = new JFileChooser();
                editor.fileChooser.setFileFilter(filter);
                try {
                    editor.fileChooser.setCurrentDirectory(new File(new File("").getCanonicalPath() + "/src"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (editor.fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    editor.file = editor.fileChooser.getSelectedFile();
                    try {
                        editor.fileReader = new FileReader(editor.file);
                        editor.bufferedReader = new BufferedReader(editor.fileReader);
                        editor.text.setText(null);
                        int c;
                        while ((c=editor.bufferedReader.read()) != -1) {
                            editor.text.append(String.valueOf((char) c));
                        }
                        editor.bufferedReader.close();
                        editor.fileReader.close();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
                break;
            case "保存":
                try {
                    if (editor.file==null) {
                        editor.file = new File("src\\test.txt");
                    }
                    System.out.println("Path: " + editor.file);

                    editor.fileWriter = new FileWriter(editor.file);
                    editor.bufferedWriter = new BufferedWriter(editor.fileWriter);
                    editor.bufferedWriter.write(editor.text.getText());
                    editor.bufferedWriter.close();
                    editor.fileWriter.close();
                } catch (IOException | NullPointerException exception) {
//                    exception.printStackTrace();
                    System.out.println("保存失败！");
                }
                break;

        }
    }
}

public class BufferedReaderDemo {
    public static void main(String[] args) {
        new Editor().setVisible(true);
    }
}
