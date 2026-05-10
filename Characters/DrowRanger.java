package Characters;
import java.util.Random;

import Enemies.Enemy;

public class DrowRanger extends Character{
    private Random rand = new Random();
    
    public DrowRanger(){
        super("DrowRanger", 120, 40, 20, 1, 30, 50, 0, 0, 0);
    }

    @Override
    public void displaySkills(){
        System.out.println();
        System.out.println("0. Basic getAttack(): Max Damage: " + getAttack() + " | Gain Energy: 30");
        System.out.println("1. Skill 1(ArayMoPakak): Max Damage: " + (getAttack() + 10) + " | Energy cost: 30 | Cooldown 2 round");
        System.out.println("2. SKill 2(NakoPo!): Max Damage: "+ (getAttack() + 20) + " | Energy cost: 20 | Cooldown 3 round");
        System.out.println("3. Skill 3(Markmanship): Max Damage: " + (getAttack() + 30) + " | Energy cost: 40 | Cooldown 3 rounds");
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

}


























