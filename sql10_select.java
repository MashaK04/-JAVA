import java.sql.*;


public class sql10_select {
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
    public static void get_cat(int id) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("SELECT * FROM cats2 WHERE id = ?");
        prep.setInt(1, id);
        ResultSet rs = prep.executeQuery();

        while (rs.next()) {
            System.out.println("Cat ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Weight: " + rs.getDouble("weight"));
        }
    }

    public static void get_cat_where(String where) throws SQLException {
        String query = "SELECT * FROM cats2 WHERE " + where;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("Cat ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Weight: " + rs.getDouble("weight"));
            System.out.println("---------------------");
        }
    }

    public static void get_all_cats() throws SQLException {
        String query = "SELECT * FROM cats2";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("Cat ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Weight: " + rs.getDouble("weight"));
            System.out.println("---------------------");
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