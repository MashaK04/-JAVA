import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class widget2 {
    public static void main(String[] args) {
        JFrame window = new JFrame("задание 2");
        window.setSize(400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel("Моя первая надпись!");
        text.setFont(new Font("Arial", Font.ITALIC, 50));
        text.setHorizontalAlignment(SwingConstants.CENTER);


        JSlider s = new JSlider(JSlider.HORIZONTAL, 5, 100, 5);
        s.setMajorTickSpacing(20);
        s.setMinorTickSpacing(10);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        s.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int fontSize = s.getValue();
                text.setFont(new Font("Arial", Font.ITALIC, fontSize));
            }
        });

        window.add(text, BorderLayout.CENTER);
        window.add(s, BorderLayout.SOUTH);

        window.setVisible(true);
    }
}