/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace.Model;

/**
 *
 * @author furrki
 */
public class User {
    public int money;
  
    public User(int money) {
        this.money = money;
    }
    
    public void takeMoney(int amount) {
        this.money -= amount;
    }
    
    public void giveMoney(int amount) {
        this.money += amount;
    }
}
