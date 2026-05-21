package Characters;
import Enemies.Enemy;

public class DragonBorn extends Character{
    

    public DragonBorn(){
        super("DragonBorn", 110, 70, 13, 1, 0, 10, 0,0,0);
    }

    @Override
    public void displaySkills(){
    System.out.println();
    System.out.println("0. Basic Attack(): Max Damage: " + getAttack() + " | Gain Energy: 30");
    System.out.println("1. Skill 1(Sleep): Max Damage: " + (getAttack() + 15) + " | Energy cost: 30 | Cooldown 2 round");
    System.out.println("2. SKill 2(Bite): Max Damage: " + (getAttack() + 20) + " | Energy cost: 20 | Cooldown 3 round");
    System.out.println("3. Skill 3(Slash): Max Damage: " + (getAttack() + 30) + " | Energy cost: 20 | Cooldown 3 rounds");
    System.out.println("4. Ultimate(KeyChain): Max Damage:" + (getAttack() + 40) + " | Energy cost: 50 | Cooldown 4 rounds");
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

        int dmg = rand.nextInt(15 - 10 + 1) + 10;
        setCurrentEnergy(getCurrentEnergy() - 30);
        System.out.println(getName() + " used Sleep! Damage is " + dmg);
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
        System.out.println(getName() + " used Bite! Damage is " + dmg);
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

        int dmg = rand.nextInt(30 - 20 + 1) + 20;
        setCurrentEnergy(getCurrentEnergy() - 20);
        System.out.println(getName() + " used Slash! Damage is " + dmg);
        enemy.takeDamage(dmg + getAttack());

        setSKill3CD(3);
    }

    public void useUltimate(Enemy enemy) {
        if(getUltimate() > 0) {
            System.out.println("Ultimate on cooldown! Wait " + getUltimate() + " turn(s).");
            return;
        }
        if(getCurrentEnergy() < 50){
            System.out.println("Not enough energy!"); 
            return;
        }

         int dmg = rand.nextInt(21) + 40; 
        setCurrentEnergy(getCurrentEnergy() - 50);
 
        System.out.println("  🔥 " + getName() + " unleashes DRAGON RAGE! 🔥");
        System.out.println("  Damage: " + (dmg + getAttack()) + " — All skill cooldowns reset!");
 
        enemy.takeDamage(dmg + getAttack());
 

        setSKill1CD(0);
        setSKill2CD(0);
        setSKill3CD(0);
        setUltimate(5);
    }

}























