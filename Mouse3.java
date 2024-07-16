import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
public class Mouse3 extends JFrame {

    static JFrame frame = new JFrame();
    static JLayeredPane panel = new JLayeredPane();

    static public void add(MouseEvent e) {
        if (e.getButton() == 1) {
            JLabel label = new JLabel("X:" + e.getX() + " Y:" + e.getY());
            label.setBounds(e.getX(), e.getY(), 100, 20);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    delete(e);
                }
            });
            panel.add(label);
        }
    }
    public static void delete(MouseEvent e) {
        if (e.getButton()==2){
            panel.remove((JLabel) e.getSource());
            panel.repaint();
        }
    }

    public static void changeCursor(MouseEvent e){
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public static void defaultCursor(MouseEvent e){
        panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Удаление мышкой");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 400, height = 400;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        panel.setFocusable(true);
        frame.add(panel);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                add(e);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                changeCursor(e);
            }
            public void mouseExited(MouseEvent e) {
                defaultCursor(e);
            }
        });
        frame.setVisible(true);
    }

}