import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class widget8 extends JFrame implements ActionListener {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton submitButton;
    private ButtonGroup buttonGroup;
    private int score = 0;
    private int question = 0;
    private String[][] questions = {
            {"Какая столица России?", "Псков", "Москва", "Санкт-Петеербург", "Киров"},
            {"Сколько станций метро в Санкт-Петербурге?", "8", "5", "7", "6"},
            {"Кто написал произведение 'Война и мир'?", "Лев Толстой", "Федор Достоевский", "Александр Пушкин", "Иван Тургенев"}
    };
    private String[] answers = {"Москва", "5", "Лев Толстой"};

    public widget8() {
        setTitle("Викторина");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        questionLabel = new JLabel(questions[question][0]);
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        options = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton(questions[question][i + 1]);
            buttonGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }
        panel.add(optionsPanel, BorderLayout.CENTER);

        submitButton = new JButton("Ответить");
        submitButton.addActionListener(this);
        panel.add(submitButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            for (int i = 0; i < 4; i++) {
                if (options[i].isSelected() && options[i].getText().equals(answers[question])) {
                    score++;
                }
            }
            question = question + 1;
            if (question < questions.length) {
                questionLabel.setText(questions[question][0]);
                for (int i = 0; i < 4; i++) {
                    options[i].setText(questions[question][i + 1]);
                    options[i].setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ваш результат: " + score + " из " + questions.length);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new widget8();
    }
}