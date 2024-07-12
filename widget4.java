import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class widget4 {
    public static void main(String[] args) {
        JFrame w = new JFrame("Задание 4");
        w.setSize(300, 200);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        SpinnerModel window = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner bookSpinner = new JSpinner(window);

        JButton button = new JButton("Ответить");


        JLabel answerLabel = new JLabel("Ответ: ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedBooks = (int) bookSpinner.getValue();
                answerLabel.setText("Ответ: " + selectedBooks);
            }
        });

        JPanel panel = new JPanel();
        panel.add(bookSpinner);
        panel.add(button);

        w.add(panel);
        w.add(answerLabel, "South");

        w.setVisible(true);
    }
}