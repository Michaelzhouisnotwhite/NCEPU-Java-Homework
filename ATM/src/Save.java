import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Timestamp;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Save implements ActionListener {
	JFrame frame;
	JButton b1, b2, b3, b4, b5, exit;
	JPanel p1,p2,p3,p4,p5,p6;
	static String Id = "";

	Save(String Id) {
		this.Id = Id;
		frame = new JFrame("存钱");
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3,2));
		frame.setLocationRelativeTo(null);

		p1=new JPanel ();
		b1 = new JButton("100");
		frame.add(p1);
		p1.add(b1);
		b1.addActionListener(this);

		p2=new JPanel ();
		b2 = new JButton("200");
		frame.add(p2);
		p2.add(b2);
		b2.addActionListener(this);

		p3=new JPanel ();
		b3 = new JButton("300");
		frame.add(p3);
		p3.add(b3);
		b3.addActionListener(this);

		p4=new JPanel ();
		b4 = new JButton("500");
		frame.add(p4);
		p4.add(b4);
		b4.addActionListener(this);

		p5=new JPanel ();
		b5 = new JButton("1000");
		frame.add(p5);
		p5.add(b5);
		b5.addActionListener(this);

		p6=new JPanel ();
		exit = new JButton("退出");
		frame.add(p6);
		p6.add(exit);
		exit.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ATMDriver ATMSave=new ATMDriver();
		PreparedStatement pstmt=null;
		String s1=null;
		 Date Dates2;
		double accountDouble = 0;
	    double  accountNow;
		String sql="select account from tradingaccording where Sname='"+Id+"'";
		try {
			Statement st=ATMSave.conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
				while (rs.next()) {
					 accountDouble=rs.getDouble("account");
				}
				}catch(SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		try {
//			(Sname,Date,tradingaccord,account)
			pstmt=ATMSave.conn.prepareStatement("insert into tradingaccording values(?,?,?,?) ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (e.getSource()==b1) {
			try {
				accountNow=accountDouble+100;
				pstmt.setString(1,Id);
				Date date=new Date();
				Timestamp timeStamp=new Timestamp(date.getTime());
				pstmt.setTimestamp(2,timeStamp);
				s1="存入100元";
				pstmt.setString(3, s1);
				pstmt.setDouble(4, accountNow);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(b1, "存钱成功");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
		else if(e.getSource()==b2) {
			try {
				accountNow=accountDouble+200;
				pstmt.setString(1,Id);
				Date date=new Date();
				Timestamp timeStamp=new Timestamp(date.getTime());
				pstmt.setTimestamp(2,timeStamp);
				s1="存入200元";
				pstmt.setString(3, s1);
				pstmt.setDouble(4, accountNow);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(b2, "存钱成功");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource()==b3) {
			try {
				accountNow=accountDouble+300;
				pstmt.setString(1,Id);
				Date date=new Date();
				Timestamp timeStamp=new Timestamp(date.getTime());
				pstmt.setTimestamp(2,timeStamp);
				s1="存入300元";
				pstmt.setString(3, s1);
				pstmt.setDouble(4, accountNow);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(b3, "存钱成功");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource()==b4) {
			try {
				accountNow=accountDouble+500;
				pstmt.setString(1,Id);
				Date date=new Date();
				Timestamp timeStamp=new Timestamp(date.getTime());
				pstmt.setTimestamp(2,timeStamp);
				s1="存入500元";
				pstmt.setString(3, s1);
				pstmt.setDouble(4, accountNow);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(b4, "存钱成功");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
		else if(e.getSource()==b5) {
			try {
				accountNow=accountDouble+1000;
				pstmt.setString(1,Id);
				Date date=new Date();
				Timestamp timeStamp=new Timestamp(date.getTime());
				pstmt.setTimestamp(2,timeStamp);
				s1="存入500元";
				pstmt.setString(3, s1);
				pstmt.setDouble(4, accountNow);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(b5, "存钱成功");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource()==exit) {
			ATMInterface atm = new ATMInterface(Id);
			frame.dispose();
		}
		}
	}
