import java.sql.SQLException;

/**
 * @author Michael
 * @version 2020/12/2 0:08
 */
public class sqlUpdate extends Connect_to_Sql {
    public sqlUpdate() throws SQLException, ClassNotFoundException {
        stmt = conn.createStatement();
        String sql =
                "Update university " +
                "Set set_up_date=2020 " +
                "where sid='2'";
        stmt.execute(sql);
        String sql2 = "select * FROM university";
        rs = stmt.executeQuery(sql2);
        ShowAllTable();
        Close_recent_sqlLanguage();
    }
}
