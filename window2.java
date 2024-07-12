import javax.swing.*;
import java.awt.event.*;

public class window2 extends JFrame {
    private JTextField nameField;

    public window2() {
        setTitle("Введите ваше имя");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        nameField = new JTextField(20);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                dispose();
                showMessageDialogWithName(name);
            }
        });

        panel.add(new JLabel("Введите ваше имя: "));
        panel.add(nameField);
        panel.add(okButton);

        add(panel);
        setVisible(true);
    }

    private void showMessageDialogWithName(String name) {
        JOptionPane.showMessageDialog(null, "Привет, " + name, "Второе окно", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new window2();
            }
        });
    }
}