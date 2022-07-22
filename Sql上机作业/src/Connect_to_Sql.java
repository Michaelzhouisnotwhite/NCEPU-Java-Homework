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
			System.out.println("连接成功");
		}
	}
	public void ShowAllTable() throws SQLException {
		while (rs.next()) {
			String sid = rs.getString("sid");
			String name = rs.getString("school_name");
			int setupDate = rs.getInt("set_up_date");
			System.out.println("-----------------------");
			System.out.println("学校代号:" + sid);
			System.out.println("学校名称:" + name);
			System.out.println("建校年份:" + setupDate);
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
