package ANTIPLAGUE.panel;

import javax.swing.*;
import java.awt.*;

public class MoneyCounter extends JPanel implements Runnable  {
    private int money = 0;
    private JLabel moneyLabel;
    boolean running = true;

    @Override
    public void run() {
        setLayout(new BorderLayout());

        setBackground(Color.BLACK);

        moneyLabel = new JLabel("Money: " + money, JLabel.CENTER);
        moneyLabel.setFont(new Font("Arial", Font.BOLD, 12));
        moneyLabel.setForeground(Color.GREEN);
        add(moneyLabel, BorderLayout.CENTER);
        money+= 3000;
        while (running) {

            try {
                Thread.sleep(2000);
                this.changeMoney(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public int getMoney() {
        return money;
    }

    public void changeMoney(int amount) {

        money += amount;
        moneyLabel.setText("Money: " + money);
        moneyLabel.repaint();
    }

    public void stop() {
        running = false;
    }

}
