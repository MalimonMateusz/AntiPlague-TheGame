package ANTIPLAGUE.view;

import ANTIPLAGUE.controller.Controller;

import javax.swing.*;
import java.awt.*;


public class MenuFrame extends View {
    public MenuFrame(Controller controller) {
        super(controller);
    }


    public void menu(){
        ImageIcon backgroundIcon = new ImageIcon("Pictures/MenuBackground.jpg");
        ImageIcon titleIcon = new ImageIcon("Pictures/TitlePicture.png");
        ImageIcon scaledIcon = new ImageIcon(new ImageIcon("Pictures/difficultyIcon.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));


        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        JPanel titlePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(titleIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        titlePanel.setOpaque(false);

        layeredPane.add(titlePanel, Integer.valueOf(1));
        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        layeredPane.setVisible(true);


        JButton newGameButton = new JButton("New Game");
        newGameButton.setBackground(new Color(0, 0, 0));
        newGameButton.setForeground(Color.GRAY);
        newGameButton.setFocusPainted(false);
        newGameButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
        JButton highScoresButton = new JButton("High scores");
        highScoresButton.setBackground(new Color(0, 0, 0));
        highScoresButton.setForeground(Color.GRAY);
        highScoresButton.setFocusPainted(false);
        highScoresButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(0, 0, 0));
        exitButton.setForeground(Color.GRAY);
        exitButton.setFocusPainted(false);
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
        newGameButton.setVisible(true);
        highScoresButton.setVisible(true);
        exitButton.setVisible(true);
        layeredPane.add(newGameButton, Integer.valueOf(2));
        layeredPane.add(highScoresButton, Integer.valueOf(2));
        layeredPane.add(exitButton, Integer.valueOf(2));

        newGameButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);
        highScoresButton.setFocusPainted(false);

        newGameButton.setContentAreaFilled(false);
        highScoresButton.setContentAreaFilled(false);
        exitButton.setContentAreaFilled(false);

        exitButton.setOpaque(true);
        highScoresButton.setOpaque(true);
        newGameButton.setOpaque(true);

        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
                backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight()+1);
                titlePanel.setBounds(frame.getWidth()/2 - (frame.getWidth()-frame.getWidth()/6)/2 ,frame.getHeight()/8, frame.getWidth()-frame.getWidth()/6,frame.getHeight()/4);
                newGameButton.setBounds(frame.getWidth()/2-frame.getWidth()/16, frame.getHeight()/2, frame.getWidth()/8,frame.getHeight()/14);
                highScoresButton.setBounds(frame.getWidth()/2-frame.getWidth()/16, frame.getHeight()/2 + newGameButton.getHeight()+ 10, frame.getWidth()/8,frame.getHeight()/14);
                exitButton.setBounds(frame.getWidth()/2-frame.getWidth()/16, frame.getHeight()/2 + highScoresButton.getHeight()*2 + 20, frame.getWidth()/8,frame.getHeight()/14);

                layeredPane.revalidate();
                layeredPane.repaint();

                System.out.println(frame.getWidth());
                System.out.println(backgroundPanel.getWidth());


            }
        });

        newGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newGameButton.setBorder(BorderFactory.createLineBorder(Color.RED));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newGameButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String[] options = {"Hard", "Normal"};
                int choice = JOptionPane.showOptionDialog(

                        null,
                        "!!! CHOOSE DIFFICULTY !!!",
                        "ANTIPLAGUE",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        scaledIcon,
                        options,
                        options[0]
                );
                frame.dispose();


                controller.startNewGamePressed(options[choice]);

            }



            public void mousePressed(java.awt.event.MouseEvent evt) {
                newGameButton.setBackground(new Color(1,1,99));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newGameButton.setBackground(Color.BLACK);
            }

        });

        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButton.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                controller.exitPressed();
        }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitButton.setBackground(new Color(1,1,99));
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitButton.setBackground(Color.BLACK);
            }


        });

        highScoresButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                highScoresButton.setBorder(BorderFactory.createLineBorder(Color.RED));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                highScoresButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                controller.highScorePressed();
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                highScoresButton.setBackground(new Color(1,1,99));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                highScoresButton.setBackground(Color.BLACK);
            }

        });
        frame.setVisible(true);


    }

    @Override
    public void run() {
            menu();
    }
}
