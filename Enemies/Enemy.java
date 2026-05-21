package Enemies;
import java.util.Random;

public class Enemy{
    private Random rand = new Random();
    private String name;
    private int hp;
    private int minDamage;
    private int maxDamage;

    public Enemy(String name, int hp, int minDamage, int maxDamage){
        this.name = name;
        this.hp = hp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    public void takeDamage(int amount){
        hp = Math.max(0, hp - amount);
    }

    public int attack(){
        int dmg = rand.nextInt(maxDamage - minDamage + 1) + minDamage;
        System.out.println("   " + name + " unleashed an attack! damage is " + dmg + "!  ");
        return  dmg;
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public void displayStatus(){
        System.out.println(name + " - HP: " + hp + "/50");
    }

}























