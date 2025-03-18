package ANTIPLAGUE.view;

import ANTIPLAGUE.controller.Controller;
import ANTIPLAGUE.model.Country;
import ANTIPLAGUE.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameFrame extends View {

    GameTime gameTime;
    CLI cli;
    CountryPanel countryPanel;
    String selectedCountry;
    UpgradePanel upgradePanel;
    boolean running;
    MoneyCounter moneyCounter;

    JButton nauru = createInvisibleButton();
    JButton lechia = createInvisibleButton();
    JButton district_x = createInvisibleButton();
    JButton china  = createInvisibleButton();
    JButton kaedwen = createInvisibleButton();
    JButton tuvalu = createInvisibleButton();
    JButton slaka = createInvisibleButton();
    JButton korea = createInvisibleButton();
    JButton ulthar = createInvisibleButton();
    JButton skellige = createInvisibleButton();


    public GameFrame(Controller controller) {
        super(controller);




        this.gameTime = new GameTime();
        this.cli = new CLI();
        this.countryPanel = new CountryPanel();
        this.moneyCounter = new MoneyCounter();
        this.upgradePanel = new UpgradePanel(controller, moneyCounter);
        this.selectedCountry = "china";


        running = true;
    }

    public void makeGame(){
        ImageIcon map = new ImageIcon("Pictures/map.png");
        upgradePanel.setCli(this.cli);




        JPanel mapPanel = createImagePanel(map);
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(Color.BLACK);



        // BUTTONS


        JButton upgrades = new JButton("Upgrades");
        upgrades.setBackground(new Color(28, 81, 23));
        upgrades.setForeground(Color.WHITE);
        upgrades.setFont(new Font("Times New Roman", Font.BOLD, 20));

        upgrades.setOpaque(true);
        upgrades.setFocusPainted(false);





        layeredPane.add(mapPanel, Integer.valueOf(1));
        layeredPane.add(gameTime.timerPanel, Integer.valueOf(3));
        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        layeredPane.add(cli, Integer.valueOf(3));
        layeredPane.add(countryPanel, Integer.valueOf(3));
        layeredPane.add(upgradePanel, Integer.valueOf(8));
        layeredPane.add(moneyCounter, Integer.valueOf(5));


        layeredPane.add(nauru, Integer.valueOf(4));
        layeredPane.add(lechia, Integer.valueOf(4));
        layeredPane.add(district_x, Integer.valueOf(4));
        layeredPane.add(tuvalu, Integer.valueOf(4));
        layeredPane.add(kaedwen, Integer.valueOf(4));
        layeredPane.add(china, Integer.valueOf(4));
        layeredPane.add(slaka, Integer.valueOf(4));
        layeredPane.add(korea, Integer.valueOf(4));
        layeredPane.add(ulthar, Integer.valueOf(4));
        layeredPane.add(skellige, Integer.valueOf(4));
        layeredPane.add(upgrades, Integer.valueOf(5));

        upgradePanel.setVisible(false);
        countryPanel.setOpaque(false);
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int width = frame.getWidth();
                int height = frame.getHeight();

                backgroundPanel.resize(width, height);
                layeredPane.setBounds(0, 0, width,height);
                mapPanel.setBounds(0, 0, width, height/2 + height/4);
                gameTime.timerPanel.setBounds(width-width/6, 0, width/6, height/15);
                moneyCounter.setBounds(0, 0, width/9, height/15);

                cli.setBounds(0, height/2+height/4, width/2, 300);
                countryPanel.setBounds(width/2 + width/7, height/2+height/4, width- width/7 - width/2, height - (height/2+height/4) -30);
                upgradePanel.setBounds(0,0, width, height / 2 + height / 4);

                nauru.setBounds(width/16, height / 50, width/5 + width/10, height/3 - height/30);
                lechia.setBounds(width/10, height / 50 + height/3 - height/30, width/4, height/6);
                district_x.setBounds(width/3, height/2, width/5, height/4);
                tuvalu.setBounds(width/3 + width/30,height/40, width/4, height/4 - height/35 );
                kaedwen.setBounds(width/3 + width/30 ,height/4 , width/3 - width/30, height/8);
                china.setBounds(width/3 + width/30, height/3 + height/20, width/3 - width/30, height/9  );
                slaka.setBounds(width/2 + width/8, height/30, width/5, height/5  );
                korea.setBounds(width/2 + width/4 - width/30, height/4, width/10, height/5 - height/30);
                ulthar.setBounds(width - width/3, height/3 + height/10, width/3 - width/20, height/5 - height/30);
                skellige.setBounds(width - width/3 + width/18  , height - height/2 + height/9, width/4, height/8);

                upgrades.setBounds(width/2,height/2+height/4, width/7, height/2 - height/3 + height/17 );
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        nauru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                if(nauru.isEnabled())countrypressed("nauru");
            }
        });
        tuvalu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                if(tuvalu.isEnabled())  countrypressed("tuvalu");
            }
        });
        slaka.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                if(slaka.isEnabled())  countrypressed("slaka");
            }
        });
        kaedwen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                if(kaedwen.isEnabled())   countrypressed("kaedwen");
            }
        });
        lechia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                if(lechia.isEnabled())   countrypressed("lechia");
            }
        });
        china.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                if(china.isEnabled())   countrypressed("china");
            }
        });
        korea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {

                if(korea.isEnabled())  countrypressed("korea");
            }
        });
        ulthar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(ulthar.isEnabled())   countrypressed("ulthar");
            }
        });

        district_x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(district_x.isEnabled())  countrypressed("district x");
            }
        });
        skellige.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                countrypressed("skellige");

            }
        });

        upgrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(upgradePanel.isVisible()){
                    nauru.setEnabled(true);
                    tuvalu.setEnabled(true);
                    slaka.setEnabled(true);
                    kaedwen.setEnabled(true);
                    china.setEnabled(true);
                    korea.setEnabled(true);
                    ulthar.setEnabled(true);
                    district_x.setEnabled(true);
                    skellige.setEnabled(true);
                    lechia.setEnabled(true);

                    upgradePanel.setVisible(false);
                }else{

                    lechia.setEnabled(false);
                    nauru.setEnabled(false);
                    tuvalu.setEnabled(false);
                    slaka.setEnabled(false);
                    kaedwen.setEnabled(false);
                    china.setEnabled(false);
                    korea.setEnabled(false);
                    ulthar.setEnabled(false);
                    district_x.setEnabled(false);
                    skellige.setEnabled(false);



                    upgradePanel.setCountry(selectedCountry);
                    upgradePanel.setVisible(true);
                }


            }
        });

        layeredPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ctrl shift Q"), "endGame");
        layeredPane.getActionMap().put("endGame", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("endGame");
                cli.stop();
                gameTime.stop();
                countryPanel.stop();
                gameTime.stop();
                moneyCounter.stop();

                try {
                    controller.endGame(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        Thread gameTimeThread = new Thread(gameTime);
        gameTimeThread.start();
        SwingUtilities.invokeLater(countryPanel);
        Thread upgradePanelThread = new Thread(upgradePanel);
        upgradePanelThread.start();

       Thread cliThread = new Thread(cli);
       cliThread.start();

       Thread moneyPanelThread =new Thread(moneyCounter);
       moneyPanelThread.start();






        layeredPane.setVisible(true);
        frame.setVisible(true);

    }


    public void newAnnouncement(String announcement){

        cli.addMessage(announcement);
    }


    public JButton createInvisibleButton() {
        JButton button = new JButton();
        button.setBackground(new Color(0, 0, 0, 0));
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        return button;
    }

    public void countrypressed(String countryName){
        new Thread(new Runnable() {
            @Override
            public void run() {
                selectedCountry = countryName;
                ArrayList<String> stats = controller.getCountryStats(selectedCountry);

                countryPanel.updateCountryInfo(stats.get(0), stats.get(1), stats.get(2), stats.get(3), stats.get(4), stats.get(5), stats.get(6));

                ArrayList<Boolean> upgradesAvailability = new ArrayList<>();


                for (int i =7; i < stats.size(); i++) {
                    upgradesAvailability.add(Boolean.parseBoolean(stats.get(i)));
                }


                upgradePanel.setAvaiability(upgradesAvailability);

            }
        }).start();
    }

    public void updateInfo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> stats = controller.getCountryStats(selectedCountry);
                moneyCounter.changeMoney(30);
                moneyCounter.changeMoney(Integer.parseInt(stats.get(16)));
                countryPanel.updateCountryInfo(stats.get(0), stats.get(1), stats.get(2), stats.get(3), stats.get(4), stats.get(5), stats.get(6));
            }
        }).start();
    }

    public void endGame(Boolean flag) throws IOException {
        cli.addMessage("Game Over");

        cli.stop();

        gameTime.stop();
        int timePoints = gameTime.getTimePoints();
        countryPanel.stop();
        gameTime.stop();
        moneyCounter.stop();


        if(flag){
            controller.openMenu();
            frame.dispose();
            return;
        }

        String input = JOptionPane.showInputDialog(
                null,
                "NICKNAME",
                "ANTIPLAGUE",
                JOptionPane.QUESTION_MESSAGE
        );

        if (input != null) {
            controller.updateLeaderBoard(input, timePoints);
            this.frame.dispose();
        }

    }
    @Override
    public void run() {
        makeGame();
        }


        // ANIMATIONS

    public void triggerAnimation(String countryName1, String countryName2, String transport) {

        String[] countries = {"nauru", "lechia", "district_x", "china", "kaedwen", "tuvalu", "slaka", "korea", "ulthar", "skellige"};


        if (Arrays.asList(countries).contains(countryName1) && Arrays.asList(countries).contains(countryName2)) {
            JButton country1Button = getCountryButton(countryName1);
            JButton country2Button = getCountryButton(countryName2);


            if (country1Button != null && country2Button != null) {
                performAnimation(country1Button.getX() + country1Button.getWidth() / 2,
                        country1Button.getY() + country1Button.getHeight() / 2,
                        country2Button.getX() + country2Button.getWidth() / 2,
                        country2Button.getY() + country2Button.getHeight() / 2,
                        transport
                );
            }
        }
    }


    public void performAnimation(int x1, int y1, int x2, int y2, String transport){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int x = x1;
                int y = y1;

                JPanel panel = new transportPanel("transportIcons/" + transport + ".png");
                layeredPane.add(panel, Integer.valueOf(7));
                panel.setBounds(x,y,50,50);

                int frames = 100;


                double dx = (double) (x2 - x) / frames;
                double dy = (double) (y2 - y) / frames;




                while(Math.abs(x - x2) > 100 || Math.abs(y - y2) > 100){

                    x += dx;
                    y += dy;

                    panel.setBounds(x,y,50,50);
                    panel.repaint();


                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                layeredPane.remove(panel);
                layeredPane.repaint();



                System.out.println("Animation Complete.");
            }
        }).start();
    }





    private JButton getCountryButton(String countryName) {
        switch (countryName) {
            case "nauru":
                return nauru;
            case "lechia":
                return lechia;
            case "district_x":
                return district_x;
            case "china":
                return china;
            case "kaedwen":
                return kaedwen;
            case "tuvalu":
                return tuvalu;
            case "slaka":
                return slaka;
            case "korea":
                return korea;
            case "ulthar":
                return ulthar;
            case "skellige":
                return skellige;
            default:
                return null;
        }
    }








    }

