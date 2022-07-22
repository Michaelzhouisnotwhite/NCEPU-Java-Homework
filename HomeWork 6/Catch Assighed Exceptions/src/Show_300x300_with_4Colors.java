/**
 * @Time : 2020/10/17 0:45
 * @Author : Michael
 */

import javax.swing.*;
import java.awt.*;

public class Show_300x300_with_4Colors {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Give me 4 Colors!");
        // Setting the width and height of frame
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(generatePanel("red", 0, 0));
        frame.add(generatePanel("green", 100, 0));
        frame.add(generatePanel("blue", 0, 100));
        frame.add(generatePanel("yellow", 100, 100));
        frame.setVisible(true);
    }

    public static JPanel generatePanel(String color, int x, int y){
        JPanel panel = new JPanel();
        switch (color) {
            case "red" -> panel.setBackground(Color.red);
            case "green" -> panel.setBackground(Color.green);
            case "blue" -> panel.setBackground(Color.blue);
            case "yellow" -> panel.setBackground(Color.yellow);
        }
        panel.setBounds(x, y, 100, 100);
        return panel;
    }
}
