import java.sql.SQLException;

public class db2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        sql2_insert.Conn();
        sql2_insert.CreateDB();
        sql2_insert.WriteDB();
        sql2_insert.CloseDB();
    }
}