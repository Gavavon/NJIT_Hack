/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njit_hack;

/**
 *
 * @author Gavav
 */
public class PlayerStats {
    private int health;
    private int attack;
    private int speed;
    private int defense;
    private int criticalChance;
    
    public int getHealth() {
            return health;
    }
    public void setHealth(int health) {
            this.health = health;
    }
    public int getAttack() {
            return attack;
    }
    public void setAttack(int attack) {
            this.attack = attack;
    }
    public int getSpeed() {
            return speed;
    }
    public void setSpeed(int speed) {
            this.speed = speed;
    }
    public int getDefense() {
            return defense;
    }
    public void setDefense(int defense) {
            this.defense = defense;
    }
    public int getCriticalChance() {
            return criticalChance;
    }
    public void setCriticalChance(int criticalChance) {
            this.criticalChance = criticalChance;
    }
}
