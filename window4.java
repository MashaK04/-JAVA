import javax.swing.*;

public class window4 {
    public static void main(String[] args) {
        String[] resolutions = {"800x600", "1024x768", "1280x720", "1920x1080"};

        JFrame frame = new JFrame("Выберите разрешение экрана");
        String select = (String) JOptionPane.showInputDialog(frame, "Выберите разрешение:", "Разрешение экрана",
                JOptionPane.QUESTION_MESSAGE, null, resolutions, resolutions[0]);

        if (select != null) {
            String[] w_h = select.split("x");
            int w = Integer.parseInt(w_h[0]);
            int h = Integer.parseInt(w_h[1]);

            JFrame resolutionFrame = new JFrame("Экран с разрешением " + select);
            resolutionFrame.setSize(w, h);
            resolutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            resolutionFrame.setVisible(true);
        }
    }
}