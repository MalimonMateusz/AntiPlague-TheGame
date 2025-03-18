package ANTIPLAGUE.model;

import ANTIPLAGUE.controller.Controller;

import java.io.*;
import java.util.*;

public class Model implements Runnable {

    Controller controller;
    HashMap<String, Country> countries = new HashMap<>();
    int tickTime;
    boolean running;
    double virusSpread;
    Random rand = new Random();
    int newMoney = 0;
    int difficultyRatio;
    int virusStoppedCountries = 0;
    int noVirusCountries = 0;
    private static final String FILE_PATH = "leaderboard.txt";



    public Model(){
        countries.put("nauru", new Country("nauru", 170000, "Flags/nauruFlag.jpg", false, true, true, 0.4,0.5,0.6));
        countries.put("tuvalu", new Country("tuvalu", 100000, "Flags/tuvaluFlag.png", false, true, true, 0.4,0.5,0.6));
        countries.put("slaka", new Country("slaka", 70000, "Flags/slakaFlag.jpg", true, true, false, 0.4,0.5,0.6));
        countries.put("lechia", new Country("lechia", 1000000, "Flags/lechiaFlag.png", true, false, true, 0.4,0.5,0.6));
        countries.put("district x", new Country("district x", 1200000, "Flags/districtxFlag.png", true, true, false, 0.3,0.5,0.6));
        countries.put("kaedwen", new Country("kaedwen", 750000, "Flags/kaedwenFlag.png", false, true, true, 0.4,0.5,0.6));
        countries.put("china", new Country("china", 500000, "Flags/chinaFlag.png", true, true, true, 0.4,0.6,0.6));
        countries.put("korea", new Country("korea", 340000, "Flags/koreaFlag.png", true, true, true, 0.4,0.5,0.7));
        countries.put("ulthar", new Country("ulthar", 400000, "Flags/ultharFlag.png", true, false, false, 0.4,0.5,0.9));
        countries.put("skellige", new Country("skellige", 80000, "Flags/skelligeFlag.png", true, false, true, 0.4,0.5,0.5));
        this.running = true;
    }

    public void setDifficulty(int difficulty){


        if(difficulty == 1){
            tickTime = 2000;
            virusSpread = 5;
            this.difficultyRatio = 2;

        }else{
            this.difficultyRatio = 1;
            tickTime = 3000;
            virusSpread = 3;
        }
    }



    public ArrayList<String> getStats(String countryName){
        ArrayList<String> stats = countries.get(countryName).getStats();

        stats.add(String.valueOf(newMoney));
        newMoney = 0;
        return stats;
    }

    public ArrayList<String> getUpgrades(String countryName){
        return countries.get(countryName).getUpgrades();
    }

    public void upgradeBoutght(String countryName, int upgrade){

        countries.get(countryName).upgrades++;


        if (upgrade == 0) {
            countries.get(countryName).vaccines = true;
        } else if (upgrade == 1) {
            countries.get(countryName).curfew = true;
        } else if (upgrade == 2) {
            countries.get(countryName).borderClosing = true;
        } else if (upgrade == 3) {
            countries.get(countryName).masks = true;
        } else if (upgrade == 4) {
            countries.get(countryName).advancedLab = true;
        } else if (upgrade == 5) {
            countries.get(countryName).enteringPermission = true;
        } else if (upgrade == 6) {
            countries.get(countryName).researchGrant = true;
        } else if (upgrade == 7) {
            countries.get(countryName).schoolsClosing = true;
        } else if (upgrade == 8) {
            countries.get(countryName).infoSpreading = true;
        }
    }


    public void setController(Controller controller){
        this.controller = controller;
    }

    @Override
    public void run() {
        countries.get("china").infected = 1;





//        vaccines;  1            PRZYSPIESZA LECZENIE CHORYCH
//        curfew;    0             ZMNIEJSZA ILOSC ZARAZEN
//        borderClosing;          BRAK ZARAZEN Z INNYCH KRAJOW
//        masks;       0           ZMNIEJSZA ILOSC ZARAZEN
//        advancedLab; 1            ZWIEKSZA ILOSC WYLECZONYCH
//        enteringPermission;     ZMNIEJSZA ILOSC ZARAZONYCH Z INNYCH KRAJOW
//        researchGrant; 0         ZWIEKSZA ILOSC LECZONYCH
//        schoolsClosing; 0         ZMNIEJSZA ILOSC ZARAZEN
//        InfoSpreading;  0        ZMNIEJSZA ILOSC ZARAZEN


        while(running){
            try {
                int gameEnd = 0;
                for(String key : countries.keySet() ){
                 Country country =  countries.get(key);

                 if(country.infected == 0){
                     this.noVirusCountries++;
                 }


                 if(country.upgrades == 5 ){
                     if(!country.infectionStopped){
                         controller.newAnnoucment("VIRUS STOPPED SPREADING IN " + country.name);
                         country.infectionStopped = true;
                         virusStoppedCountries++;

                         if(country.vaccines){
                             int recovered = (int) (country.infected* 0.3);
                             country.infected -= recovered;
                             country.recovered += recovered;
                         }else{
                             int recovered = (int) (country.infected* 0.1);
                             country.infected -= recovered;
                             country.recovered += recovered;
                         }

                         int dead = (int) (country.infected* 0.08);
                         country.population -= dead;
                         country.dead += dead;



                     }
                    }else{
                     // ZARAŻENIA I LECZENIE W KRAJU  + OBOSTRZENIA A PROPOS TRANSPORTU
                     if(country.infected > 0 && country.infected <= country.population){

                         System.out.println(country.healthy /country.population + "/" + country.population);
                         if(((double) country.healthy /country.population  <= country.aeroplaneRestrictionRequirement)  && !country.aeroplaneRestriction){

                             System.out.println((double) country.infected / (double) country.population);
                             country.aeroplaneRestriction = true;
                             controller.newAnnoucment(country.name + " restricts aeroplanes");

                             System.out.println(country.name + " restricts aeroplanes");
                         }
                         if((double) country.healthy /country.population <= country.carRestrictionRequirement && !country.carRestriction ){
                             country.carRestriction = true;
                             controller.newAnnoucment(country.name + " restricts cars");
                             System.out.println(country.name + " restricts aeroplanes");

                         }
                         if((double) country.healthy /country.population <= country.shipRestrictionRequirement && !country.shipRestriction ){
                             country.shipRestriction = true;
                             controller.newAnnoucment(country.name + " restricts ships");
                             System.out.println(country.name + " restricts aeroplanes");

                         }



                         double spreadRatio = 0;
                         double recoveryRatio = 0;


                         if(country.curfew) spreadRatio++;
                         if(country.masks) spreadRatio+=2;
                         if(country.schoolsClosing) spreadRatio++;
                         if(country.infoSpreading) spreadRatio++;

                         if(country.vaccines) recoveryRatio++;
                         if(country.researchGrant) recoveryRatio++;
                         if(country.advancedLab) recoveryRatio++;

                         int infected = 0;
                         int recovery = (int) ( country.infected * (0.0 + recoveryRatio/100));

                         newMoney += recovery *7;

                         int dead = (int) (country.infected * 0.01);

                         if(country.vaccines){
                             dead = (int) (dead*0.75);
                         };



                         if((country.infected > 0) && (country.infected < country.population)){
                             infected +=((int) ((double) country.infected * (0.3-spreadRatio/20)))+1; //*0.3
                             country.infected += infected;
                         }


                         if(country.infected > country.population){
                             country.infected = country.population;
                         }



                         country.healthy -= infected;
                         country.recovered += recovery;
                         country.infected -= recovery;


                         if(country.healthy < 0) dead *=3;

                         country.dead += dead;
                         country.population -= dead;

                         if(country.healthy < 0){
                             country.healthy = 0;
                         }

                     }

                     // Warunek Końca Gry
                     if(country.healthy == 0){
                         gameEnd++;
                     }






                     for(String key2 : countries.keySet()){


                         if(!key.equals(key2) &&  country.infected > 0){
                             Country temp2 = countries.get(key2);


                             System.out.println(country.aeroplanes+ " " + temp2.aeroplanes + " "+ !country.aeroplaneRestriction + " "+ !temp2.aeroplaneRestriction  );


                             if((country.aeroplanes && temp2.aeroplanes && !country.aeroplaneRestriction && !temp2.aeroplaneRestriction)){


                                 if(temp2.borderClosing){
                                     // jezeli wykupiono borderClosing, osoby chore z innych panstw nie przychodza
                                 }
                                 else if(temp2.enteringPermission){
                                     if(rand.nextInt(0,300) <= virusSpread ){
                                         temp2.infected++;

                                         if( countries.get(key2).infected == 1){
                                             controller.newAnnoucment("Virus spreaded to " + key2);
                                         }

                                     }
                                 }else{

                                     if(rand.nextInt(0,150) <= virusSpread ){
                                         countries.get(key2).infected++;
                                         controller.triggerAnimation(country.name, temp2.name, "aeroplane"); // TEST
                                         if( countries.get(key2).infected == 1){
                                             controller.newAnnoucment("Virus spreaded to " + key2);
                                         }
                                     }
                                 }


                             }else if((country.cars && temp2.cars && !country.carRestriction && !temp2.carRestriction)){
                                 if(temp2.borderClosing){
                                     // jezeli wykupiono borderClosing, osoby chore z innych panstw nie przychodza
                                 }
                                 else if(temp2.enteringPermission){
                                     if(rand.nextInt(0,300) <= virusSpread ){
                                         temp2.infected++;

                                         if( countries.get(key2).infected == 1){
                                             controller.newAnnoucment("Virus spreaded to " + key2);
                                         }

                                     }
                                 }else{

                                     if(rand.nextInt(0,150) <= virusSpread ){
                                         temp2.infected += 50;
                                         System.out.println("carrrrrr");
                                         controller.triggerAnimation(country.name, temp2.name, "car"); // TEST
                                         if( countries.get(key2).infected == 50){
                                             controller.newAnnoucment("Virus spreaded to " + key2);
                                         }
                                     }
                                 }


                             }else if( country.ships && temp2.ships && !country.shipRestriction && !temp2.shipRestriction){
                                 if(temp2.borderClosing){
                                     // jezeli wykupiono borderClosing, osoby chore z innych panstw nie przychodza
                                 }
                                 else if(temp2.enteringPermission){
                                     if(rand.nextInt(0,300) <= virusSpread ){
                                         temp2.infected += 50;

                                         if( countries.get(key2).infected == 50){
                                             controller.newAnnoucment("Virus spreaded to " + key2);
                                         }

                                     }
                                 }else{

                                     if(rand.nextInt(0,150) <= virusSpread ){
                                         temp2.infected += 50;
                                         controller.triggerAnimation(country.name, temp2.name, "ship"); // TEST
                                         if( countries.get(key2).infected == 50){
                                             controller.newAnnoucment("Virus spreaded to " + key2);
                                         }
                                     }
                                 }
                             }






                         }
                     }

                 }







                }

                if((gameEnd + virusStoppedCountries + noVirusCountries) == 10){
                    this.running = false;
                    controller.endGame(false);
                }
                noVirusCountries = 0;

                Thread.sleep(tickTime+1000);
                controller.updateInfo();



            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public void updateLeaderBoard(String playerNickname, int timePoints) throws IOException {
        int points = 0;
        for(String key : countries.keySet() ) {
        ArrayList<String> stats = countries.get(key).getStats();

        points += Integer.parseInt(stats.get(6)) *1000;
        points -= Integer.parseInt(stats.get(5)) *10;

        points -= timePoints;
            for (int i = 7; i <16 ; i++) {
                if(Boolean.parseBoolean(stats.get(i))){
                    points += 1000;
                }

            }




        }

        if(points < 0) points = 1;   //na zachetę jezeli ktos jest slaby

        points = points * difficultyRatio;
        checkAndReplace(points, playerNickname);
        controller.openMenu();
    }


    public static void checkAndReplace(int points, String playerName) throws IOException {
        List<Player> leaderboard = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 10) {
                String[] parts = line.split(" ", 2);
                if (parts.length == 2) {
                    try {
                        int currentPoints = Integer.parseInt(parts[0]);
                        String currentName = parts[1];
                        leaderboard.add(new Player(currentPoints, currentName));
                        count++;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in file: " + line);
                    }
                } else {
                    System.err.println("Invalid line format in file: " + line);
                }
            }
        }


        leaderboard.add(new Player(points, playerName));


        leaderboard.sort((p1, p2) -> Integer.compare(p2.points, p1.points));


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            int count = 0;
            for (Player player : leaderboard) {
                if (count >= 10) break;
                writer.write(player.points + " " + player.name);
                writer.newLine();
                count++;
            }
        }

    }


    static class Player {
        int points;
        String name;

        Player(int points, String name) {
            this.points = points;
            this.name = name;
        }
    }
}








