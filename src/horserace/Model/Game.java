/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author furrki
 */
public class Game {
    public ArrayList<Horse> horses = new ArrayList();
    private final static int HORSE_COUNT = 5;
    private final Random random = new Random();
    public int userInvestmentAmount = 0;
    public int selectedHorseIndex = -1;
    public User user = new User(5000);
    
    public int totalPerformance = 0;
    
    public Game() {
        resetGame();
    }
    
    public void resetGame() {
        selectedHorseIndex = -1;
        userInvestmentAmount = 0;
        horses.clear();
        initHorses();
    }
    
    public void initHorses() {
        ArrayList<Horse> horsesFromInventory = Horse.getAllHorses();
        
        totalPerformance = 0;
        
        for(int i = 0; i < HORSE_COUNT; i++) {
            int randomHorseIndex = random.nextInt(horsesFromInventory.size());
            Horse horse = horsesFromInventory.get(randomHorseIndex);
            totalPerformance += horse.performance;
            this.horses.add(horse);
            horsesFromInventory.remove(randomHorseIndex);
        }
    }
    
    public void userInvest(int amount, int horseIndex) {
        if(horseIndex < 0 || horseIndex >= horses.size()) {
            return;
        }
        this.userInvestmentAmount = amount;
        this.selectedHorseIndex = horseIndex;
        user.takeMoney(amount);
    }
    
    public String play() {
        int winnerIndex = randomWinner();
        String winnerName = horses.get(winnerIndex).name;
        if(selectedHorseIndex == winnerIndex) {
            int paymentToUser = (int) ((double)userInvestmentAmount *  
                    horses.get(selectedHorseIndex).getBenefit(totalPerformance));
            user.giveMoney(paymentToUser);
        } else {
            resetGame();
        }    
        return winnerName;
    }
    
    private int randomWinner() {
        int randomNumberResult = random.nextInt(totalPerformance);
        int tempTotal = 0;
        for (int i = 0; i < horses.size(); i ++) {
            Horse horse = horses.get(i);
            tempTotal += horse.performance;
            if(tempTotal >= randomNumberResult) {
                return i;
            }
        }
        return 0;
    }
    
    public String getHorsesInfo() {
        String totalInfo = "";
        for(Horse horse: horses) {
            totalInfo += horse.name + " - " + horse.getBenefit(totalPerformance) + "\n";
        }
        return totalInfo;
    }
}
