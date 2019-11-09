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
    
    public void randomizeStats(){
        health = gen.nextInt(76) + 100;
        attack = gen.nextInt();
        speed = gen.nextInt();
        defense = gen.nextInt();
        criticalChance = gen.nextInt();
    }
    
}
