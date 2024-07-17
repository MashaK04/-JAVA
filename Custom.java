import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Custom {
    public static void main(String[] args) {
        int[] x = {800, 1024, 1200, 1280, 1680, 1920};
        int[] y = {600, 768, 600, 1024, 1050, 1080};
        String[] strings = new String[x.length];
        JRadioButton[] buttons = new JRadioButton[x.length];
        ButtonGroup buttonGroup = new ButtonGroup();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(x.length,1,0,0));
        for (int i = 0; i < x.length; i++) {
            strings[i] = x[i] + "x" + y[i];
            buttons[i] = new JRadioButton(strings[i]);
            buttons[i].setActionCommand(strings[i]);
            buttonGroup.add(buttons[i]);
            panel.add(buttons[i]);
        }
        buttons[2].setSelected(true);
        JOptionPane.showMessageDialog(null, panel, "Message", JOptionPane.INFORMATION_MESSAGE);
        String result = buttonGroup.getSelection().getActionCommand();
        int index = Arrays.asList(strings).indexOf(result);
        JFrame frame = new JFrame("ChooseResolution2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x[index], y[index]);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}