package Characters;
import java.util.Random;

import Enemies.Enemy;

import java.text.DecimalFormat;

public abstract class Character {
    Random rand = new Random();

    private String name;
    private int currentHp;
    private int maxHp;
    private int currentEnergy;
    private int maxEnergy = 100;
    private int attack;
    private int level;
    private int exp;
    private double money = 10;
    private int hotDog;
    private int riceToppings;
    private int water;
    private int mountainDew;
    private int skill1CD;
    private int skill2CD;
    private int skill3CD;

    public Character(String name, int hp, int energy, int attack, int level, int exp, double money, int skill1CD, int skill2CD, int skill3CD) {
        this.name = name;
        this.currentHp = hp;
        this.maxHp = hp;
        this.currentEnergy = energy;
        this.maxEnergy = energy;
        this.attack = attack;
        this.level = 1;
        this.exp = 0;
        this.money = money;
        this.skill1CD = skill1CD;
        this.skill2CD = skill2CD;
        this.skill3CD = skill3CD;
    }

    // player stats

    public int getDamage(){
        return attack;
    }
    public boolean isAlive() { 
        return currentHp > 0;
    }

    public void takeDamage(int amount){
        currentHp = Math.max(0, currentHp - amount);
    }

    public void heal(int amount) {
        currentHp = Math.min(maxHp, currentHp +  amount);
    }

    public void addExp(int exp){
        this.exp += exp;
    }

    public void addEnergy(int amount) {
        currentEnergy = Math.max(0, Math.min(maxEnergy, currentEnergy + amount));
    }


    public void setExp(int exp){
        this.exp = exp;
    }

    public void levelUp() {
        level++;
        maxHp += 10;
        currentHp = maxHp;
        attack += 5;
        System.out.println(getName() + " Leveled up!");
        currentEnergy = maxEnergy;
        exp -= 50;
    }

    public void rest(){
        currentEnergy = Math.min(maxEnergy, currentEnergy + 20);
        currentHp = Math.min(maxHp, currentHp + 15);
        
    }
    public void addMoney(double amount){
        this.money += amount;
    }
    public void useMoney(double amount){
        this.money -= amount;
    }

    // ---

    // --- canteen og items ---
    public void addHotDog(int amount){
        this.hotDog += amount;
    }
    public void addRiceToppings(int amount){
        this.riceToppings += amount;
    }
    public void addWater(int amount){
        this.water += amount;
    }
    public void addMountainDew(int amount){
        this.mountainDew += amount;
    }

    public void useHotDog(){
        heal(20);
        this.hotDog -= 1;
        System.out.println(name + " consumed hot dog, +20 HP" );
    }
    public void useRiceTopping(){
        heal(30);
        this.riceToppings -= 1;
        System.out.println(name + " consumed rice Topping, +20 HP" );
    }
    public void useWater(){
        addEnergy(15);
        this.water -= 1;
        System.out.println(name + " consumed water, +20 energy" );
    }
    public void useMountainDew(){
        addEnergy(30);
        this.mountainDew -= 1;
        System.out.println(name + " consumed mountain dew, +30 energy" );
    }


    //--

    public String getName() { 
        return name; 
    }
    public int getHp() { 
        return currentHp; 
    }
    public int getMaxHp() { 
        return maxHp; 
    }
    public int getAttack() { 
        return attack;
    }
    public int getLevel() { 
        return level; 
    }
    public int getExp() {
        return exp; 
    }

    //Getters for money and items kay private sila then wala ka create og getters 
    public double getMoney(){
        return money;
    }

    public int getMaxEnergy() {
    return maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy){
        this.currentEnergy = currentEnergy;
    }

    public int getHotDog(){
        return hotDog;
    }
    public int getRiceToppings(){
        return riceToppings;
    }
    public int getWater(){
        return water;
    }
    public int getMountainDew(){
        return mountainDew;
    }


    public void showStats(){
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("  " + name + "'s' Stats ");
        System.out.println("  Level : " + level);
        System.out.println("  Exp   : " + getExp()+ "/50");
        System.out.println("  HP    : " + currentHp + "/" + maxHp);
        System.out.println("  Energy: " + currentEnergy + "/" + maxEnergy);
        System.out.println("╚══════════════════════════════════════════════════════╝");

    }

    public void displayStatus(){
        DecimalFormat df = new DecimalFormat("##,##0.00");

        System.out.println(name + " - HP: " + currentHp +  "/" + maxHp + " | Energy: " + currentEnergy + "/" + maxEnergy +
        " | level: " + level + " | exp: " + exp + " | Money: PHP " + df.format(money));

    }

    // cooldown 
    public int getSkill1CD() { return skill1CD; }
    public int getSkill2CD() { return skill2CD; }
    public int getSkill3CD() { return skill3CD; }

    public void setSKill1CD(int skill1CD){
        this.skill1CD = skill1CD;
    }
    public void setSKill2CD(int skill2CD){
        this.skill2CD = skill2CD;
    }
    public void setSKill3CD(int skill3CD){
        this.skill3CD = skill3CD;
    }

    public void reduceCooldowns(){
        if (skill1CD > 0) skill1CD--;
        if (skill2CD > 0) skill2CD--;
        if (skill3CD > 0) skill3CD--;
    }

    
    // skills
    public abstract void displaySkills();
    public abstract void useBasic(Enemy enemy);
    public abstract void useSkill1(Enemy enemy);
    public abstract void useSkill2(Enemy enemy);
    public abstract void useSkill3(Enemy enemy);

}























