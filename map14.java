import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class map14 extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JSlider slider;

    public map14() throws HeadlessException {
        super("Что-то там с Казанью");
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(JSlider.HORIZONTAL, 0, 18, 10);
        panel.add(label);
        panel.add(slider);
    }

    public void run() {
        addGui();
        addSliderActionListener();
    }

    public void addGui() {
        add(panel);
        setSize(800, 600); // Установка размеров окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addSliderActionListener() {
        slider.addChangeListener(e -> {
            try {
                setImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void setImage() throws IOException {
        ImageIcon imageIcon = new ImageIcon(new URL("https://static-maps.yandex.ru/1.x/?ll=49.106414,55.796127&l=map&pt=49.106414,55.796127,flag&z=" + slider.getValue()));
        label.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new map14().run();
            }
        });
    }
}