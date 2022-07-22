import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.sql.*;


class Find implements ActionListener{
    public JFrame findframe;
	public JPanel fp0,fp1,fp2,p0;
	public JTextArea inqure;
	public JLabel label;
	public JButton search,exit;
	JScrollPane scrollPane;
	static String Id="";
	public Find(String Id) {
		this.Id=Id;
		findframe = new JFrame("查询");
		findframe.setSize(400,400);
		findframe.setLayout(new BorderLayout());
		
		fp0=new JPanel();
		label=new JLabel("~感谢您使用此功能！~");
		fp0.add(label);
		findframe.add(BorderLayout.NORTH,fp0);
		
		p0=new JPanel();
		findframe.add(BorderLayout.CENTER,p0);
		findframe.add(p0);
		
		fp1=new JPanel();
		inqure = new JTextArea(8,30);
		scrollPane = new JScrollPane (inqure);
		fp1.add(scrollPane);
		p0.add(fp1);
		inqure.setLineWrap(true);
		
		fp2=new JPanel();
		search=new JButton("查询");
		exit = new JButton("退出");
		fp2.add(search);
		fp2.add(exit);
		p0.add(fp2);
		findframe.setVisible(true);
		findframe.setLocationRelativeTo(null);
		findframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		search.addActionListener(this);
		exit.addActionListener(this);
	    }
	@Override

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double accountDouble = 0;
		if (e.getSource() == search) {
			ATMDriver ATMFind = new ATMDriver();
			String sql = "select account from tradingaccording where Sname='" + Id + "'";
			try {
				java.sql.Statement st = ATMFind.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					accountDouble = rs.getDouble("account");
				}

				String money = String.valueOf(accountDouble);
				inqure.setText(money);

			} catch (SQLException t) {
				t.printStackTrace();
			}
		}else if(e.getSource()==exit){
			findframe.dispose();
			ATMInterface atm = new ATMInterface(Id);
			}
		}
	}