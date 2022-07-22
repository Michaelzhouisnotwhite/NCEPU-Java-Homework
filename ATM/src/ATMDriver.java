import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ATMDriver {
	static final String URL = "jdbc:mysql://localhost:3306/atmtest?serverTimezone=UTC";
	static final String USER = "root";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String PASSWORD = "123jyq,.";
	java.sql.Statement st;
	Connection conn;

	public ATMDriver() {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			st = conn.createStatement();
			if (conn != null) {
				System.out.println("连接成功！" + conn);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败！");
		}

	}

	public Connection getCon() {
		return conn;
	}

	public java.sql.Statement getSt() {
		return st;
	}

}
