import java.sql.SQLException;

public class db4 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            sql4_delete.Conn();
            sql4_delete.deleteType(5);
            sql4_delete.updateType(3, "новая порода");
            sql4_delete.CloseDB();

    }
}