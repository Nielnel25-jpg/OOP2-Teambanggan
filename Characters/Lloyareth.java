package Characters;
import Enemies.Enemy;
import java.io.*;

public class Lloyareth extends Character{

    
    public Lloyareth(){
        super("DrowRanger", 120, 40, 20, 1, 30, 50, 0, 0, 0);
    }

    @Override
    public void displaySkills(){
        System.out.println();
        System.out.println("0. Basic Attack(): Max Damage: " + getAttack() + " | Gain Energy: 30");
        System.out.println("1. Skill 1(ArayMoPakak): Max Damage: " + (getAttack() + 10) + " | Energy cost: 30 | Cooldown 2 round");
        System.out.println("2. SKill 2(NakoPo!): Max Damage: "+ (getAttack() + 20) + " | Energy cost: 20 | Cooldown 3 round");
        System.out.println("3. Skill 3(Markmanship): Max Damage: " + (getAttack() + 30) + " | Energy cost: 40 | Cooldown 3 rounds");
        System.out.println("4. Ultimate(KeyChain): Max Damage:" + (getAttack() + 50) + " | Energy cost: 50 | Cooldown 4 rounds");
        System.out.println();
    }

    @Override
    public void useBasic(Enemy enemy) {
        int dmg = getAttack();
        addEnergy(30);
        System.out.println(getName() + " used basic getAttack()");
        enemy.takeDamage(dmg); 
    }

    @Override
    public void useSkill1(Enemy enemy) {
        if (getSkill1CD() > 0){
            System.out.println("Skill on cooldown! Wait " + getSkill1CD() + " turn(s).");
            return;
        }
        if(getCurrentEnergy() < 30){
            System.out.println("Not enough energy!"); 
            return;
        }

        int dmg = rand.nextInt(10 - 5 + 1) + 5;
        setCurrentEnergy(getCurrentEnergy() - 30);
        System.out.println(getName() + " used ArayMoPakak! Damage is " + dmg);
        enemy.takeDamage(dmg + getAttack());

        setSKill1CD(2); // pila ang cooldown sa skill
    }

    @Override
    public void useSkill2(Enemy enemy) {
        if (getSkill2CD() > 0){
            System.out.println("Skill on cooldown! Wait " + getSkill2CD() + " turn(s).");
            return;
        }
        if(getCurrentEnergy() < 20){
            System.out.println("Not enough energy!"); 
            return;
        }

        int dmg = rand.nextInt(20 - 15 + 1) + 15;
        setCurrentEnergy(getCurrentEnergy() - 20);
        System.out.println(getName() + " used NakoPo! Damage is " + dmg);
        enemy.takeDamage(dmg + getAttack());

        setSKill2CD(3); // pila ang cooldown sa skill
    }

    @Override
    public void useSkill3(Enemy enemy) {
        if (getSkill3CD() > 0){
            System.out.println("Skill on cooldown! Wait " + getSkill3CD() + " turn(s).");
            return;
        }
        if(getCurrentEnergy() < 20){
            System.out.println("Not enough energy!"); 
            return;
        }

        int dmg = rand.nextInt(30 - 20 + 1) + 20;
        setCurrentEnergy(getCurrentEnergy() - 20);
        System.out.println(getName() + " used Markmanship! Damage is " + dmg);
        enemy.takeDamage(dmg);

        setSKill3CD(3); // pila ang cooldown sa skill
    }

    @Override
    public void useUltimate(Enemy enemy) {
        if(getUltimate() > 0) {
            System.out.println("Ultimate on cooldown! Wait" + getUltimate() + " turn(s).");
            return;
        }
        if(getCurrentEnergy() < 50){
            System.out.println("Not enough energy for KEY CHAIN! (needs 50) ");
            return;
        }
        int dmg = rand.nextInt(21) + 30;
        setCurrentEnergy((getCurrentEnergy() - 50));

          System.out.println("  🏹 " + getName() + " unleashes FROST ARROW STORM! 🏹");

         int   totalDmg = 0;
          for(int i = 1 ; i <= 3 ; i++ ) {
            int arrowDmg = rand.nextInt(26) + getAttack();
            System.out.println();
            enemy.takeDamage(arrowDmg);
            totalDmg = arrowDmg;
          }
           System.out.println("  Total damage dealt: " + totalDmg);
 
        setUltimate(5);
    }

}


























