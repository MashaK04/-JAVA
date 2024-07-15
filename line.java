import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

public class line extends Canvas {
    static int width = 500, height=500;

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        try {
            URLConnection openConnection = new URL("https://avatars.mds.yandex.net/i?id=9f408e019501dc8d67b24bc02986b1d80581de7c-4391775-images-thumbs&n=13").openConnection();
            BufferedImage image = ImageIO.read(openConnection.getInputStream());
            int imageWidth = image.getWidth(), imageHeight=image.getHeight();
            int y = 0, x = 0;
            while (true) {
                if (x>width||y>height) {
                    y = 0;
                    x = 0;
                }
                g2.drawImage(image, x, y, this);
                TimeUnit.MILLISECONDS.sleep(30);
                g2.clearRect(x, y, imageWidth, imageHeight);
                x+=3;
                y+=3;
            }
        } catch (IOException | InterruptedException e) {
            g.drawString("Ошибка", 10,10);
        }
        ;    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Прямая");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-width/2,dim.height/2-height/2, width,height);
        line m=new line();
        frame.add(m);
        frame.setVisible(true);
    }
}