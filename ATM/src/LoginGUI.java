import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame implements ActionListener {
	private final JFrame frame;
	private JPanel panel0, panel1, panel2, panel3, p0;
	private JLabel label0, label1, label2;
	private JTextField tf, passwordCheck;
	private JPasswordField  password;
	private JButton Loginbton;
    String Id = "";
	private String PASSWORD = "";

	LoginGUI() {
		frame = new JFrame("登录ATM");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel0 = new JPanel();
		label0 = new JLabel("模拟银行ATM");
		panel0.add(label0);
		frame.add(panel0);

		panel1 = new JPanel();
		label1 = new JLabel("\t卡号:");
		tf = new JTextField(22);
		panel1.add(label1);
		panel1.add(tf);

		panel2 = new JPanel();
		label2 = new JLabel("\t密码:");
		password = new JPasswordField(22);
		panel2.add(label2);
		panel2.add(password);

		panel3 = new JPanel();
		Loginbton = new JButton("登录");
		panel3.add(Loginbton);
		Loginbton.addActionListener(this);

		p0 = new JPanel();
		p0.add(new JLabel("确认密码:"));
		passwordCheck = new JTextField(22);
		p0.add(passwordCheck);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(p0);
		frame.add(panel3);

		frame.pack();// 确定frame最佳大小
		p0.setVisible(false);// 确认密码框
		frame.setVisible(true);
		frame.setBounds(500, 500, 350, 250);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Id = tf.getText().trim();// 去掉字符左右的空格
		PASSWORD = new String(password.getPassword());
		// 加载MySQL驱动,连接数据库。
		ATMDriver atmD = new ATMDriver();
		if (e.getSource() == Loginbton) {
			try {
				
				Statement st = atmD.conn.createStatement();//实例化一个对象处理MySQL语句
				String sql = "select *from logingui where number='"+Id+"'and password='" + PASSWORD + "'";
				ResultSet rs = st.executeQuery(sql);// 得到sql的执行结果
				if (rs.next()) {
					JOptionPane.showMessageDialog(Loginbton, "登陆成功");// 显示信息
					tf.setText("");
					password.setText("");
					ATMInterface atmInterface = new ATMInterface(Id);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(Loginbton, "密码错误，登陆失败");
					tf.setText("");
					password.setText("");
				}
			} catch (SQLException e3) {
				System.out.println("发生异常");
			}
		}
	}
	
}
