import java.sql.*;

public class Connect_to_Sql {
	String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	String URL_localhost = "jdbc:mysql://localhost:3306/test20?serverTimezone=UTC";
	String PassWord = "zyq68461415";
	String User = "root";
	ResultSet rs;
	Connection conn;
	Statement stmt;
	public Connect_to_Sql() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_Driver);
		conn = DriverManager.getConnection(URL_localhost, User, PassWord);
		if (conn != null) {
			System.out.println("���ӳɹ�");
		}
	}
	public void ShowAllTable() throws SQLException {
		while (rs.next()) {
			String sid = rs.getString("sid");
			String name = rs.getString("school_name");
			int setupDate = rs.getInt("set_up_date");
			System.out.println("-----------------------");
			System.out.println("ѧУ����:" + sid);
			System.out.println("ѧУ����:" + name);
			System.out.println("��У���:" + setupDate);
		}
	}

	public void Close_recent_sqlLanguage() throws SQLException {
		rs.close();
		stmt.close();
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
	
		
}
