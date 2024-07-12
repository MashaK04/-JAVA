import javax.swing.*;
import java.awt.*;

public class widget1 {
    public static void main(String[] args) {
        JFrame widget= new JFrame("Окно");
        widget.setSize(400, 300);
        widget.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel label = new JLabel("Моя первая надпись!");
        label.setFont(new Font("Arial", Font.ITALIC, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        widget.add(label, BorderLayout.CENTER);

        widget.setVisible(true);
    }
}