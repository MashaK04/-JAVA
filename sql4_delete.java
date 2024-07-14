import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class sql4_delete {
    public static Connection conn;
    public static Statement statmt;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'type' varchar(100) NOT NULL);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB() throws SQLException
    {
        statmt.execute("INSERT INTO 'types' ('type') VALUES ('Абиссинская кошка'); ");
        statmt.execute("INSERT INTO 'types' ('type') VALUES ('Австралийский мист'); ");
        statmt.execute("INSERT INTO 'types' ('type') VALUES ('Американская жесткошерстная'); ");
        System.out.println("Таблица заполнена");
    }



    //новое задание
    // --------Удаление типа--------
    public static void deleteType(int id) throws SQLException {
        statmt = conn.createStatement();
        String SQL = "DELETE FROM 'types' WHERE id = " + id + ";";
        statmt.executeUpdate(SQL);
    }

    public static void updateType(int id, String newType) throws SQLException {
        statmt.execute("UPDATE 'types' SET type = '" + newType + "' WHERE id = " + id);
        System.out.println("Тип с id " + id + " изменен на '" + newType + "'");
    }



    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        System.out.println("Соединения закрыты");
    }

}