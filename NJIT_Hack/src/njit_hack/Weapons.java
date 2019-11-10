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
class tempWeapon {
    private String name = "";
    private int attackDamage = 0;
    private boolean isEquipped = false;

    protected String get_Name() {
        return name;
    }

    protected int get_attackDamage() {
        return attackDamage;
    }

    protected void set_equipped(boolean isEquipped) {
        this.isEquipped = isEquipped;
    }

    protected boolean get_equipped() {
        return isEquipped;
    }
}
