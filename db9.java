import java.sql.SQLException;

public class db9 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        sql9_delete.Conn();
        sql9_delete.delete_cat(3);
        sql9_delete.delete_cat("age > 10");
        sql9_delete.update_cat(5, "name = 'Mittens', age = 3", "weight < 5");
    }

}

