/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace;

import horserace.Model.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author furrki
 */
public class HorseRace {

    /**
     * @param args the command line arguments
     */
    private static Game game = new Game();
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("Paraniz: " + game.user.money + "₺");
            System.out.println(game.getHorsesInfo());
            
            System.out.print("Kac ₺ yatiracaksiniz?");
            int userMoney = scanner.nextInt();
            
            System.out.print("Hangi ati seciyorsunuz? [1-2-3]");
            int userSelection = scanner.nextInt();
            
            game.userInvest(userMoney, userSelection - 1);
            String winnerHorseName = game.play();
            
            System.out.println(winnerHorseName + " Kazandi!");
                   
        }
    }
    
}
