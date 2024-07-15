import java.sql.SQLException;

public class db7 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        sql7_insert2.Conn();
        sql7_insert2.insert_cat("Кот1", "Персидская", 1, 4.2);
        sql7_insert2.insert_cat("Кот2", "Сиамская", 3, 5.1);
        sql7_insert2.insert_cat("Кот3", "Британская", 7, 6.5);
        sql7_insert2.CloseDB();
    }
}