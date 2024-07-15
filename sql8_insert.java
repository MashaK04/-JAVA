import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Random;

public class sql8_insert {

    public static Connection conn;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

        System.out.println("База Подключена!");
    }

    //Новое задание
    public static void add_more_cats(int n) throws SQLException {
        String[] names = {"Гарфилд",

                "Том",

                "Гудвин",

                "Рокки",

                "Ленивец",

                "Пушок",

                "Спорти",

                "Бегемот",

                "Пират",

                "Гудини",

                "Зорро",

                "Саймон",

                "Альбус",

                "Базилио",

                "Леопольд",

                "Нарцисс",

                "Атос",

                "Каспер",

                "Валлито",

                "Оксфорд",

                "Бисквит",

                "Соня",

                "Клеопатра",

                "Цунами",

                "Забияка",

                "Матильда",

                "Кнопка",

                "Масяня",

                "Царапка",

                "Серсея",

                "Ворсинка",

                "Амели",

                "Наоми",

                "Маркиза",

                "Изольда",

                "Вальс",

                "Несквик",

                "Златан",

                "Баскет",

                "Изюм",

                "Цукат",

                "Мокко",

                "Месси",

                "Кокос",

                "Адидас",

                "Бейлиз",

                "Тайгер",

                "Зефир",

                "Мохи",

                "Валенсия",

                "Баунти",

                "Свити",

                "Текила",

                "Ириска",

                "Карамель",

                "Виски",

                "Кукуруза",

                "Гренка",

                "Фасолька",

                "Льдинка",

                "Китана",

                "Офелия",

                "Дайкири",

                "Брусника",

                "Аватар",

                "Космос",

                "Призрак",

                "Изумруд",

                "Плинтус",

                "Яндекс",

                "Крисмас",

                "Метеор",

                "Оптимус",

                "Смайлик",

                "Цельсий",

                "Краска",

                "Дейзи",

                "Пенка",

                "Веста",

                "Астра",

                "Эйприл",

                "Среда",

                "Бусинка",

                "Гайка",

                "Елка",

                "Золушка",

                "Мята",

                "Радость",

                "Сиам",

                "Оскар",

                "Феликс",

                "Гарри",

                "Байрон",

                "Чарли",

                "Симба",

                "Тао",

                "Абу",

                "Ватсон",

                "Енисей",

                "Измир",

                "Кайзер",

                "Васаби",

                "Байкал",

                "Багира",

                "Айрис",

                "Диана",

                "Мими",

                "Сакура",

                "Индия",

                "Тиффани",

                "Скарлетт",

                "Пикси",

                "Лиззи",

                "Алиса",

                "Лило",

                "Ямайка",

                "Пэрис",

                "Мальта",

                "Аляска"

        };

        String[] types = {"Саванна", "Рэгдолл", "Рагамаффин", "Сомалийская кошка", "Корат"};

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            String name = names[random.nextInt(names.length)];
            String type = types[random.nextInt(types.length)];
            double weight = 2 + random.nextDouble() * 8;
            int age = 1 + random.nextInt(20);

            PreparedStatement prep = conn.prepareStatement("INSERT INTO cats2 (name, type_id, weight, age) VALUES (?, (SELECT id FROM types WHERE type = ?), ?, ?)");
            prep.setString(1, name);
            prep.setString(2, type);
            prep.setDouble(3, weight);
            prep.setInt(4, age);
            prep.execute();
        }
    }

}
