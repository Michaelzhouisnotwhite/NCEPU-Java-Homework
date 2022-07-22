import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * @author : Michael
 * @time: 2020/10/24 1:00
 */
public class Login {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] signIn = signIn();

        JFrame jFrame = new JFrame("登录窗口");
        jFrame.setSize(300, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        JPanel panel1 = new JPanel();

        jFrame.setContentPane(placeComponents(panel1, signIn));
        jFrame.setVisible(true);
    }

    private static String[] signIn() { //注册
        String username, password;
        System.out.println("----注册用户名和密码----");
        String[] signIn = new String[2];
        while (true) {

            System.out.println("请填写用户名:");
            username = sc.next();
            if (username == null || username.length() <= 0) {
                System.out.println("用户名不能为空");
            }
            else
                break;
        }
        while (true) {
            System.out.println("请填写密码:");
            password = sc.next();
            if (password == null || password.length() <= 0) {
                System.out.println("密码不能为空");
            }
            else
                break;
        }
        signIn[0] = username;
        signIn[1] = password;
        return signIn;
    }

    private static JPanel placeComponents(JPanel panel, String[] signIn) {
        panel.setLayout(null);

        // 用户名label
        JLabel userLabel = new JLabel("用户名:");
        userLabel.setFont(new Font("黑体", Font.BOLD, 18));
        userLabel.setBounds(15,20,80,25);
        panel.add(userLabel);

        // 用户名输入框
        JTextField userText = new JTextField(15);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 密码label
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(new Font("黑体", Font.BOLD, 18));
        passwordLabel.setBounds(15,50,80,25);
        panel.add(passwordLabel);

        // 密码输入框
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBounds(100,50,165,25);
        panel.add(passwordField);

        // 登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(35, 90, 80, 35);
        panel.add(loginButton);
        loginButton.setActionCommand("BTN_EVENT_LOGIN");

        // 重置按钮
        JButton resetButton = new JButton("重置");
        resetButton.setBounds(170, 90, 80, 35);
        panel.add(resetButton);
        resetButton.setActionCommand("BTN_EVENT_RESET");

        JLabel Label = new JLabel();
        Label.setBounds(10, 130, 100, 30);
        panel.add(Label);

        // 创建监听动作
        ActionListener listener = e -> {
            String command = e.getActionCommand();

            // 按下登录判断条件
            if (command.equals("BTN_EVENT_LOGIN")) {

                // 和注册的东西比较
                boolean ifU = userText.getText().equals(signIn[0]);
                boolean ifP = String.valueOf(passwordField.getPassword()).equals(signIn[1]);
                System.out.println("user name:" + ifU);
                System.out.println("password:" + ifP);

                if (returnCompare(ifP, ifU)) {
                    Label.setText("登录成功！");
                }
                else {
                    Label.setText("信息错误！");
                }
            }

            // 按下重置按钮
            else if (command.equals("BTN_EVENT_RESET")) {
                reset(userText, passwordField);
                System.out.println("-----Reset!-----");
            }
        };

        loginButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        return panel;

    }
    private  static void reset(JTextField userText, JPasswordField password) {  // 重置按钮动作
        userText.setText("");
        password.setText("");
    }

    private static boolean returnCompare(boolean ifP, boolean ifU) {  // 比较两个的布尔值
        return ifP && ifU;
    }
}
