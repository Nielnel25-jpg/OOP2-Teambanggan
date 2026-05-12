package Enemies;


public class Monster extends Enemy {

    public Monster() {
        super("Dungeon Creature", 50, 7, 15);
    }

    // Named enemy for story encounters
    public Monster(String name, int hp, int minDamage, int maxDamage) {
        super(name, hp, minDamage, maxDamage);
    }
}
