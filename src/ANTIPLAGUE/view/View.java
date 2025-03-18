package ANTIPLAGUE.view;

import ANTIPLAGUE.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class View implements Runnable{
     Controller controller;
     JFrame frame;
     JLayeredPane layeredPane;

     View(Controller controller) {
         this.controller = controller;
         layeredPane = new JLayeredPane();
         frame = new JFrame();
         frame.add(layeredPane);
         frame.setTitle("AntiPlague");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(true);
         frame.setSize(1000, 800);
         frame.setLayout(null);
         layeredPane.setLayout(null);
         ImageIcon icon = new ImageIcon("Pictures/icon.jpg");
         frame.setIconImage(icon.getImage());

         layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
         layeredPane.setLayout(null);


     }

    protected JPanel createImagePanel(ImageIcon imageIcon) {
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setOpaque(false);
        return imagePanel;
    }

    public void newAnnouncement(String s){

    }

    public void updateInfo(){}
    public void endGame(Boolean flag) throws IOException {}
    public void triggerAnimation(String countryName1, String countryName2, String transport){}


    @Override
    public void run() {

    }
}
