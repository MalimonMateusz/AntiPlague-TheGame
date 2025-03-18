package ANTIPLAGUE.panel;

import javax.swing.*;
import java.awt.*;

public class GameTime implements Runnable {

    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);
    public JLabel timerPanel;
    boolean running = true;


    public GameTime() {
        this.timerPanel = new JLabel();
        this.timerPanel.setBounds(0,0,200,100);
        this.timerPanel.setFont(new Font("TimerRoman BOLD", Font.PLAIN, 35));
        this.timerPanel.setBackground(Color.BLACK);
        this.timerPanel.setForeground(Color.RED);
        this.timerPanel.setOpaque(true);
    }

    private void addSecond() {
        if (this.seconds == 59) {
            this.seconds = 0;
            this.minutes = this.minutes + 1;
            if (this.minutes > 59) {
                this.hours = this.hours + 1;
                this.minutes = 0;
            }
        }else{
            this.seconds++;
        }
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        try {
            while (running) {
                Thread.sleep(1000);
                addSecond();
                secondsString = String.format("%02d", seconds);
                minutesString = String.format("%02d", minutes);
                hoursString = String.format("%02d", hours);
                SwingUtilities.invokeLater(() -> timerPanel.setText(hoursString + ":" + minutesString + ":" + secondsString )); // Aktualizacja GUI
            }






        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    public int getTimePoints(){
        return hours * 10000 + minutes * 600 + seconds;
    }


}
