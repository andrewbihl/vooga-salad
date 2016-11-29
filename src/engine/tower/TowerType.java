package engine.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import engine.AbstractType;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.enemy.EnemyType;
import engine.observer.ObservableProperty;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class TowerType extends AbstractType implements Tower {

    private ObservableProperty<List<Integer>> weapons;
    private ObservableProperty<List<Integer>> targets;
    private ObservableProperty<List<Integer>> abilities;
    private ObservableProperty<Integer> upgrade;
    private ObservableProperty<Double> cost;
    private ObservableProperty<Double> sellAmount;
    private ObservableProperty<Integer> unlockLevel;

    protected TowerType (TowerInitializer towerInitializer) {
        super(towerInitializer);
        this.upgrade = towerInitializer.getUpgrade();
        this.targets = towerInitializer.getTargets();
        this.weapons = towerInitializer.getWeapons();
        this.abilities = towerInitializer.getAbilities();
        this.cost = towerInitializer.getCost();
        this.sellAmount = towerInitializer.getSellAmount();
        this.unlockLevel = towerInitializer.getUnlockLevel();
    }

    @Override
    public void setUpgrade (int upgrade) {
        this.upgrade.setProperty(upgrade);
    }
    
    @Override
    public int getUpgrade () {
        return upgrade.getProperty();
    }

    @Override
    public void addWeapon (int weapon) {
        weapons.getProperty().add(weapon);
    }

    @Override
    public void removeWeapon (int weapon) {
        weapons.getProperty().removeIf(a -> a.equals(weapon));
    }

    @Override
    public List<Integer> getWeapons () {
        return Collections.unmodifiableList(weapons.getProperty());
    }

    @Override
    public void removeEnemy (int target) {
        targets.getProperty().removeIf(a -> a.equals(target));
    }

    @Override
    public void addTarget (int target) {
        targets.getProperty().add(target);
    }

    @Override
    public List<Integer> getTargets () {
        return Collections.unmodifiableList(targets.getProperty());
    }

    @Override
    public void removeAbility (int ability) {
        abilities.getProperty().removeIf(a -> a.equals(ability));
    }

    @Override
    public void addAbility (int ability) {
        abilities.getProperty().add(ability);
    }

    @Override
    public List<Integer> getAbilities () {
        return Collections.unmodifiableList(abilities.getProperty());
    }

    @Override
    public double getCost () {
        return cost.getProperty();
    }

    @Override
    public void setCost (double cost) {
        this.cost.setProperty(cost);;
    }

    @Override
    public double getSellAmount () {
        return sellAmount.getProperty();
    }

    @Override
    public void setSellAmount (double sellAmount) {
        this.sellAmount.setProperty(sellAmount);;
    }

    @Override
    public int getUnlockLevel () {
        return unlockLevel.getProperty();
    }

    @Override
    public void setUnlockLevel (int unlockLevel) {
        this.unlockLevel.setProperty(unlockLevel);;
    }
}