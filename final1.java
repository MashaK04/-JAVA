import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class final1 extends JFrame {
    public static final String SEARCH_KEY = "xxx";
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private JPanel panel;
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea detailsArea;
    private JLabel imageLabel;
    private JSlider slider;
    private ButtonGroup buttonGroup;
    private JRadioButton schemeRadioButton;
    private JRadioButton sputnikRadioButton;
    private JCheckBox checkBox;
    private JList list;
    private String z = "&z=16";
    private String l = "&l=map";
    private String t = "";
    private String mapLink;
    private String objLink;
    private String coordinates;
    private List<String> nameList;
    private List<String> coordinatesList;
    private List<String> detailsList;
    private JSONArray jsonArray;

    public final1() throws HeadlessException {
        super("Yandex Maps Project");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new final1().run();
    }


    public String getObjLink() {
        objLink = "https://search-maps.yandex.ru/v1/?lang=ru_RU&apikey=" + SEARCH_KEY + "&text=" + searchField.getText().replace(" ", "+");
        return objLink;
    }

    public void run() throws IOException, InterruptedException {
        addGui();
        addButtonGroup();
        addListeners();
    }

    public void addGui() {
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addButtonGroup() {
        buttonGroup = new ButtonGroup();
        buttonGroup.add(schemeRadioButton);
        buttonGroup.add(sputnikRadioButton);
    }


    public void addListeners() {
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        showList();
                    } catch (URISyntaxException | IOException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        searchButton.addActionListener(e -> {
            try {
                showList();
            } catch (URISyntaxException | InterruptedException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        list.addListSelectionListener(e -> {
            detailsArea.setText("");
            if (list.getSelectedIndex() != -1) {
                setCoordinates();
                showDetails();
                try {
                    changeImage();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        schemeRadioButton.addChangeListener(e -> {
            setL();
            try {
                changeImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        checkBox.addChangeListener(e -> {
            setT();
            try {
                changeImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        slider.addChangeListener(e -> {
            setZ();
            try {
                changeImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void showList() throws URISyntaxException, IOException, InterruptedException {
        setJsonArray();
        setNameList();
        model.clear();
        list.setModel(model);
        for (String s : nameList) {
            model.addElement(s);
        }
    }

    public void setJsonArray() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(getObjLink())).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jo = new JSONObject(response.body());
        jsonArray = (JSONArray) jo.get("features");
    }

    public void setNameList() {
        nameList = new ArrayList<>();
        if (jsonArray.length() == 0) {
            nameList.add("404 not found");
        } else {
            for (Object o : jsonArray) {
                JSONObject properties = ((JSONObject) o).getJSONObject("properties");
                if (properties.has("CompanyMetaData")) {
                    nameList.add(properties.get("name") + " (организация)");
                } else nameList.add((String) properties.get("name"));
            }
        }
    }

    public void setCoordinatesList() {
        coordinatesList = new ArrayList<>();
        for (Object o : jsonArray) {
            JSONArray jaCoordinates = ((JSONObject) o).getJSONObject("geometry").getJSONArray("coordinates");
            coordinatesList.add(jaCoordinates.get(0) + "," + jaCoordinates.get(1));
        }
    }

    public void setDetailsList() {
        detailsList = new ArrayList<>();
        if (jsonArray.length() != 0) {
            for (Object o : jsonArray) {
                JSONObject properties = ((JSONObject) o).getJSONObject("properties");
                if (properties.has("CompanyMetaData")) {
                    JSONObject comMD = properties.getJSONObject("CompanyMetaData");
                    String details = "coordinates: " + coordinatesList.get(list.getSelectedIndex()).replace(",", ", ");
                    for (Object name : comMD.names()) {
                        switch (name.toString()) {
                            case "Phones" -> {
                                JSONObject phone = comMD.getJSONArray((String) name).getJSONObject(0);
                                details += "\n" + phone.get("type") + ": " + phone.get("formatted");
                            }
                            case "Categories" -> {
                                JSONObject categories = comMD.getJSONArray((String) name).getJSONObject(0);
                                details += "\n" + categories.get("class") + ": " + categories.get("name");
                            }
                            case "Hours" -> {
                                JSONObject hours = comMD.getJSONObject((String) name);
                                details += "\nhours: " + hours.get("text");
                            }
                            default -> details += "\n" + name + ": " + comMD.get((String) name);
                        }
                    }
                    detailsList.add(details);
                } else {
                    JSONObject geoMD = properties.getJSONObject("GeocoderMetaData");
                    String details = "coordinates: " + coordinatesList.get(list.getSelectedIndex()).replace(",", ", ");
                    for (Object name : geoMD.names()) {
                        details += "\n" + name + ": " + geoMD.get((String) name);
                    }
                    detailsList.add(details);
                }
            }
        }
    }

    public void changeImage() throws IOException {
        Image image = ImageIO.read(new URL(getMapLink()));
        imageLabel.setIcon(new ImageIcon(image));
    }

    public String getMapLink() {
        mapLink = "https://static-maps.yandex.ru/1.x/?ll=" + coordinates + "&pt=" + coordinates + ",flag" + z + l + t;
        return mapLink;
    }

    public void setZ() {
        z = "&z=" + slider.getValue();
    }

    public void setL() {
        l = buttonGroup.getSelection().getActionCommand();
    }

    public void setT() {
        if (checkBox.isSelected()) {
            t = ",trf";
        } else t = "";
    }

    public void setCoordinates() {
        setCoordinatesList();
        int index = list.getSelectedIndex();
        coordinates = coordinatesList.get(index);
    }

    public void showDetails() {
        setDetailsList();
        int index = list.getSelectedIndex();
        detailsArea.setText(detailsList.get(index));
    }
}