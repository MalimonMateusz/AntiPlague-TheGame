package ANTIPLAGUE.panel;

import ANTIPLAGUE.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class CountryPanel extends JPanel implements Runnable {

    private JLabel countryNameLabel;
    private JLabel populationLabel;
    private JLabel healthyLabel;
    private JLabel infectedLabel;
    private JLabel countryImageLabel;
    private JLabel deadLabel;
    private JLabel recoveredLabel;
    public boolean running;

    public CountryPanel() {
        running = true;
        this.countryNameLabel = new JLabel();
        this.populationLabel = new JLabel();
        this.healthyLabel = new JLabel();
        this.infectedLabel = new JLabel();
        this.countryImageLabel = new JLabel();
        this.deadLabel = new JLabel();
        this.recoveredLabel = new JLabel();
    }



    @Override
    public void run() {
        setLayout(null);
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(new Color(36, 28, 70));


        makeLabel(countryNameLabel,"Country: ", new Color(220,20,60));
        countryNameLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        makeLabel(populationLabel,"Population: ", Color.WHITE);
        makeLabel(healthyLabel,"Healthy: ", Color.ORANGE);
        makeLabel(infectedLabel,"Infected: ", Color.GREEN);
        makeLabel(deadLabel,"Infected: ", Color.GRAY);
        makeLabel(recoveredLabel,"Infected: ", Color.BLUE);

        textPanel.add(countryNameLabel);
        textPanel.add(populationLabel);
        textPanel.add(healthyLabel);
        textPanel.add(infectedLabel);
        textPanel.add(recoveredLabel);
        textPanel.add(deadLabel);

        countryImageLabel = new JLabel();

        try {
            ImageIcon countryImage = new ImageIcon("Pictures/black.png");
            countryImageLabel.setIcon(scaleImage(countryImage, 200, 200));  // Przeskalowywujemy obraz
        } catch (Exception e) {
            e.printStackTrace();
        }

        textPanel.add(countryImageLabel);
        add(textPanel);
        add(countryImageLabel);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int panelWidth = getWidth();
                int panelHeight = getHeight();


                textPanel.setBounds(0, 0, panelWidth / 2, panelHeight);

                countryImageLabel.setBounds(panelWidth / 2, 0, panelWidth / 2, panelHeight);


                Icon icon = countryImageLabel.getIcon();
                if (icon instanceof ImageIcon) {
                    ImageIcon imgIcon = (ImageIcon) icon;
                    countryImageLabel.setIcon(scaleImage(imgIcon, panelWidth / 2, panelHeight));
                }
            }
        });
    }


    private void makeLabel(JLabel label, String text, Color color) {
        label.setText(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(color);
        label.setAlignmentX(LEFT_ALIGNMENT);
    }

    private ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public void updateCountryInfo(String countryName, String population, String healthy, String infected, String imagePath, String dead, String recovered) {

        countryNameLabel.setText(countryName.toUpperCase());

        populationLabel.setText("Population: " + population);
        healthyLabel.setText("Healthy: " + healthy);
        infectedLabel.setText("Infected: " + infected);
        deadLabel.setText("Dead: " + dead);
        recoveredLabel.setText("Recovered: " + recovered);

        try {
            ImageIcon countryImage = new ImageIcon(imagePath);
            countryImageLabel.setIcon(scaleImage(countryImage, this.getWidth()/2, this.getHeight()));
        } catch (Exception e) {
        }
    }

    public void stop() {
        running = false;
    }

}
