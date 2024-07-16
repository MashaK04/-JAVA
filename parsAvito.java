import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class parsAvito extends JFrame {
    private JTextField urlField;
    private JButton parseButton;
    private JTable resultTable;

    public parsAvito() {
        setTitle("Youla Parser");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        urlField = new JTextField(30);
        parseButton = new JButton("Parse");
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlField.getText();
                if (!url.isEmpty()) {
                    parseYoula(url);
                }
            }
        });

        resultTable = new JTable(new DefaultTableModel(new Object[]{"Title", "City", "Price", "Seller"}, 0));

        JScrollPane scrollPane = new JScrollPane(resultTable);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Youla URL: "));
        panel.add(urlField);
        panel.add(parseButton);

        add(panel, "North");
        add(scrollPane);

        setVisible(true);
    }

    private void parseYoula(String url) {
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0);

        try {
            Document doc = Jsoup.connect(url).get();
            Elements items = doc.select(".product_item");

            for (Element item : items) {
                String title = item.select(".product_item__title").text();
                String city = item.select(".product_item__location").text();
                String price = item.select(".product_item__price").text();
                String seller = item.select(".product_item__seller").text();

                model.addRow(new Object[]{title, city, price, seller});
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error parsing the URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(parsAvito::new);
    }
}