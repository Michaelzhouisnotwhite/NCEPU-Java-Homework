import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author : Michael
 * @version  : 2020/10/24 18:59
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("四则运算器");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        frame.setContentPane(feedInfo(panel));
        frame.setVisible(true);
    }
    private static int flag;
    private static JPanel feedInfo(JPanel panel) {
        panel.setLayout(null);
        JTextField x1 = new JTextField(20);
        x1.setFont(new Font("", Font.PLAIN,24));
        x1.setBounds(60, 100, 60, 60);
        panel.add(x1);

        JTextField x2 = new JTextField(20);
        x2.setFont(new Font("", Font.PLAIN,24));
        x2.setBounds(200, 100, 60, 60);
        panel.add(x2);

        JTextField result = new JTextField(20);
        result.setFont(new Font("", Font.PLAIN,24));
        result.setBounds(322, 100, 60, 60);
        panel.add(result);

        JButton equal_sign = new JButton("=");
        equal_sign.setFont(new Font("", Font.PLAIN, 26));
        equal_sign.setBounds(260, 115, 60, 30);
        panel.add(equal_sign);
        equal_sign.setActionCommand("GET_RESULTS");

        JRadioButton add = new JRadioButton("+");
        JRadioButton minus = new JRadioButton("-");
        JRadioButton multiply = new JRadioButton("*");
        JRadioButton divide = new JRadioButton("/");

        setFont(add);
        setFont(minus);
        setFont(multiply);
        setFont(divide);

        operatorBounds(add, 40);
        operatorBounds(minus, 100);
        operatorBounds(multiply, 160);
        operatorBounds(divide, 220);

        ButtonGroup operator = new ButtonGroup();
        operator.add(add);
        operator.add(minus);
        operator.add(multiply);
        operator.add(divide);

        panel.add(add);
        panel.add(minus);
        panel.add(multiply);
        panel.add(divide);

        ActionListener listener = e -> {
            String command = e.getActionCommand();
            if (command.equals("GET_RESULTS")) {
                int a = 0, b = 0;

                try {
                    a = Integer.parseInt(x1.getText());
                    b = Integer.parseInt(x2.getText());
                }catch (Exception exception) {
                    System.out.println("输入的值不是数字！");
                }

                System.out.println("x_1:" + a);
                System.out.println("y_2:" + b);
                // +
                if (flag == 1) {
                    int c = a + b;
                    result.setText(String.valueOf(c));
                }
                // -
                else if (flag == 2) {
                    int c = a - b;
                    result.setText(String.valueOf(c));
                }
                // *
                else if (flag == 3) {
                    int c = a * b;
                    result.setText(String.valueOf(c));
                }
                // /
                else if (flag == 4) {
                    double c = 0;
                    try {
                        c = (double) a / b;
                    }catch (Exception ignored) {
                        System.out.println("数学错误");
                    }
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    nf.setMaximumFractionDigits(2);
                    nf.setRoundingMode(RoundingMode.HALF_UP);
                    nf.setGroupingUsed(false);
                    result.setText(nf.format(c));
                }
            }
        };

        add.addChangeListener (e -> {
            JRadioButton b = (JRadioButton) e.getSource();
            if (b.isSelected()) {
                flag = 1;
                System.out.println("do add");
            }
        });

        minus.addChangeListener (e -> {
            JRadioButton b = (JRadioButton) e.getSource();
            if (b.isSelected()) {
                flag = 2;
                System.out.println("do minus");
            }
        });

        multiply.addChangeListener(e -> {
            JRadioButton b = (JRadioButton) e.getSource();
            if (b.isSelected()) {
                flag = 3;
                System.out.println("do multiply");
            }
        });

        divide.addChangeListener(e -> {
            JRadioButton b = (JRadioButton) e.getSource();
            if (b.isSelected()) {
                flag = 4;
                System.out.println("do divide");
            }
        });

        equal_sign.addActionListener(listener);
        return panel;
    }
    private static void setFont(JRadioButton B) {
        B.setFont(new Font("", Font.PLAIN, 30));
    }

    private static void operatorBounds(JRadioButton radioButton, int y) {
        int x = 135, w = 60, h = 60;
        radioButton.setBounds(x, y, w, h);
    }

}
