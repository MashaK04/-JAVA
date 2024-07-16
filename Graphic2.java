
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class Graphic2 {
    public static void main(String[] args) throws IOException {
        int width = 1000, height = 1000;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Земля вокруг Солнца");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height + 30);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(102, 204, 255));
        BufferedImage previewImage1 = ImageIO.read(new URL("https://narisyu.cdnbro.com/posts/79856254-narisovannoe-solntse-png-29.jpg"));
        BufferedImage previewImage2 = ImageIO.read(new URL("https://avatars.mds.yandex.net/i?id=d774329bb3fe2367d827c1d5d5bbe8a844ca652d8c8d7051-13461479-images-thumbs&n=13"));
        int pic1Width = previewImage1.getWidth(), pic1Height = previewImage1.getHeight();
        int pic2Width = previewImage2.getWidth(), pic2Height = previewImage2.getHeight();
        JLabel wIcon1 = new JLabel(new ImageIcon(previewImage1));
        JLabel wIcon2 = new JLabel(new ImageIcon(previewImage2));
        int start1X = width / 2 - pic1Width / 2, start1Y = height / 2 - pic1Height / 2;
        wIcon1.setBounds(start1X, start1Y, pic1Width, pic1Height);
        int start2X = width / 2 - pic2Width / 2, start2Y = height / 20;
        wIcon2.setBounds(start2X, start2Y, pic2Width, pic2Height);
        frame.add(wIcon1);
        frame.add(wIcon2);
        frame.setVisible(true);
        int radius=Math.max(width, height)/2-Math.max(pic2Width, pic2Height);
        int deltaX=width/2-pic2Width/2, deltaY=height/2-pic2Height/2;
        for (int t = 0; t < 360;) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            wIcon2.setBounds((int) (radius*Math.cos(t*Math.PI/180))+deltaX, (int) (radius*Math.sin(t*Math.PI/180))+deltaY, pic2Width, pic2Height);
            wIcon2.repaint();
            t=t==359?0:t+1;
        }
    }
}