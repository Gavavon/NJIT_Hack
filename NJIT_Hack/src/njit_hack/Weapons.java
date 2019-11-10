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

    protected String getName() {
        return name;
    }

    protected int getAttackDamage() {
        return attackDamage;
    }

    protected void setEquipped(boolean isEquipped) {
        this.isEquipped = isEquipped;
    }

    protected boolean getEquipped() {
        return isEquipped;
    }
}
class Sword1{
    private String name = "Sword of dumb";
    private int attackDamage = 10;
    private boolean isEquipped = false;

    protected String getName() {
        return name;
    }

    protected int getAttackDamage() {
        return attackDamage;
    }

    protected void setEquipped(boolean isEquipped) {
        this.isEquipped = isEquipped;
    }

    protected boolean getEquipped() {
        return isEquipped;
    }
}
