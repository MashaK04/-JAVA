import javax.swing.*;
import java.awt.*;

public class glass extends JFrame {
    private Image grassTexture;

    public glass() {
        setTitle("Травка");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        grassTexture = new ImageIcon("glass.jpeg").getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                int height = getHeight();
                for (int y = 0; y < height; y += 50) {
                    for (int x = 0; x < width; x += 50) {
                        g.drawImage(grassTexture, x, y, 50, 50, this);
                    }
                }
            }
        };

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            glass window = new glass();
            window.setVisible(true);
        });
    }
}