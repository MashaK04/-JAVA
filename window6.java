import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class window6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Задание 6 - Выбор времени года");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание радио-кнопок для выбора времени года
        JRadioButton spring = new JRadioButton("Весна");
        JRadioButton summer = new JRadioButton("Лето");
        JRadioButton autumn = new JRadioButton("Осень");
        JRadioButton winter = new JRadioButton("Зима");

        // Объединение радио-кнопок в одну группу
        ButtonGroup seasonGroup = new ButtonGroup();
        seasonGroup.add(spring);
        seasonGroup.add(summer);
        seasonGroup.add(autumn);
        seasonGroup.add(winter);

        JButton button = new JButton("Ответить");

        JLabel label = new JLabel("Ответ: ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSeason = "";
                if (spring.isSelected()) {
                    selectedSeason = "Весна";
                } else if (summer.isSelected()) {
                    selectedSeason = "Лето";
                } else if (autumn.isSelected()) {
                    selectedSeason = "Осень";
                } else if (winter.isSelected()) {
                    selectedSeason = "Зима";
                }
                label.setText("Ответ: " + selectedSeason);
            }
        });

        JPanel panel = new JPanel();
        panel.add(spring);
        panel.add(summer);
        panel.add(autumn);
        panel.add(winter);
        panel.add(button);

        frame.add(panel);
        frame.add(label, "South");

        frame.setVisible(true);
    }
}