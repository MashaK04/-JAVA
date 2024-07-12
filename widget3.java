import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class widget3 {
    public static void main(String[] args) {
        JFrame window = new JFrame("задание 3");
        window.setSize(300, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel clickCountLabel = new JLabel("Количество кликов: 0");
        clickCountLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Клик");

        int[] c_count = {0};
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c_count[0]++;
                clickCountLabel.setText("Количество кликов: " + c_count[0]);
            }
        });


        window.add(clickCountLabel);
        window.add(button, "South");


        window.setVisible(true);
    }
}