import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame {
    public Window() {
        setTitle("Начальное окно");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(null, "Маша", "Информация", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window();
            }
        });
    }
}