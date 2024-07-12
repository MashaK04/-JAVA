import javax.swing.*;

public class window5 {
    public static void main(String[] args) {

        // Начальное окно
        int start = JOptionPane.showConfirmDialog(null, "Не добро пожаловать! Хотите зарегистрироваться?", "Регистрация", JOptionPane.YES_NO_OPTION);
        if (start == JOptionPane.NO_OPTION) {
            System.exit(0);
        }

        //логин
        String username = "";
        while (username.length() < 5 || username.contains(" ")) {
            username = JOptionPane.showInputDialog(null, "Введите логин, надо больше 5 символов, без пробелов:");
        }

        // Окно для ввода пароля
        String password = "";
        while (password.length() < 8 || password.contains(" ") || !password.matches(".*\\d.*") || !password.matches(".*[a-zA-Z].*")) {
            JPasswordField passwordField = new JPasswordField();
            int result = JOptionPane.showConfirmDialog(null, passwordField, "Введите пароль (больше 8 символов, без пробелов, минимум 1 цифра и 1 буква):", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                password = new String(passwordField.getPassword());
            } else {
                System.exit(0);
            }
        }

        // ввода пароля 2 раз
        String confirmPassword = "";
        while (!confirmPassword.equals(password)) {
            JPasswordField confirmField = new JPasswordField();
            int result = JOptionPane.showConfirmDialog(null, confirmField, "Повторите введенный вами пароль:", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                confirmPassword = new String(confirmField.getPassword());
            } else {
                System.exit(0);
            }
        }


        JOptionPane.showMessageDialog(null, "Регистрация прошла успешно!");
    }
}