import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class widget9 extends JFrame implements ActionListener {
    private JTextField textField;
    private double firstNumber, secondNumber, result;
    private String operator;

    public widget9() {
        setTitle("Калькулятор");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "Очистка", "=", "+"
        };

        for (String buttonLabel : buttonLabels) {
            JButton button = new JButton(buttonLabel);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Очистка")) {
            textField.setText("");
        } else if (command.equals("=")) {
            secondNumber = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        textField.setText("Ошибка: деление на 0");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        } else {
            if (command.equals("-") || command.equals("+") || command.equals("*") || command.equals("/")) {
                firstNumber = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            } else {
                textField.setText(textField.getText() + command);
            }
        }
    }

    public static void main(String[] args) {
        new widget9();
    }
}