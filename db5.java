import java.sql.SQLException;

public class db5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        sql5_select.Conn();
        System.out.println("пункт 1:");
        sql5_select.get_type(1);
        System.out.println("пункт 2:");
        sql5_select.get_type_where("id < 15");
        System.out.println("пункт 3:");
        sql5_select.get_all_types();

        sql5_select.CloseDB();

    }
}