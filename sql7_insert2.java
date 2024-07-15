import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class sql7_insert2 {
    public static Connection conn;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

        System.out.println("База Подключена!");
    }

    // --------Заполнение таблицы--------
    public static void insert_cat(String name, String type, int age, Double weight) throws SQLException {
        // Проверяем существует ли уже тип кошки в таблице types
        PreparedStatement typeCheckStatement = conn.prepareStatement("SELECT id FROM types WHERE type = ?");
        typeCheckStatement.setString(1, type);
        ResultSet typeResult = typeCheckStatement.executeQuery();

        int typeId;
        if (typeResult.next()) {
            // Если тип кошки уже существует, получаем его id
            typeId = typeResult.getInt("id");
        } else {
            // Если типа кошки нет, добавляем его в таблицу types и получаем его id
            PreparedStatement insertTypeStatement = conn.prepareStatement("INSERT INTO 'types' (type) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            insertTypeStatement.setString(1, type);
            insertTypeStatement.executeUpdate();
            ResultSet generatedKeys = insertTypeStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                typeId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to get type ID for the newly inserted cat type.");
            }
        }


        PreparedStatement insertCatStatement = conn.prepareStatement("INSERT INTO cats2 (name, age, weight, type_id) VALUES (?, ?, ?, ?)");
        insertCatStatement.setString(1, name);
        insertCatStatement.setInt(2, age);
        insertCatStatement.setDouble(3, weight);
        insertCatStatement.setInt(4, typeId);
        insertCatStatement.executeUpdate();
        System.out.println("Данные внесены");
    }


    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        System.out.println("Соединения закрыты");
    }

}