import java.sql.SQLException;

public class db1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        sql1_create.Conn();
        sql1_create.CreateDB();
        sql1_create.CloseDB();
    }
}