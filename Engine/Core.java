package Engine;

import java.text.DecimalFormat;
import java.util.*;


import Characters.Character;
import Characters.DragonBorn;
import Characters.Lloyareth;
import Characters.Milarion;
import Enemies.Enemy;
import Enemies.Monster;

public class Core {
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();
    private DecimalFormat df = new DecimalFormat("##,##0.00");

    private ArrayList<Character> party;
    protected boolean exitGame = false;
    private int currentFighterIndex = 0;

    public Core() {
        party = new ArrayList<>();
        party.add(new Lloyareth());
    }

    public ArrayList<Character> getParty(){
        return party;
    }

    public Character getCurrentCharacter(){
        return party.get(currentFighterIndex);
    }

    //exploration
    public void explore() {

        boolean exploring = true;

        while (exploring && !exitGame) {
            System.out.println("\nYou venture into the area...");
            int chance = rand.nextInt(100);

            if (chance < 60) {
                Enemy enemy = new Monster("Skeleton", 80, 10, 15);
                System.out.println("A wild " + enemy.getName() + " appeared!");
                // bakbakan naa!!
                Battle(enemy);
            
                boolean anyAlive = false;
                for (Character c : party) {
                    if (c.isAlive()) {
                        anyAlive = true;
                        break;
                    }
                }
                if (anyAlive) {
                    System.out.println("You survived this encounter.");
                } else {
                    System.out.println("You were defeated...");
                    exitGame = true;
                    break;
                }
            } else {
                System.out.println("You found nothing interesting. It’s peaceful here...");
            }

            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("║                      WORLD                           ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  [1] Continue Exploring                              ║");
            System.out.println("║  [2] Return to Main Menu                             ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");

            boolean validNext = false;

            while (!validNext) {
                try {
                    System.out.print(" > Choose an option: ");
                    int next = sc.nextInt();

                    if (next == 1) {
                        validNext = true;
                    } else if (next == 2) {
                        validNext = true;
                        exploring = false;
                    } else {
                        System.out.println("Invalid Option! Try again!");
                    }

                } catch (Exception e) {
                    System.out.println("Invalid Option! Try again!");
                    sc.nextLine();
                }
            }
        }
    }


    //Battle
    public void Battle(Enemy enemy){
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                    BATTLE START                      ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("   Enemy: " + enemy.getName() + "                             ");
        System.out.println("╚══════════════════════════════════════════════════════╝");        

        while(true){
            Character activeCharacter = party.get(currentFighterIndex);

            if(!activeCharacter.isAlive()){
                System.out.println(activeCharacter.getName() + " is down! Switching to next alive member...");
                boolean switched = false;
                for(int i = 0; i < party.size(); i++){
                    if(party.get(i).isAlive()) {
                        currentFighterIndex = i;
                        switched = true;
                        break;
                    }
                }
                if(!switched){
                    System.out.println("All party members defeated!");
                    System.out.println("GAME OVER!");
                    break;
                }
                activeCharacter = party.get(currentFighterIndex);
            }

            // paras player
            if(enemy.isAlive()){
                showCharacterMenu(activeCharacter, enemy);
            }

            //if patay na kalaban
            if (!enemy.isAlive()) {
                double reward = rand.nextDouble() * (50 - 30) + 30;
                activeCharacter.addGold(reward);
                int exp  = rand.nextInt(21) + 30;
                activeCharacter.addExp(exp);

                System.out.println("\nEnemy defeated! \nGained " + exp + " EXP and PHP " + df.format(reward));

                activeCharacter.addEnergy(activeCharacter.getMaxEnergy()); // everytime maka daog kay mo reset ang energy
                activeCharacter.heal(activeCharacter.getMaxHp()); // everytime maka daog kay mo reset ang hp

                if(activeCharacter.getExp() >= 50){
                    activeCharacter.levelUp();
                }
                activeCharacter.setSKill1CD(0);
                activeCharacter.setSKill2CD(0);
                activeCharacter.setSKill3CD(0);
                
                break;
            }

            if (enemy.isAlive()) {
                System.out.println("╔══════════════════════════════════════════════════════╗");
                System.out.println("   " + enemy.getName() + "'s Turn                             ");

                //prints line for name boundary something something
                String name = enemy.getName();
                System.out.print("   ");
                for(int i = 0; i < name.length(); i++){
                    System.out.print("═");
                }
                System.out.println(); //para mo ubos lolz

                System.out.println("   HP: " + enemy.getHp() + "                                              ");
                System.out.println("╠══════════════════════════════════════════════════════╣");

                int dmg = enemy.attack();
                activeCharacter.takeDamage(dmg);
                System.out.println("   " + activeCharacter.getName() + " took " + dmg + " damage!                               ");
                System.out.println("╚══════════════════════════════════════════════════════╝");
            }

            boolean anyAlive = false;
            for (Character c : party) {
                if (c.isAlive()) {
                    anyAlive = true;
                    break;
                }
            }
            if (!anyAlive) {
                System.out.println("All party members defeated!");
                System.out.println("GAME OVER!");
                break;
            }            
        }
    }

    //character Menu
    private void showCharacterMenu(Character c, Enemy enemy) {
        boolean turnComplete = false;
        while (!turnComplete) {
            
            //  PUT WORLD IDENTIFIER HERE PSJRFPWJPFGRWEJPOFJRWEPGFERPOGKEROG
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("   " + c.getName() + "'s Turn                                      ");

            //prints line for name boundary something something
                String name = c.getName();
                System.out.print("   ");
                for(int i = 0; i < name.length(); i++){
                    System.out.print("═");
                }
                System.out.println(); //para mo ubos lolz

            System.out.println("   HP: " + c.getHp() + "/" + c.getMaxHp() + "                                            ");
            System.out.println("   Energy: " + c.getCurrentEnergy() + "/" + c.getMaxEnergy() + "                 ");
            System.out.println("   Money: PHP " + df.format(c.getGold()) + " ");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            c.displaySkills();

            System.out.println("4. Check Stats");
            System.out.println("5. Check Inventory");
            System.out.println("6. Switch Character");
            System.out.print("Choose action (0-6): ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }
    
            // paras cooldown
            int beforeSkill1CD = c.getSkill1CD();
            int beforeSkill2CD = c.getSkill2CD();
            int beforeSkill3CD = c.getSkill3CD();

            switch (choice) {
                case 0:
                    c.useBasic(enemy);
                    turnComplete = true;
                    break;
                case 1:
                    if (c.getCurrentEnergy() < 30) System.out.println("Not enough energy!");
                    else { 
                        c.useSkill1(enemy); 
                        if(c.getSkill1CD() > beforeSkill1CD){
                            turnComplete = true;
                        }
                    }
                    break;
                case 2:
                    if (c.getCurrentEnergy() < 20) System.out.println("Not enough energy!");
                    else { 
                        c.useSkill2(enemy);
                        if(c.getSkill2CD() > beforeSkill2CD){
                            turnComplete = true;    
                        }
                    }
                    break;
                case 3:
                    if (c.getCurrentEnergy() < 20) System.out.println("Not enough energy!");
                    else { 
                        c.useSkill3(enemy); 
                        if(c.getSkill3CD() > beforeSkill3CD){
                            turnComplete = true;
                        }
                    }
                    break;
                case 4:
                    c.showStats();
                    break;
                case 5:
                    showInventory(c);
                    break;
                case 6:
                    switchCharacter();
                    turnComplete = false; // costs a turn
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            //mo reduce og 1 ang cooldown after every turn nga ma complete 
            if(turnComplete){
                c.reduceCooldowns(); 
            }
        }
    }


    //switch Characters
    private void switchCharacter() {
        System.out.println("\n═══ Switch Character ═══");
        for (int i = 0; i < party.size(); i++) {
            Character c = party.get(i);
            System.out.println("["+ i + "] " + c.getName() + (c.isAlive() ? "" : " (DEAD)"));
        }

        int choice = -1;
        while (choice < 0 || choice >= party.size()) {
            try {
                System.out.print(" > Choose an option: ");
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }

        Character chosen = party.get(choice);
        if (!chosen.isAlive()) {
            System.out.println(chosen.getName() + " is defeated! Choose another.");
        } else if (choice == currentFighterIndex) {
            System.out.println(chosen.getName() + " is already active.");
        } else {
            currentFighterIndex = choice;
            System.out.println("You switched to " + chosen.getName() + "! (Turn used)");
        }
    }


//Inventory
    public void showInventory(Character c) {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("                       Inventory ");
        System.out.println("  Money: PHP" + df.format(c.getGold()));
        System.out.println("  [1] Tanggo - " + c.getTanggo());
        System.out.println("  [2] Bottle - " + c.getBottle());
        System.out.println("  [3] Clarity - " + c.getClarity());
        System.out.println("  [U] Use Item");
        System.out.println("  [E] Exit");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.print(" > Choose an option: ");
        String input = sc.nextLine().toUpperCase();
        if (input.equals("U")) useItemMenu();
    }

    public void useItemMenu() {
        Character c = getCurrentCharacter();
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("                       Choose item to use: ");
        System.out.println("  [1] Tanggo (+20 HP)");
        System.out.println("  [2] Bottle (+30 HP)");
        System.out.println("  [3] Clarity (+15 Energy)");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.print(" > Choose an option: ");

        int choice = -1;
        try { choice = Integer.parseInt(sc.nextLine()); } catch (Exception e) { return; }

        if (choice == 1 && c.getTanggo() > 0) c.useTanggo();
        else if (choice == 2 && c.getBottle() > 0) c.useBottle();
        else if (choice == 3 && c.getClarity() > 0) c.useClarity();
        else System.out.println("Not enough of that item!");
    }

//store
    public void merchant() {
        Character c = getCurrentCharacter();

        int tanggoPrice = 80;
        int bottlePrice = 125;
        int clarityPrice = 85;

        System.out.println("MYSTIC PEDDLER: \"Ah, traveler! Care to browse my wares?\"");

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                    MYSTIC PEDDLER                    ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("  Gold: $ " + df.format(c.getGold()));
        System.out.println("  [1] Tanggo - $ " + tanggoPrice);
        System.out.println("  [2] Bottle - $ " +  bottlePrice);
        System.out.println("  [3] Clarity - $ " + clarityPrice);
        System.out.println("  [0] Exit Store");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        
        int choice = -1;
        System.out.print(" > Choose an option: ");
        try { choice = Integer.parseInt(sc.nextLine()); } catch (Exception e) { return; }
        if (choice == 0) {
            System.out.println("MYSITC PEDDLER: \"Until our paths cross again...\"");
            return;
        };

        System.out.print(" > Enter quantity: ");
        int quantity = -1;
        try { quantity = Integer.parseInt(sc.nextLine()); } catch (Exception e) { return; }

        int price = 0;
        if (choice == 1) price = tanggoPrice * quantity;
        else if (choice == 2) price = bottlePrice * quantity;
        else if (choice == 3) price = clarityPrice * quantity;

        if (c.getGold() >= price) {
            if (choice == 1) c.addTanggo(quantity);
            else if (choice == 2) c.addBottle(quantity);
            else if (choice == 3) c.addClarity(quantity);
            c.useGold(price);
            System.out.println("MYSTIC PEDDLER: \"Pleasure doing business with you.\"");
        } else {
            System.out.println("Not enough gold!");
        }
    }


//rest
    public void rest(){
        Character c = getCurrentCharacter();
        c.heal(50);
        c.addEnergy(50);

        System.out.println("Hp and Energy restored...");
    }



}
