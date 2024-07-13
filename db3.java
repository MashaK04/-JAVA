import java.sql.SQLException;

public class db3 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        sql3_insert_all.Conn();
        sql3_insert_all.CreateDB();
        sql3_insert_all.WriteDB();
        sql3_insert_all.CloseDB();
    }
}