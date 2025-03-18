package ANTIPLAGUE.panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CLI extends JPanel implements Runnable {

    private boolean running = true;
    private final ArrayList<String> messages = new ArrayList<>();
    private static final int MAX_MESSAGES = 10;

    public CLI() {
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    }

    public void addMessage(String message) {
        if (messages.size() >= MAX_MESSAGES) {
            messages.remove(0);
        }
        messages.add(message);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.setFont(new Font("Courier New", Font.BOLD, 22));


        int yPosition = 20;

        ArrayList<String> messages2 = (ArrayList<String>) messages.clone();
        for (String message : messages2) {
            g.drawString(message, 10, yPosition);
            yPosition += 20;
        }
    }

    @Override
    public void run() {
        while (running) {
            SwingUtilities.invokeLater(this::repaint);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
