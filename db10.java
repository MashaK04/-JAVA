import java.sql.SQLException;

public class db10 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        sql10_select.Conn();
        sql10_select.get_cat(3);
        sql10_select.get_cat_where("age > 5");
        sql10_select.get_all_cats();
    }
}
