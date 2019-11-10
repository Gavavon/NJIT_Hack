/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njit_hack;

import java.util.Random;

/**
 *
 * @author Gavav
 */
public class EnemeyStats {
    private int health;
    private int attack;
    private int speed;
    private int defense;
    private int criticalChance;
    
    public Random gen = new Random();
    
    public void randomizeStats(boolean hard){
        if(!hard){
            health = gen.nextInt(50) + 75;// min: 75 max: 125
            attack = gen.nextInt(12) + 12;
            speed = gen.nextInt();
            defense = gen.nextInt();
            criticalChance = gen.nextInt();
        }
        if(hard){
            health = gen.nextInt(76) + 100;
            attack = gen.nextInt();
            speed = gen.nextInt();
            defense = gen.nextInt();
            criticalChance = gen.nextInt();
        }
    }

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
