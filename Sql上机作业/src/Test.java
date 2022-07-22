import java.sql.SQLException;

/**
 * @author Michael
 * @version 2020/12/1 22:12
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("---SELECT---");
        new sqlSelect();
        System.out.println();

        System.out.println("---INSERT---");
//        new sqlInsert();
        System.out.println();

        System.out.println("---UPDATE---");
        new sqlUpdate();
        System.out.println();
    }
}
