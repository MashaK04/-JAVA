import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CarBuilder extends JFrame {
    public CarBuilder() {
        super();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Автомобиль");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 1112;
        int height = 636;
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        Color b = new Color(255, 255, 255);
        frame.getContentPane().setBackground(b);

        car body = new car(0, Color.YELLOW);
        body.setBounds(38, 56, width, height);
        frame.add(body);

        car rearWheel = new car(1, Color.BLACK);
        rearWheel.setBounds(192, 368, width, height);
        frame.add(rearWheel);

        car frontWheel = new car(1, Color.BLACK);
        frontWheel.setBounds(706, 368, width, height);
        frame.add(frontWheel);

        frame.pack();
        frame.setVisible(true);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        frame.paint(graphics2D);
        try {
            ImageIO.write(image,"jpeg", new File("output.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}