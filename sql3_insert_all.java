import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class sql3_insert_all {
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
    static String[] types = new String[]{"Абиссинская кошка",

            "Австралийский мист",

            "Американская жесткошерстная",

            "Американская короткошерстная",

            "Американский бобтейл",

            "Американский кёрл",

            "Балинезийская кошка",

            "Бенгальская кошка",

            "Бирманская кошка",

            "Бомбейская кошка",

            "Бразильская короткошёрстная",

            "Британская длинношерстная",

            "Британская короткошерстная",

            "Бурманская кошка",

            "Бурмилла кошка",

            "Гавана",

            "Гималайская кошка",

            "Девон-рекс",

            "Донской сфинкс",

            "Европейская короткошерстная",

            "Египетская мау",

            "Канадский сфинкс",

            "Кимрик",

            "Корат",

            "Корниш-рекс",

            "Курильский бобтейл",

            "Лаперм",

            "Манчкин",

            "Мейн-ку́н",

            "Меконгский бобтейл",

            "Мэнкс кошка",

            "Наполеон",

            "Немецкий рекс",

            "Нибелунг",

            "Норвежская лесная кошка",

            "Ориентальная кошка",

            "Оцикет",

            "Персидская кошка",

            "Петерболд",

            "Пиксибоб",

            "Рагамаффин",

            "Русская голубая кошка",

            "Рэгдолл",

            "Саванна",

            "Селкирк-рекс",

            "Сиамская кошка",

            "Сибирская кошка",

            "Сингапурская кошка",

            "Скоттиш-фолд",

            "Сноу-шу",

            "Сомалийская кошка",

            "Тайская кошка",

            "Тойгер",

            "Тонкинская кошка",

            "Турецкая ангорская кошка",

            "Турецкий ван",

            "Украинский левкой",

            "Чаузи",

            "Шартрез",

            "Экзотическая короткошерстная",

            "Японский бобтейл"

    };


    public static void WriteDB() throws SQLException
    {
        for (String type : types) {
            statmt.execute("INSERT INTO types (type) VALUES ('" + type + "');");
        }


        System.out.println("Таблица заполнена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        System.out.println("Соединения закрыты");
    }

}