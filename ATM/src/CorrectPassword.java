import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorrectPassword implements ActionListener {
	JFrame frame;
	JPanel panel1, panel2, panel3,p1,p2,p3;
	JLabel prompt, welcome, correct, correctDouble;
	JPasswordField oldpassword, newpassword, newpasswordDouble;
	JButton finish, clear, exit;
	static String Id;

	CorrectPassword(String Id) {
		this.Id = Id;
		frame = new JFrame("修改密码");
		frame.setSize(500, 600);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);

		panel1 = new JPanel();
		welcome = new JLabel("~欢迎使用此功能~");
		panel1.add(welcome);
		frame.add(BorderLayout.NORTH,panel1);

		
		panel2=new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		p1=new JPanel();
		prompt = new JLabel("请输入当前密码");
		oldpassword = new JPasswordField(22);
		p1.add(prompt);
		p1.add(oldpassword);
		panel2.add(p1);
		
		p2=new JPanel();
		correct = new JLabel("请输入修改后的密码");
		correctDouble = new JLabel("请再次输入修改后的密码");
		newpassword = new JPasswordField(22);
		newpasswordDouble = new JPasswordField(22);
		p2.add(correct);
		p2.add(newpassword);
		panel2.add(p2);
		
		p3=new JPanel();
		p3.add(correctDouble);
		p3.add(newpasswordDouble);
		panel2.add(p3);
		frame.add(BorderLayout.CENTER,panel2);

		panel3 = new JPanel();
		finish = new JButton("确认修改");
		clear = new JButton("清除信息");
		exit = new JButton("退出");
		panel3.add(finish);
		panel3.add(clear);
		panel3.add(exit);
		frame.add(BorderLayout.SOUTH,panel3);
		finish.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    String oldpwd=null;
		String name=null;
		String cilentOldpwd=new String(oldpassword.getPassword());
		String cilentNewpwdDouble=new String(newpasswordDouble.getPassword());
		String cilentNewpwd=new String(newpassword.getPassword());
		ATMDriver ATMDriver = new ATMDriver();
		try {
			java.sql.Statement st=ATMDriver.conn.createStatement();
			String sql="select password from logingui where number='"+Id+"'";
			ResultSet rs=st.executeQuery(sql);
				while (rs.next()) {
					oldpwd =rs.getString("password");
				}
				
		}catch (SQLException t) {
			t.printStackTrace();
		}
		
		
		
		
		
		if(e.getSource()==finish) {
			
			if(cilentNewpwd.equals(cilentNewpwdDouble)){
				if(oldpwd.equals(cilentOldpwd)) {
					if(cilentNewpwd.length()!=6) {
					JOptionPane.showMessageDialog(finish, "新密码长度不是六位，修改失败");
				    }else {
					    try {
						java.sql.Statement st=ATMDriver.conn.createStatement();
						String sql="update logingui set password= '"+cilentNewpwd+"' where number='"+Id+"' ";
						st.executeUpdate(sql);
						JOptionPane.showMessageDialog(finish, "修改成功，请重新登录");
						LoginGUI loginGui=new LoginGUI ();
						frame.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  
				}
			}else {
				JOptionPane.showMessageDialog(finish, "旧密码错误，修改失败");
			  }
			}else {
				  JOptionPane.showMessageDialog(finish, "两次设置的新密码不同，修改失败");
			}
		}
		else if (e.getSource()==clear) {
			oldpassword.setText(null);
			newpassword.setText(null);
			newpasswordDouble.setText(null);
		}
		else if (e.getSource()==exit) {
			ATMInterface atm = new ATMInterface(Id);
			frame.dispose();
		}	
      }
   }
