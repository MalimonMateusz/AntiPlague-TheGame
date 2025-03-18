package ANTIPLAGUE.view;

import ANTIPLAGUE.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeaderBoardFrame extends View {
    private final String filePath = "leaderboard.txt";


    public LeaderBoardFrame(Controller controller) {

        super(controller);
    }





    public void CreateLeaderBoard() {
        try {

            // Wczytywanie Obrazów
            ImageIcon rightDoctorIcon = new ImageIcon("Pictures/rightDoctor.png");
            ImageIcon leftDoctorIcon = new ImageIcon("Pictures/leftDoctor.png");
            ImageIcon leaderBoardIcon = new ImageIcon("Pictures/leaderboardPicture.png");
            JPanel backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    setBounds(0, 0, frame.getWidth(), frame.getHeight());
                    setBackground(Color.BLACK);
                    setOpaque(true);
                }
            };


            // Tworzenie Paneli
            JPanel rightDoctorPanel = createImagePanel(rightDoctorIcon);
            JPanel leftDoctorPanel = createImagePanel(leftDoctorIcon);
            JPanel leaderboardPanel = createImagePanel(leaderBoardIcon);


            // Return Button
            JButton returnButton = new JButton("Return");
            returnButton.setBackground(new Color(0, 0, 0));
            returnButton.setForeground(Color.WHITE);
            returnButton.setFocusPainted(false);
            returnButton.setVisible(true);
            returnButton.setFont(new Font("Serif", Font.BOLD, 20));
            returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    returnButton.setBorder(BorderFactory.createLineBorder(Color.RED));

                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    returnButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                }

                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    frame.dispose();
                    controller.returnPressed();

                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    returnButton.setBackground(new Color(1,1,99));
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {

                    returnButton.setBackground(Color.BLACK);
                }

            });








            String[] items = getTop10(filePath);;


            JList<String> jlist = new JList<>(items);
            jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jlist.setBackground(Color.BLACK);
            jlist.setForeground(Color.WHITE);
            jlist.setFixedCellHeight(frame.getHeight()/15);
            jlist.setCellRenderer((jList, value, index, isSelected, hasFocus) -> {
                JLabel label = new JLabel(value, SwingConstants.CENTER);
                label.setOpaque(true);
                label.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Ustaw czcionkę tutaj

                if (isSelected) {
                    label.setBackground(Color.CYAN);
                    label.setForeground(Color.BLACK);
                } else {
                    label.setBackground(Color.BLACK);
                    label.setForeground(Color.WHITE);
                }

                return label;
            });




            layeredPane.add(backgroundPanel, Integer.valueOf(0));
            layeredPane.add(leftDoctorPanel, Integer.valueOf(1));
            layeredPane.add(rightDoctorPanel, Integer.valueOf(2));
            layeredPane.add(leaderboardPanel, Integer.valueOf(3));
            layeredPane.add(jlist, Integer.valueOf(4));
            layeredPane.add(returnButton, Integer.valueOf(5));
            leaderboardPanel.setOpaque(false);

            frame.addComponentListener(new java.awt.event.ComponentAdapter() {
                public void componentResized(java.awt.event.ComponentEvent evt) {
                    layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
                    backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
                    leftDoctorPanel.setBounds(0, 0, frame.getWidth()/3, frame.getHeight());
                    rightDoctorPanel.setBounds(frame.getWidth()/3*2, 0, frame.getWidth()/3, frame.getHeight());
                    leaderboardPanel.setBounds(frame.getWidth()/3 + frame.getWidth()/50 ,frame.getHeight()/100, frame.getWidth()/3-frame.getWidth()/25,frame.getHeight()/8);
                    jlist.setBounds(frame.getWidth()/3,frame.getHeight()/6, frame.getWidth()/3 ,frame.getHeight()- frame.getHeight()/4);
                    returnButton.setBounds(frame.getWidth()/3 + frame.getWidth()/15, frame.getHeight() - frame.getHeight()/8, frame.getWidth()/3-frame.getWidth()/15*2 , frame.getHeight()/15);
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            });





            layeredPane.setVisible(true);
            frame.setVisible(true);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static String[] getTop10(String filePath) throws IOException {
        String[] lines = new String[10];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 10) {
                if(line.equals("0 a")){
                    line = " ";
                }
                lines[count] = line;
                count++;
            }
        }
        return lines;
    }







    @Override
    public void run() {
            CreateLeaderBoard();
    }
}
