import java.sql.SQLException;

/**
 * @author Michael
 * @version 2020/12/1 23:35
 */
public class sqlInsert extends Connect_to_Sql {
    public sqlInsert() throws SQLException, ClassNotFoundException {
        stmt = conn.createStatement();
        String sql = "Insert Into university (sid, school_name, set_up_date)" +
                "Values ('4', 'NCEPU', '1904')";
        stmt.execute(sql);
        String sql2 = "Select * FROM university";
        rs = stmt.executeQuery(sql2);
        ShowAllTable();
        Close_recent_sqlLanguage();
    }
}
