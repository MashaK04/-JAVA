


import javax.swing.*;
import java.awt.*;

public class TrafficLightGUI extends JFrame {

    public TrafficLightGUI() {
        setTitle("Светофор");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(75, 50, 50, 150);

        g.setColor(Color.RED);
        g.fillOval(85, 60, 30, 30);

        g.setColor(Color.YELLOW);
        g.fillOval(85, 110, 30, 30);

        g.setColor(Color.GREEN);
        g.fillOval(85, 160, 30, 30);
    }

    public static void main(String[] args) {
        TrafficLightGUI trafficLight = new TrafficLightGUI();
    }
}
