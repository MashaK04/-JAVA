import javax.swing.*;
import java.awt.*;

public class Snow extends JFrame {

    public Snow() {
        setTitle("Snowman");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Draw snowman body
        g.setColor(Color.WHITE);
        g.fillOval(100, 50, 100, 100);
        g.fillOval(75, 100, 150, 150);
        g.fillOval(50, 200, 200, 200);

    }

    public static void main(String[] args) {
        Snow snowman = new Snow();
    }
}