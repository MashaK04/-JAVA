import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form extends JFrame implements ActionListener {
    JTextField nameField, lastNameField, middleNameField, emailField, phoneField;
    JRadioButton maleRadio, femaleRadio;
    JCheckBox vegetarianCheck, veganCheck;
    JComboBox<String> cityComboBox;
    JSlider ageSlider;
    JTextArea commentsArea;
    JTextField birthYearField;

    public form() {
        setTitle("Форма регистрации");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Имя:");
        nameLabel.setBounds(20, 20, 80, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 20);
        add(nameField);

        JLabel lastNameLabel = new JLabel("Фамилия:");
        lastNameLabel.setBounds(20, 50, 80, 20);
        add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(120, 50, 200, 20);
        add(lastNameField);

        JLabel middleNameLabel = new JLabel("Отчество:");
        middleNameLabel.setBounds(20, 80, 80, 20);
        add(middleNameLabel);

        middleNameField = new JTextField();
        middleNameField.setBounds(120, 80, 200, 20);
        add(middleNameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 110, 80, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 110, 200, 20);
        add(emailField);

        JLabel phoneLabel = new JLabel("Телефон:");
        phoneLabel.setBounds(20, 140, 80, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(120, 140, 200, 20);
        add(phoneField);


        JButton submitButton = new JButton("Отправить");
        submitButton.setBounds(150, 400, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String info = "Имя: " + nameField.getText() + "\n" +
                "Фамилия: " + lastNameField.getText() + "\n" +
                "Отчество: " + middleNameField.getText() + "\n" +
                "Email: " + emailField.getText() + "\n" +
                "Телефон: " + phoneField.getText() + "\n";



        JOptionPane.showMessageDialog(this, info, "Ваши данные", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new form();
    }
}