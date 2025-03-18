package ANTIPLAGUE.panel;

import javax.swing.*;
import java.awt.*;


public class transportPanel extends JPanel {
    private Image image;

    public transportPanel(String imagePath) {
        this.image = new ImageIcon(imagePath).getImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
    }


}
