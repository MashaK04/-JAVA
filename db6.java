import java.sql.SQLException;

public class db6 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        sql6_newtable.Conn();
        sql6_newtable.CreateDB() ;
        sql6_newtable.CloseDB();
    }
}
