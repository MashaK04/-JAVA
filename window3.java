import javax.swing.JOptionPane;

public class window3 {
    public static void main(String[] args) {
        int firstOption = JOptionPane.showConfirmDialog(null, "Вы любите кофе?", "Вопрос  №1", JOptionPane.YES_NO_OPTION);
        int secondOption = JOptionPane.showConfirmDialog(null, "Вы любите путешествия?", "Вопрос №2", JOptionPane.YES_NO_OPTION);

        String resultMessage = getResultMessage(firstOption, secondOption);
        JOptionPane.showMessageDialog(null, resultMessage, "Результат", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getResultMessage(int firstOption, int secondOption) {
        if (firstOption == JOptionPane.YES_OPTION && secondOption == JOptionPane.YES_OPTION) {
            return "Вы любите кофе и любите путешествия!";
        } else if (firstOption == JOptionPane.YES_OPTION && secondOption == JOptionPane.NO_OPTION) {
            return "Вы любите кофе, но не любите путешествия";
        } else if (firstOption == JOptionPane.NO_OPTION && secondOption == JOptionPane.YES_OPTION) {
            return "Вы не любите кофе, но любите путешествия";
        } else {
            return "Вы не любите кофе и не любите путешествия";
        }
    }
}