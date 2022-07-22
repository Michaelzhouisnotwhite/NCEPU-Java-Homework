import java.awt.*;
import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ATMInterface implements ActionListener {
	JFrame frame;
	JPanel p1, p2, p3, p4, p5, p6;
	Board panel1;
	JButton b1, b2, b3, b4, b5, b6;
//	JLabel imgLabel;
	static String Id = "";
	ImageIcon img ;
	
	public ATMInterface(String Id) {
		ATMInterface.Id = Id;
		frame = new JFrame("ATM功能界面");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(null);
		panel1=new Board();
		panel1.setLayout(new GridLayout(3, 2));
//		img = new ImageIcon("E:\\1.jpg");
//		imgLabel=new JLabel(img);
//		frame.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE));
//		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
//		Container cp=frame.getContentPane();
//		cp.setLayout(new BorderLayout());
//		((JPanel)cp).setOpaque(false);
		frame.add(panel1);
		
		p1 = new JPanel();
		b1 = new JButton("存钱");
		p1.add(b1);
		panel1.add(p1);
		b1.addActionListener(this);

		p2 = new JPanel();
		b2 = new JButton("取钱");
		p2.add(b2);
		panel1.add(p2);
		b2.addActionListener(this);

		p3 = new JPanel();
		b3 = new JButton("查询余额");
		p3.add(b3);
		panel1.add(p3);
		b3.addActionListener(this);

		p4 = new JPanel();
		b4 = new JButton("查询历史交易记录");
		p4.add(b4);
		panel1.add(p4);
		b4.addActionListener(this);

		p5 = new JPanel();
		b5 = new JButton("修改密码 ");
		p5.add(b5);
		panel1.add(p5);
		b5.addActionListener(this);

		p6 = new JPanel();
		b6 = new JButton("退出服务");
		p6.add(b6);
		panel1.add(p6);
		frame.pack();
		frame.setBounds(500, 500, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		b6.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ATMDriver addDriver = new ATMDriver();
		if (e.getSource() == b1) {
			Save save = new Save(Id);
		} else if (e.getSource() == b2) {
			Withdraw withdraw = new Withdraw(Id);
			frame.dispose();
		} else if (e.getSource() == b3) {
			Find find = new Find(Id);
			frame.dispose();
		} else if (e.getSource() == b4) {
			FindHistory findhistory = new FindHistory(Id);
			frame.dispose();
		} else if (e.getSource() == b5) {
			CorrectPassword correctPassword = new CorrectPassword(Id);
			frame.dispose();
		} else if (e.getSource() == b6) {
			JOptionPane.showMessageDialog(b6, "感谢您的使用，再见！");
			frame.dispose();

		}
	}

}
