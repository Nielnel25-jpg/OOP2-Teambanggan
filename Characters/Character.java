package Characters;
import Enemies.Enemy;
import java.text.DecimalFormat;
import java.util.Random;

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
    private double gold = 10;
    private int tanggo;
    private int clarity;
    private int bottle;
    private int HealingSalve;
    private int skill1CD;
    private int skill2CD;
    private int skill3CD;
    private int ultimate;

    public Character(String name, int hp, int energy, int attack, int level, int exp, double gold, int skill1CD, int skill2CD, int skill3CD, int ultimate) {
        this.name = name;
        this.currentHp = hp;
        this.maxHp = hp;
        this.currentEnergy = energy;
        this.maxEnergy = energy;
        this.attack = attack;
        this.level = 1;
        this.exp = 0;
        this.gold = gold;
        this.skill1CD = skill1CD;
        this.skill2CD = skill2CD;
        this.skill3CD = skill3CD;
        this.ultimate = ultimate;
        
    }
    public void setUltimate(int ultimate){
        this.ultimate = ultimate;
    }
    public int getUltimate(){
        return ultimate;
    }

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
        maxEnergy = Math.min(100, maxEnergy + 10);
        currentEnergy = maxEnergy;
        exp -= 50;
    }

    public void rest(){
        currentEnergy = Math.min(maxEnergy, currentEnergy + 20);
        currentHp = Math.min(maxHp, currentHp + 15);
        
    }
    public void addGold(double amount){
        this.gold += amount;
    }
    public void useGold(double amount){
        this.gold -= amount;
    }

   

    
    public void addTanggo(int amount){
        this.tanggo += amount;
    }

    public void addBottle(int amount){
        this.bottle += amount;
    }
    public void addClarity(int amount){
        this.clarity += amount;
    }
    public void addHealingSalve(int amount){
        this.HealingSalve += amount;
    }

    public void useTanggo(){
        heal(20);
        this.tanggo -= 1;
        System.out.println(name + " consumed tanggo, " + "+20 HP" );
    }
    public void useClarity(){
        heal(30);
        this.clarity -= 1;
        System.out.println(name + " consumed clarity, "  + "+30 HP");
    }
    public void useBottle(){
        addEnergy(15);
        this.bottle -= 1;
        System.out.println(name + " consumed bottle, " + "+15 energy" );
    }
    public void useHealingSalve(){
        heal(50);
        this.HealingSalve -= 1;
        System.out.println(name + " consumed healing salve, +50 HP" );
    }


    

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

    //Getters for gold and items kay private sila then wala ka create og getters 
    public double getGold(){
        return gold;
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

    public int getTanggo(){
        return tanggo;
    }
    public int getClarity(){
        return clarity;
    }
    public int getBottle(){
        return bottle;
    }
    public int getHealingSalve(){
        return HealingSalve;
    }


    public void showStats(){
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("  " + name + "'s Stats ");
        System.out.println("  Level : " + level);
        System.out.println("  Exp   : " + getExp()+ "/50");
        System.out.println("  HP    : "  + currentHp  + "/"  + maxHp);
        System.out.println("  Energy: " + currentEnergy + "/"  + maxEnergy );
        System.out.println("╚══════════════════════════════════════════════════════╝" );

    }

    public void displayStatus(){
        DecimalFormat df = new DecimalFormat("##,##0.00");

        System.out.println(name  + " - HP: "  + currentHp +  "/" + maxHp  + " | Energy: "  + currentEnergy + "/" + maxEnergy +
        " | level: " + level + " | exp: " + exp + " | Gold: "  + "PHP " + df.format(gold));

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
        if (ultimate > 0) ultimate--;
    }

    
    // skills
    public abstract void displaySkills();
    public abstract void useBasic(Enemy enemy);
    public abstract void useSkill1(Enemy enemy);
    public abstract void useSkill2(Enemy enemy);
    public abstract void useSkill3(Enemy enemy);
    public abstract void useUltimate(Enemy enemy);

    

}























