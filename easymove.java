import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class easymove extends JPanel implements ActionListener, KeyListener {
    private int x = 100;
    private int y = 100;
    private final int objectSize = 50;
    private Timer timer;

    public easymove() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        timer = new Timer(100, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, objectSize, objectSize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            if (x - 50 >= 0) {
                x -= 50;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if (x + 50 + objectSize <= getWidth()) {
                x += 50;
            }
        } else if (key == KeyEvent.VK_UP) {
            if (y - 50 >= 0) {
                y -= 50;
            }
        } else if (key == KeyEvent.VK_DOWN) {
            if (y + 50 + objectSize <= getHeight()) {
                y += 50;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Перемещение");
        easymove panel = new easymove();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}