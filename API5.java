import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API5 extends JFrame {

    private JPanel panel;
    private JButton catButton;
    private JButton dogButton;
    private JButton foxButton;
    private JPanel imagePanel;
    private JLabel label;

    public API5() {
        super("Animals");
        initializeComponents();
        actionListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        panel = new JPanel();
        catButton = new JButton("Cat");
        dogButton = new JButton("Dog");
        foxButton = new JButton("Fox");
        imagePanel = new JPanel();
        label = new JLabel();

        panel.add(catButton);
        panel.add(dogButton);
        panel.add(foxButton);
        imagePanel.add(label);

        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(imagePanel, BorderLayout.CENTER);

        pack();
    }

    private void actionListeners() {
        catButton.addActionListener(e -> {
            try {
                setImage(getCat());
            } catch (URISyntaxException | IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        dogButton.addActionListener(e -> {
            try {
                setImage(getDog());
            } catch (URISyntaxException | IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        foxButton.addActionListener(e -> {
            try {
                setImage(getFox());
            } catch (URISyntaxException | IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void setImage(String url) throws IOException {
        Image image = ImageIO.read(new URL(url)).getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        label.setIcon(new ImageIcon(image));
    }

    String getCat() throws URISyntaxException, IOException, InterruptedException {
        return "https://cataas.com" + getImage("https://cataas.com/cat?json=true", "url");
    }

    private String getDog() throws URISyntaxException, IOException, InterruptedException {
        return getImage("https://dog.ceo/api/breeds/image/random", "message");
    }

    private String getFox() throws URISyntaxException, IOException, InterruptedException {
        return getImage("https://randomfox.ca/floof/", "image");
    }

    private String getImage(String url, String key) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject obj = new JSONObject(response.body());
        return obj.getString(key);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new API5());
    }
}