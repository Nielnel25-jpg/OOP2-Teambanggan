package Story;
import java.util.*;

import Engine.Core;
import Enemies.Enemy;
import Enemies.Monster;
import Characters.DrowRanger;
import Characters.Elf;        
import Characters.DragonBorn; 

public class WorldController {
    Scanner scanner = new Scanner(System.in);
    private Core core;
    protected BackGround bg;

    protected int currentWorld = 1; 
    protected PrintWorld pw = new PrintWorld(); 

    private int textDelay = 30;

    public WorldController(Core core) {
        this.core = core;
        this.bg = new BackGround(this);
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("║            REALMS OF THE INFINITE DESCENT            ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  A. Enter the Labyrinth                              ║");
            System.out.println("║  B. Read the Ancient Chronicles (Lore)               ║");
            System.out.println("║  C. Abandon the Quest                                ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print(" > Choose your path: ");

            String input = scanner.next().trim().toUpperCase();

            if (input.length() != 1) {
                System.out.println("Invalid input. Type A, B, or C.");
                continue;
            }

            char choice = input.charAt(0);

            switch (choice) {
                case 'A':
                    System.out.println("\nThe torch is lit. The descent begins...");
                    running = false;
                    break;
                case 'B':
                    openCharacterLore();
                    break;
                case 'C':
                    System.out.println("\nThe darkness remains unchallenged. Farewell.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void openCharacterLore() {
        boolean reading = true;
        while (reading) {
            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("║                 THE FELLOWSHIP ROSTER                ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  [A] The DrowRanger (Shadow-Striker)                 ║");
            System.out.println("║  [B] The Elf (Warden of Wilds)                       ║");                
            System.out.println("║  [C] The Dragonborn (Scale-Shield)                   ║");                
            System.out.println("║  [D] Return to Camp                                  ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print(" > Inspect which Delver? ");

            String in = scanner.next().trim().toUpperCase();
            if (in.length() != 1) continue;

            char pick = in.charAt(0);
            switch (pick) {
                case 'A': bg.DrowRanger(); break;
                case 'B': bg.Elf(); break;
                case 'C': bg.DragonBorn(); break;
                case 'D': reading = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    
    public void startAdventure() {
        bg.gameDisplay();
        mainMenu(); 

        boolean playAgain = true;
        while (playAgain) {
            core.getParty().clear();
    
            core.getParty().add(new DrowRanger()); 
            world1();
            world2();
            world3();

            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("║                  ASCENSION ACHIEVED                  ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            dialogueWriter("The fellowship stands at the bottom of the final staircase. The Labyrinth is conquered.", textDelay);

            while (true) {
                try {
                    System.out.println("\nDo you wish to enter a new Labyrinth? (Y/N): ");
                    System.out.print(" > ");
                    String choice = scanner.next().trim();

                    if (choice.equalsIgnoreCase("Y")) {
                        dialogueWriter("Re-igniting the torch. New dangers await...", textDelay);
                        this.core = new Core(); 
                        this.bg = new BackGround(this); 
                        this.currentWorld = 1; 
                        break; 
                    } else if (choice.equalsIgnoreCase("N")) {
                        dialogueWriter("You return to the surface, legends of the deep floors.", textDelay);
                        playAgain = false; 
                        break;
                    } else {
                        dialogueWriter("The darkness does not understand that command.", textDelay);
                    }
                } catch (Exception e) {
                    dialogueWriter("The void consumes your input.", textDelay);
                    scanner.nextLine(); 
                }
            }
        }
    }

    private void world1() {
        currentWorld = 1;
        dialogueWriter("=== FLOOR 1: THE SUNLESS OVERGROWTH ===", textDelay);
        dialogueWriter("The DrowRanger tightens his leather armor as the damp air of the Sunless Overgrowth fills his lungs.", textDelay);
        dialogueWriter("Remnants of a forgotten age twist around him. Only steel on stone will guide the way.", textDelay);

        dialogueWriter("\nA wounded traveler lies amidst the bioluminescent vines.", textDelay);
        dialogueWriter("TRAVELER: \"Please... the roots... they are hungry...\"", textDelay);
        dialogueWriter("What is your choice?\nA. Offer a healing draught\nB. Conserve resources and move on", textDelay);

        boolean choiceDone = false;
        while (!choiceDone) {
            System.out.print(" > ");
            String s = scanner.next().trim().toUpperCase();
            if (s.equals("A")) {
                dialogueWriter("The traveler shares a secret passage. You avoid the thorn-traps.", textDelay);
                choiceDone = true;
            } else if (s.equals("B")) {
                dialogueWriter("You walk past. The traveler's sighs are lost in the rustling leaves.", textDelay);
                choiceDone = true;
            }
        }

        dialogueWriter("\nA figure stands before the gate to the inner sanctum.", textDelay);
        dialogueWriter("GUARDIAN: \"None pass the Overgrowth without the scent of blood on their blade.\"", textDelay);
        
        Enemy guard = new Monster("Overgrowth Guardian", 80, 10, 15);
        core.Battle(guard);

        dialogueWriter("\nPast the gate, an Elf warden waits, her bow aimed at the darkness.", textDelay);
        dialogueWriter("═══ The Elf joins your party! ═══", textDelay);
        core.getParty().add(new Elf());
    }

    private void world2() { 
        currentWorld = 2;
        dialogueWriter("\n=== FLOOR 2: THE OBSIDIAN WASTES ===", textDelay);
        dialogueWriter("Heat shimmers off the glass-like walls. The air is thick with sulfur.", textDelay);
        dialogueWriter("Every footstep echoes in the hollow forge of the ancestors.", textDelay);

        boolean r = false;
        do {
            dialogueWriter("\nA sealed vault sits to your left, heat radiating from the door.", textDelay);
            dialogueWriter("A. Breach the vault\nB. Continue the descent\nC. Explore surroundings\nD. Rest by the lava-hearth\nE. Scavenge for supplies", textDelay);
            System.out.print(" > ");
            String s = scanner.next().trim().toUpperCase();
            if (s.equals("A")) {
                dialogueWriter("A Flame-Atronach erupts from the seal!", textDelay);
                core.Battle(new Monster("Flame Atronach", 50, 9, 11));
                r = true;
            } else if (s.equals("B")) {
                dialogueWriter("You choose the safe path, though the riches behind the door remain a mystery.", textDelay);
                r = true;
            } else if (s.equals("C")) { core.explore(); }
            else if (s.equals("D")) { core.rest(); }
            else if (s.equals("E")) { core.merchant(); }
        } while(!r);

        dialogueWriter("\nIn the heart of the forge, you find a Dragonborn warrior encased in cursed obsidian.", textDelay);
        dialogueWriter("Lord Uganggar, the Forge-Master, stands between you and the prisoner.", textDelay);

        Enemy uganggar = new Monster("Lord Uganggar", 200, 20, 35);
        core.Battle(uganggar);

        dialogueWriter("\nThe obsidian shatters. The Dragonborn breathes deep the scorching air.", textDelay);
        dialogueWriter("=== The Dragonborn joins your party! ===", textDelay);
        core.getParty().add(new DragonBorn());
    }

    private void world3() {
        currentWorld = 3;
        dialogueWriter("\n=== FLOOR 3: THE ABYSSAL TIDES ===", textDelay);
        dialogueWriter("The fellowship enters the drowned floors. The silence is crushing.", textDelay);

        dialogueWriter("\nAn ancient specter of a scholar blocks the hallway.", textDelay);
        dialogueWriter("SPECTER: \"To know the deep, one must know the soul. What governs a fellowship?\"", textDelay);
        dialogueWriter("A. Unyielding Law\nB. Pure Understanding", textDelay);

        boolean riddleDone = false;
        while (!riddleDone) {
            System.out.print(" > ");
            String s = scanner.next().trim().toUpperCase();
            if (s.equals("A")) {
                dialogueWriter("SPECTER: \"A rigid blade breaks easily.\"", textDelay);
                riddleDone = true;
            } else if (s.equals("B")) {
                dialogueWriter("SPECTER: \"Correct. Understanding models the world.\"", textDelay);
                riddleDone = true;
            }
        }

        dialogueWriter("\nThe final chamber glows with a cold, blue light. Khairos, the Grand Architect, awaits.", textDelay);
        dialogueWriter("Khairos: \"Your journey ends here. Let us see if your resolve can withstand the pressure.\"", textDelay);

        Enemy khairos = new Monster("Grand Architect Khairos", 300, 35, 50);
        core.Battle(khairos);

        dialogueWriter("\nKhairos fades into the mist. \"The descent is complete. You have mastered the Infinite.\"", 80);
    }

    public void dialogueWriter(String text, int delay) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
