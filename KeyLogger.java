
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

public class KeyLogger extends JFrame {
    public KeyLogger() throws HeadlessException {
        initComponents();
    }

    public static void main(String[] args) {
        new KeyLogger().setVisible(true);
    }


    protected void initComponents() {

        setSize(500, 500);
        setTitle("KeyLogger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));


        JLabel label = new JLabel();
        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(150, 20));
        getContentPane().add(label);
        getContentPane().add(tf);


        tf.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                String text = textField.getText();
                textField.setText(text);
                try {
                    FileWriter writer = new FileWriter("keylogger.txt");
                    writer.write(text);
                    writer.close();
                }catch (IOException ex){
                    System.out.println("Ошибка");
                    ex.printStackTrace();
                }
            }
        });

    }
}