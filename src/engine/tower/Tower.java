package engine.tower;

import java.util.List;
import engine.Type;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.weapon.Weapon;


public interface Tower extends Type {

    void addUpgrade (Integer upgrade);

    void removeUpgrade (Integer upgrade);

    List<Integer> getUpgrades ();

    void addWeapon (Integer weapon);

    void removeWeapon (Integer weapon);

    List<Integer> getWeapons ();

    void removeEnemy (Integer target);

    void addTarget (Integer target);

    List<Integer> getTargets ();

    void removeAbility (Integer ability);

    void addAbility (Integer ability);

    List<Integer> getAbilities ();

    double getCost ();

    void setCost (double cost);

    double getSellAmount ();

    void setSellAmount (double sellAmount);

    int getUnlockLevel ();

    void setUnlockLevel (int unlockLevel);

}
