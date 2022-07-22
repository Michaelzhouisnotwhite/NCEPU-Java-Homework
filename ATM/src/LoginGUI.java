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
		frame = new JFrame("��¼ATM");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel0 = new JPanel();
		label0 = new JLabel("ģ������ATM");
		panel0.add(label0);
		frame.add(panel0);

		panel1 = new JPanel();
		label1 = new JLabel("\t����:");
		tf = new JTextField(22);
		panel1.add(label1);
		panel1.add(tf);

		panel2 = new JPanel();
		label2 = new JLabel("\t����:");
		password = new JPasswordField(22);
		panel2.add(label2);
		panel2.add(password);

		panel3 = new JPanel();
		Loginbton = new JButton("��¼");
		panel3.add(Loginbton);
		Loginbton.addActionListener(this);

		p0 = new JPanel();
		p0.add(new JLabel("ȷ������:"));
		passwordCheck = new JTextField(22);
		p0.add(passwordCheck);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(p0);
		frame.add(panel3);

		frame.pack();// ȷ��frame��Ѵ�С
		p0.setVisible(false);// ȷ�������
		frame.setVisible(true);
		frame.setBounds(500, 500, 350, 250);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Id = tf.getText().trim();// ȥ���ַ����ҵĿո�
		PASSWORD = new String(password.getPassword());
		// ����MySQL����,�������ݿ⡣
		ATMDriver atmD = new ATMDriver();
		if (e.getSource() == Loginbton) {
			try {
				
				Statement st = atmD.conn.createStatement();//ʵ����һ��������MySQL���
				String sql = "select *from logingui where number='"+Id+"'and password='" + PASSWORD + "'";
				ResultSet rs = st.executeQuery(sql);// �õ�sql��ִ�н��
				if (rs.next()) {
					JOptionPane.showMessageDialog(Loginbton, "��½�ɹ�");// ��ʾ��Ϣ
					tf.setText("");
					password.setText("");
					ATMInterface atmInterface = new ATMInterface(Id);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(Loginbton, "������󣬵�½ʧ��");
					tf.setText("");
					password.setText("");
				}
			} catch (SQLException e3) {
				System.out.println("�����쳣");
			}
		}
	}
	
}
