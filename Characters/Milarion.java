package Characters;
import Enemies.Enemy;

public class Milarion extends Character {

    public Milarion(){
        super("Milarion", 250, 70, 5, 1, 0, 10, 0, 0, 0, 0);
    }

    @Override
    public void displaySkills(){
    System.out.println();
    System.out.println("0. Basic Attack: Max Damage: " + getAttack() + " | Gain Energy: 30");
    System.out.println("1. Skill 1(yearner): Max Damage: " + (getAttack() + 10) + " | Energy cost: 30 | Cooldown 2 rounds");
    System.out.println("2. SKill 2(whycantbeme?): Max Damage: " + (getAttack() + 20) + " | Energy cost: 20 | Cooldown 3 rounds");
    System.out.println("3. Skill 3(kabalomasakitan): Max Damage: " + (getAttack() + 20) + " | Energy cost: 20 | Cooldown 3 rounds");
    System.out.println("4. Ultimate(DropOut): Max Damage: " + (getAttack() + 50) + " | Energy cost: 50 | Cooldown 5 rounds");
    System.out.println();
    }

    @Override
    public void useBasic(Enemy enemy) {
        int dmg = getAttack();
        addEnergy(30);
        System.out.println(getName() + " used basic attack");
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

        int dmg = rand.nextInt(6) + 5;
        int sdmg = dmg + getAttack();
        setCurrentEnergy(getCurrentEnergy() - 30);
        System.out.println(getName() + " used yearner. Damage is " + sdmg);
        enemy.takeDamage(sdmg);

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

        int dmg = rand.nextInt(6) + 5;
        int sdmg = dmg + getAttack();
        setCurrentEnergy(getCurrentEnergy() - 20);
        System.out.println(getName() + " used whycantbeme?! Damage is " + sdmg);
        enemy.takeDamage(sdmg);

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

        int dmg = rand.nextInt(6) + 5;
        int sdmg = dmg + getAttack();
        setCurrentEnergy(getCurrentEnergy() - 20);
        System.out.println(getName() + " used kabalomasakitan! Damage is " + sdmg);
        enemy.takeDamage(sdmg);

        setSKill3CD(3);
    }

    @Override
    public void useUltimate(Enemy enemy) {
        if(getUltimate() > 0) {
            System.out.println("Ultimate on cooldown! Wait" + getUltimate()+ " turn(s).");
            return;
        }
        
        if(getCurrentEnergy() < 50){
            System.out.println("Not enough energy for KEY CHAIN! (needs 50) ");
            return;
        }

        int dmg = rand.nextInt(21) + 30;
        setCurrentEnergy(getCurrentEnergy() - 50);

        System.out.println("🌿" +getName() + "calls NATURE`S WRATH 🌿");
        System.out.println(" Damage is: " + (dmg + getAttack()) + "- Healed self for 40 hp!");
        enemy.takeDamage(dmg + getAttack());

        heal(40);

        setUltimate(5);

    }

}























