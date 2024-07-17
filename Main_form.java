import javax.swing.*;

public class Main_form {
    public static void main(String[] args) {
        form mainWindow = new form();        // Создаем объект класса MainWindow

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//способ выхода из формы
        mainWindow.setLocationByPlatform(true);//устанавливаем местоположение
        mainWindow.setTitle("Регистрация на мероприятие");//заголовок формы
        mainWindow.pack();//упаковываем все на форме
        mainWindow.setVisible(true);// Отображаем созданное окно
    }
}