package ANTIPLAGUE.panel;

import ANTIPLAGUE.controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class UpgradePanel extends JPanel implements Runnable {
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<Boolean> availability = new ArrayList<>();
    CLI cli;
    int[] priceArr ={9000,2000,3000,4000,5000,6000,7000,8000,1000};

    String country;
    Controller controller;
    MoneyCounter moneyCounter;

    public UpgradePanel(Controller controller, MoneyCounter moneyCounter) {
        this.controller = controller;
        this.moneyCounter = moneyCounter;
    }



    JButton vaccinesButton = new JButton(new ImageIcon("Icons/vaccine.png"));
    JButton curfewButton = new JButton(new ImageIcon("Icons/curfew.png"));
    JButton borderClosingButton = new JButton(new ImageIcon("Icons/stop.png"));
    JButton masksButton = new JButton(new ImageIcon("Icons/mask.png"));
    JButton advancedLabButton = new JButton(new ImageIcon("Icons/lab.png"));
    JButton enteringPermissionButton = new JButton(new ImageIcon("Icons/permit.png"));
    JButton researchGrantButton = new JButton(new ImageIcon("Icons/researchGrant.png"));
    JButton schoolsClosingButton = new JButton(new ImageIcon("Icons/schoolsClosed.png"));
    JButton infoSpreadingButton = new JButton(new ImageIcon("Icons/infoSpreading.png"));


    JLabel vaccinesLabel = new JLabel("VACCINES");
    JLabel curfewLabel = new JLabel("CURFEW");
    JLabel borderClosingLabel = new JLabel("BORDER CLOSING");
    JLabel masksLabel = new JLabel("MASKS");
    JLabel advancedLabLabel = new JLabel("ADVANCED LAB");
    JLabel enteringPermissionLabel = new JLabel("ENTERING PERMISSION");
    JLabel researchGrantLabel = new JLabel("RESEARCH GRANT");
    JLabel schoolsClosingLabel = new JLabel("SCHOOLS CLOSING");
    JLabel infoSpreadingLabel = new JLabel("AWARENESS INCREASING");


    JLabel price1 = new JLabel("9000");
    JLabel price2 = new JLabel("2000");
    JLabel price3 = new JLabel("3000");
    JLabel price4 = new JLabel("4000");
    JLabel price5 = new JLabel("5000");
    JLabel price6 = new JLabel("6000");
    JLabel price7 = new JLabel("7000");
    JLabel price8 = new JLabel("8000");
    JLabel price9 = new JLabel("1000");




    @Override
    public void run() {

        buttons.add(vaccinesButton);
        buttons.add(curfewButton);
        buttons.add(borderClosingButton);
        buttons.add(masksButton);
        buttons.add(advancedLabButton);
        buttons.add(enteringPermissionButton);
        buttons.add(researchGrantButton);
        buttons.add(schoolsClosingButton);
        buttons.add(infoSpreadingButton);


        for (int i = 0; i < 9; i++) {
            buttons.get(i).setName(String.valueOf(i));
        }


        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));



        this.add(vaccinesButton);
        this.add(curfewButton);
        this.add(borderClosingButton);
        this.add(masksButton);
        this.add(advancedLabButton);
        this.add(enteringPermissionButton);
        this.add(researchGrantButton);
        this.add(schoolsClosingButton);
        this.add(infoSpreadingButton);



        setButton(vaccinesButton, vaccinesLabel, price1);
        setButton(curfewButton, curfewLabel, price2);
        setButton(borderClosingButton, borderClosingLabel, price3);
        setButton(masksButton, masksLabel, price4);
        setButton(enteringPermissionButton, enteringPermissionLabel, price5);
        setButton(researchGrantButton, researchGrantLabel, price6);
        setButton(advancedLabButton, advancedLabLabel, price7);
        setButton(schoolsClosingButton, schoolsClosingLabel, price8);
        setButton(infoSpreadingButton, infoSpreadingLabel, price9);


        this.add(vaccinesLabel);
        this.add(curfewLabel);
        this.add(borderClosingLabel);
        this.add(masksLabel);
        this.add(enteringPermissionLabel);
        this.add(researchGrantLabel);
        this.add(schoolsClosingLabel);
        this.add(infoSpreadingLabel);
        this.add(advancedLabLabel);

        this.add(price1);
        this.add(price2);
        this.add(price3);
        this.add(price4);
        this.add(price5);
        this.add(price6);
        this.add(price7);
        this.add(price8);
        this.add(price9);



        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int panelWidth = getWidth();
                int panelHeight = getHeight();

                vaccinesButton.setIcon(scaleIcon("Icons/vaccine.png", panelWidth / 16, panelHeight / 16));
                curfewButton.setIcon(scaleIcon("Icons/curfew.png", panelWidth / 16, panelHeight / 16));
                borderClosingButton.setIcon(scaleIcon("Icons/stop.png", panelWidth / 16, panelHeight / 16));
                masksButton.setIcon(scaleIcon("Icons/mask.png", panelWidth / 16, panelHeight / 16));
                advancedLabButton.setIcon(scaleIcon("Icons/lab.png", panelWidth / 16, panelHeight / 16));
                enteringPermissionButton.setIcon(scaleIcon("Icons/permit.png", panelWidth / 16, panelHeight / 16));
                researchGrantButton.setIcon(scaleIcon("Icons/researchGrant.png", panelWidth / 16, panelHeight / 16));
                schoolsClosingButton.setIcon(scaleIcon("Icons/schoolsClosed.png", panelWidth / 16, panelHeight / 16));
                infoSpreadingButton.setIcon(scaleIcon("Icons/infoSpreading.png", panelWidth / 16, panelHeight / 16));


                vaccinesButton.setBounds(panelWidth/14 , panelHeight/6 - panelHeight / 8, panelWidth / 8, panelHeight / 8);
                curfewButton.setBounds(panelWidth/14, (panelHeight/2) - panelHeight / 5, panelWidth / 8, panelHeight / 8);
                borderClosingButton.setBounds(panelWidth/14, (panelHeight/2) + (panelHeight/4) - panelHeight / 6, panelWidth / 8, panelHeight / 8);
                masksButton.setBounds(panelWidth/2 - panelWidth / 16 , (panelHeight/6) - panelHeight / 8, panelWidth / 8, panelHeight / 8);
                advancedLabButton.setBounds(panelWidth/2 - panelWidth / 16, (panelHeight/2) - panelHeight / 5, panelWidth / 8, panelHeight / 8);
                enteringPermissionButton.setBounds(panelWidth/2 - panelWidth / 16, (panelHeight/2) + (panelHeight/4) - panelHeight / 6, panelWidth / 8, panelHeight / 8);
                researchGrantButton.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3, panelHeight/6 - panelHeight / 8, panelWidth / 8, panelHeight / 8);
                schoolsClosingButton.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3, (panelHeight/2) - panelHeight / 5, panelWidth / 8, panelHeight / 8);
                infoSpreadingButton.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3 , (panelHeight/2) + (panelHeight/4) - panelHeight / 6, panelWidth / 8, panelHeight / 8);


                vaccinesLabel.setBounds(panelWidth/14 , vaccinesButton.getY()+vaccinesButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price1.setBounds(panelWidth/14 , vaccinesButton.getY()+vaccinesButton.getHeight()+ panelHeight/40, panelWidth / 8, panelHeight / 8);

                curfewLabel.setBounds(panelWidth/14 , curfewButton.getY()+curfewButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price2.setBounds(panelWidth/14 , curfewButton.getY()+curfewButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);

                borderClosingLabel.setBounds(panelWidth/14 , borderClosingButton.getY()+borderClosingButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price3.setBounds(panelWidth/14 , borderClosingButton.getY()+borderClosingButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);

                masksLabel.setBounds(panelWidth/2 - panelWidth / 16 , masksButton.getY()+masksButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price4.setBounds(panelWidth/2 - panelWidth / 16 , masksButton.getY()+masksButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);

                advancedLabLabel.setBounds(panelWidth/2 - panelWidth / 16 , advancedLabButton.getY()+advancedLabButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price5.setBounds(panelWidth/2 - panelWidth / 16 , advancedLabButton.getY()+advancedLabButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);

                enteringPermissionLabel.setBounds(panelWidth/2 - panelWidth / 16 , enteringPermissionButton.getY()+enteringPermissionButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price6.setBounds(panelWidth/2 - panelWidth / 16 , enteringPermissionButton.getY()+enteringPermissionButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);

                researchGrantLabel.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3 , researchGrantButton.getY()+researchGrantButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price7.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3 , researchGrantButton.getY()+researchGrantButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);

                schoolsClosingLabel.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3 , schoolsClosingButton.getY()+schoolsClosingButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price8.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3 , schoolsClosingButton.getY()+schoolsClosingButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);

                infoSpreadingLabel.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3 , infoSpreadingButton.getY()+infoSpreadingButton.getHeight(), panelWidth / 8, panelHeight / 8);
                price9.setBounds(panelWidth/2 - panelWidth / 16 + panelWidth/3 , infoSpreadingButton.getY()+infoSpreadingButton.getHeight()+panelHeight/40, panelWidth / 8, panelHeight / 8);


            }
        });



    }

    public void setAvaiability(ArrayList<Boolean> avaiability){
        this.availability = avaiability;

       for (int i = 0; i < 9; i++){
           if(avaiability.get(i)){
               buttons.get(i).setBackground(new Color(0, 210, 0));
           }
           else{ buttons.get(i).setBackground(new Color(210, 0, 0));}
       }
    }


    private void setButton(JButton button, JLabel label, JLabel price) {
        label.setFont(new Font("Serif", Font.BOLD, 10));
        label.setForeground(new Color(255, 215, 0));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        price.setFont(new Font("Serif", Font.BOLD, 10));
        price.setForeground(new Color(255, 215, 0));
        price.setHorizontalAlignment(SwingConstants.CENTER);
        price.setVerticalAlignment(SwingConstants.CENTER);


        button.setBackground(new Color(255, 0, 0));
        button.setBorder(new LineBorder(Color.ORANGE, 5));
        button.setFocusPainted(false);

       button.addMouseListener(new MouseAdapter() {

           public void mousePressed(MouseEvent e) {


               if(Objects.equals(button.getBackground(), new Color(210, 0, 0))){
                   if(moneyCounter.getMoney() < priceArr[Integer.parseInt(button.getName())]){
                   }else{
                       button.setBackground(new Color(0, 210, 0));
                       controller.updateUpgrade(country, Integer.parseInt(button.getName()));
                       moneyCounter.changeMoney( -(priceArr[Integer.parseInt(button.getName())]));

                       cli.addMessage("You bought an upgrade !!!");

                   }
               }

           }
       });
    }

    private ImageIcon scaleIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }


    public void setCountry(String country){
        this.country = country;
    }

    public void setCli(CLI cli){
        this.cli = cli;
    }



}
