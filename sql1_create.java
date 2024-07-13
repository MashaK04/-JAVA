import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sql1_create {
    public static Connection conn;
    public static Statement statmt;

    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

        System.out.println("База Подключена!");
    }


    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'type' varchar(100) NOT NULL);");

        System.out.println("Таблица создана или уже существует.");
    }



    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();

        System.out.println("Соединения закрыты");
    }

}