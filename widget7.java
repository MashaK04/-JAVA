import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class widget7 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Задание 7 - JTextArea");
        window.setSize(400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField input = new JTextField(20);

        JTextArea text1 = new JTextArea(10, 30);
        text1.setEditable(false);

        JScrollPane s = new JScrollPane(text1);
        JButton button = new JButton("Записать");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = input.getText();
                text1.append(text + "\n");
                input.setText("");
            }
        });

        JPanel panel = new JPanel();
        panel.add(input);
        panel.add(button);

        window.add(panel, "North");
        window.add(s, "Center");

        window.setVisible(true);
    }
}