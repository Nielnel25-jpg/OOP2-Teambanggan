package Characters;
import Enemies.Enemy;

public class Elf extends Character {

    public Elf(){
        super("Elf", 250, 70, 5, 1, 0, 10, 0, 0, 0);
    }

    @Override
    public void displaySkills(){
    System.out.println();
    System.out.println("0. Basic Attack: Max Damage: " + getAttack() + " | Gain Energy: 30");
    System.out.println("1. Skill 1(yearner): Max Damage: " + (getAttack() + 10) + " | Energy cost: 30 | Cooldown 2 rounds");
    System.out.println("2. SKill 2(whycantbeme?): Max Damage: " + (getAttack() + 20) + " | Energy cost: 20 | Cooldown 3 rounds");
    System.out.println("3. Skill 3(kabalomasakitan): Max Damage: " + (getAttack() + 20) + " | Energy cost: 20 | Cooldown 3 rounds");
    System.out.println();
    }

    @Override
    public void useBasic(Enemy enemy) {
        int dmg = getAttack();
        addEnergy(30);
        System.out.println(getName() + "used basic attack");
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
        System.out.println(getName() + " used yearner. Damage is " + dmg);
        enemy.takeDamage(dmg + getAttack());

        setSKill1CD(2);
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
        System.out.println(getName() + " used whycantbeme?! Damage is " + dmg);
        enemy.takeDamage(dmg + getAttack());

        setSKill2CD(3);
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

        int dmg = rand.nextInt(20 - 15 + 1) + 15;
        setCurrentEnergy(getCurrentEnergy() - 20);
        System.out.println(getName() + " used kabalomasakitan! Damage is " + dmg);
        enemy.takeDamage(dmg + getAttack());

        setSKill3CD(3);
    }

}























