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
public class Weapons {
    
}
class Sword1 {

    String name = "Sword of Mediocrity";
    int AttackValue = 10;
    boolean equipped = false;

    protected String get_Name() {
        return name;
    }

    protected int get_Atk() {
        return AttackValue;
    }

    protected void set_equipped(boolean is) {
        equipped = is;
    }

    protected boolean get_equipped() {
        return equipped;
    }

}