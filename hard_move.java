import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class hard_move extends JPanel implements ActionListener, KeyListener {
    private int x = 100;
    private int y = 100;
    private final int objectSize = 50;
    private Timer timer;
    private int dx = 0;
    private int dy = 0;

    public hard_move() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        timer = new Timer(10, this);
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
        x += dx;
        y += dy;

        if (x > getWidth()) {
            x = -objectSize;
        } else if (x < -objectSize) {
            x = getWidth();
        }

        if (y > getHeight()) {
            y = -objectSize;
        } else if (y < -objectSize) {
            y = getHeight();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        } else if (key == KeyEvent.VK_UP) {
            dy = -1;
        } else if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Перемешение намбел ту");
        hard_move panel = new hard_move();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}