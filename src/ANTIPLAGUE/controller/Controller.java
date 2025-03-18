package ANTIPLAGUE.controller;

import ANTIPLAGUE.model.Model;
import ANTIPLAGUE.view.GameFrame;
import ANTIPLAGUE.view.LeaderBoardFrame;
import ANTIPLAGUE.view.MenuFrame;
import ANTIPLAGUE.view.View;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    Model model;
    View view;

    public Controller(Model model) {
        this.model = model;
        SwingUtilities.invokeLater(() -> {
            this.view = new MenuFrame(this);
            this.view.run();
        });
        this.model.setController(this);
    }






    // VIEW
    public void exitPressed() {
        System.exit(0);
    }

    public void highScorePressed() {
        SwingUtilities.invokeLater(() -> {
            this.view = new LeaderBoardFrame(this);
            this.view.run();
        });
    }
    public void returnPressed() {
        SwingUtilities.invokeLater(() -> {
            this.view = new MenuFrame(this);
            this.view.run();
        });
    }

    public void startNewGamePressed(String dificulty) {

        if(dificulty.equals("Hard")) model.setDifficulty(1);
        else if(dificulty.equals("Normal")) model.setDifficulty(0);

        SwingUtilities.invokeLater(() -> {
            this.view = new GameFrame(this);
            this.view.run();
        });

        Thread thread = new Thread(model);
        thread.start();
    }


    // MODEL

    public ArrayList<String> getCountryStats(String countryName) {
        ArrayList<String> countryStats = model.getStats(countryName);
        return countryStats;
    }



    public void newAnnoucment(String announcement) {
        this.view.newAnnouncement(announcement);
    }

    public void updateInfo(){
        view.updateInfo();
    }

    public ArrayList<String> getUpgradeInfo(String countryName) {
        return model.getUpgrades(countryName);
    }

    public void updateUpgrade(String countryName, int upgrade) {
        model.upgradeBoutght(countryName, upgrade);
    }

    public void endGame(Boolean flag) throws IOException {
        view.endGame(flag);
    }

    public void updateLeaderBoard(String playerNickname, int timePoints) throws IOException {
        model.updateLeaderBoard(playerNickname,timePoints);
    }

    public void openMenu(){

        this.model = new Model();
        this.model.setController(this);

        SwingUtilities.invokeLater(() -> {
            this.view = new MenuFrame(this);
            this.view.run();
        });
        this.model.setController(this);
    }


    public void triggerAnimation(String countryName1, String countryName2, String transport) {
        this.view.triggerAnimation(countryName1, countryName2, transport);
    }

}
