import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class car extends JComponent {

    private Color color;
    private int type;

    public car(int type, Color color) {
        this.type = type;
        this.color = color;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setStroke(new BasicStroke(8)); //ширина границы
        switch (type) {
            /* Path - car body */
            case 0:
                /*Body*/
                Path2D body = new Path2D.Double();
                body.moveTo(4,345);
                body.quadTo(8,330,24,316);
                body.quadTo(28,244,88,172);
                body.curveTo(248,-50,632,-50,800,172);
                body.quadTo(1016,165,1028,340);
                body.quadTo(1048,380,1008,420);
                body.lineTo(876,420);
                body.curveTo(876, 252, 650, 252,650,420);
                body.lineTo(362,420);
                body.curveTo(362, 252, 136, 252,136,420);
                body.lineTo(44,420);
                body.quadTo(0,384,4,345);
                body.closePath();
                g2.draw(body);
                g2.fill(body);
                g2.setColor(Color.BLACK);
                g2.draw(body);
                /*Front window*/
                g2.setColor(Color.WHITE);
                Path2D frontWindow = new Path2D.Double();
                frontWindow.moveTo(436,172);
                frontWindow.lineTo(436,44);
                frontWindow.quadTo(616,36,744,172);
                frontWindow.lineTo(436,172);
                frontWindow.closePath();
                g2.draw(frontWindow);
                g2.fill(frontWindow);
                g2.setColor(Color.BLACK);
                g2.draw(frontWindow);
                /*Rear window*/
                g2.setColor(Color.WHITE);
                Path2D rearWindow = new Path2D.Double();
                rearWindow.moveTo(396,172);
                rearWindow.lineTo(396,48);
                rearWindow.quadTo(240,66,148,172);
                rearWindow.lineTo(396,172);
                rearWindow.closePath();
                g2.draw(rearWindow);
                g2.fill(rearWindow);
                g2.setColor(Color.BLACK);
                g2.draw(rearWindow);
                /*Head lamp*/
                g2.setColor(Color.WHITE);
                Path2D headLamp = new Path2D.Double();
                headLamp.moveTo(892,232);
                headLamp.quadTo(968,226,992,290);
                headLamp.quadTo(916,290,892,232);
                headLamp.closePath();
                g2.draw(headLamp);
                g2.fill(headLamp);
                g2.setColor(Color.BLACK);
                g2.draw(headLamp);
                /*Door handle*/
                g2.drawLine(450,228,506,228); //ручка двери
                break;

            /*Wheel*/
            case 1:
                g2.fillOval(0,0,192,192);
                g2.setColor(Color.WHITE);
                g2.fillOval(52,52,84,84);
                break;
        }
    }
}