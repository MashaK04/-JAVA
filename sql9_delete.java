import java.sql.*;


public class sql9_delete {
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

    public static void delete_cat(int id) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("DELETE FROM cats2 WHERE id = ?");
        prep.setInt(1, id);
        prep.execute();
    }

    public static void delete_cat(String where) throws SQLException {
        String query = "DELETE FROM cats2 WHERE " + where;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public static void update_cat(int id, String set, String where) throws SQLException {
        String query = "UPDATE cats2 SET " + set + " WHERE id = " + id + " AND " + where;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        System.out.println("Соединения закрыты");
    }

}