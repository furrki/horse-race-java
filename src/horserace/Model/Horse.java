/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace.Model;
import java.util.ArrayList;
/**
 *
 * @author furrki
 */
public class Horse {
    public String name;
    public int performance;
    
    public Horse(String name, int performance) {
        this.name = name;
        this.performance = performance;
    }
    
    public static ArrayList<Horse> getAllHorses() {
        ArrayList<Horse> horses = new ArrayList();
        
        horses.add(new Horse("Ruzgar Gulu", 8));
        horses.add(new Horse("Atesin Oglu", 6));
        horses.add(new Horse("Tasta Kosan", 7));
        horses.add(new Horse("Sutcu Beygiri", 2));
        horses.add(new Horse("Yavаs Oglu", 3));
        horses.add(new Horse("Gulen Docent", 5));
        
        return horses;
    }
    
    public double getBenefit(int totalPerformance) {
        return  (double)totalPerformance / (double)this.performance;
    }
}
