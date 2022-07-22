import java.sql.SQLException;

public class sqlSelect extends Connect_to_Sql{
	public sqlSelect() throws SQLException, ClassNotFoundException {
		stmt = super.conn.createStatement();
		String sql = "SELECT * FROM university WHERE set_up_date=1902";
		rs = stmt.executeQuery(sql);
		ShowAllTable();
		Close_recent_sqlLanguage();
	}

}
