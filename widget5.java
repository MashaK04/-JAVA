import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class widget5 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Задание 5 - Выбор цвета");
        window.setSize(300, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] colors = {"Красный", "Зеленый", "Синий"};

        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        JButton button = new JButton("Ответить");
        JLabel label = new JLabel("Ответ: ");
        JCheckBox neww = new JCheckBox("Свой цвет");

        JTextField text = new JTextField(10);
        text.setEnabled(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor;
                if (neww.isSelected()) {
                    selectedColor = text.getText();
                } else {
                    selectedColor = (String) colorComboBox.getSelectedItem();
                }
                label.setText("Ответ: " + selectedColor);
            }
        });

        neww.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setEnabled(neww.isSelected());
            }
        });

        JPanel panel = new JPanel();
        panel.add(colorComboBox);
        panel.add(neww);
        panel.add(text);
        panel.add(button);

        window.add(panel);
        window.add(label, "South");

        window.setVisible(true);
    }
}