import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class sql6_newtable {
    public static Connection conn;
    public static Statement statmt;

    public static void Conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

        System.out.println("База Подключена!");
    }

    public static void CreateDB() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE IF NOT EXISTS cats2 (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "age INT NOT NULL," +
                "weight DOUBLE NOT NULL," +
                "type_id INT NOT NULL," +
                "FOREIGN KEY (type_id) REFERENCES types(id)" +
                ")");
        System.out.println("Таблица создана или уже существует.");
    }

    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();

        System.out.println("Соединения закрыты");
    }

}


