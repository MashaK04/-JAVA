import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class map12 extends JFrame {
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public map12() throws HeadlessException {
        super("Какие-то непонятные точки на карте");
    }

    public void run() {
        addGui();
        addButtonActionListener();
    }

    public void addGui() {
        panel = new JPanel();
        button = new JButton("Показать карту");
        label = new JLabel();

        panel.add(button);
        panel.add(label);

        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addButtonActionListener() {
        button.addActionListener(e -> {
            try {
                addImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void addImage() throws IOException {
        Image image = ImageIO.read(new URL("https://static-maps.yandex.ru/1.x/?ll=32.039091,54.781830&z=17&l=map&" +
                "pt=32.041901,54.780564,1" +
                "~32.041703,54.780903,pmdos2" +
                "~32.040027,54.781253,pm2vvm3" +
                "~32.038424,54.782181,flag~" +
                "32.038041,54.782746,ya_ru"));
        label.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        new map12().run();
    }
}