import java.sql.*;


public class sql5_select {
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
    public static String get_type(int id) throws SQLException {
        statmt = conn.createStatement();
        String SQL = "SELECT type FROM types WHERE 'id' = " + id + ";";
        ResultSet rs = statmt.executeQuery(SQL);
        if (rs.next()) {
            return rs.getString("type");
        }
        return null;
    }

    public static void get_type_where(String where) throws SQLException {
        String SQL = "SELECT type FROM types WHERE " + where + ";";
        ResultSet rs = statmt.executeQuery(SQL);
        while (rs.next()) {
            System.out.println(rs.getString("type"));
        }
    }

    public static void get_all_types() throws SQLException {
        String SQL = "SELECT type FROM types;";
        ResultSet rs = statmt.executeQuery(SQL);
        while (rs.next()) {
            System.out.println(rs.getString("type"));
        }
    }



    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        System.out.println("Соединения закрыты");
    }

}