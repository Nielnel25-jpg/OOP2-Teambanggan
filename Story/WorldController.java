package Story;
import Characters.DragonBorn;
import Characters.Lloyareth;
import Characters.Milarion;
import Enemies.Enemy;
import Engine.Core;
import java.util.*; 
public class WorldController {
    Scanner scanner = new Scanner(System.in);


    private Core core;
    protected BackGround bg;
    private boolean deserterSeen = false;

    protected int currentWorld = 1; 
    protected PrintWorld pw = new PrintWorld(); 

    private int textDelay = 2;

    public WorldController(Core core) {
        this.core = core;
        this.bg = new BackGround(this);
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("║            REALMS OF THE INFINITE DESCENT            ║" );
            System.out.println("╠══════════════════════════════════════════════════════╣" );
            System.out.println("║  A. Enter the Labyrinth                              ║" );
            System.out.println("║  B. Read the Ancient Chronicles (Lore)               ║" );
            System.out.println("║  C. Abandon the Quest                                ║" );
            System.out.println("╚══════════════════════════════════════════════════════╝" );
            System.out.print(" > Choose your path: " );

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
            System.out.println("║  [A] Lloyareth (DrowRanger)                          ║");
            System.out.println("║  [B] Milarion (Elf)                                  ║");                
            System.out.println("║  [C] The Dragonborn (Scale-Shield)                   ║");                
            System.out.println("║  [D] Return to Camp                                  ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print(" > Inspect which Delver? ");

            String in = scanner.next().trim().toUpperCase();
            if (in.length() != 1) continue;

            char pick = in.charAt(0);
            switch (pick) {
                case 'A': bg.Lloyareth(); break;
                case 'B': bg.Milarion(); break;
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
    
            core.getParty().add(new Lloyareth()); 
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
        dialogueWriter(pw.printWorld1();, textDelay);
        dialogueWriter("Lloyareth tightens his leather armor as the damp air of the Sunless Overgrowth fills his lungs.", textDelay);
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
        
        Enemy guard = new Enemy("Overgrowth Guardian", 80, 10, 15);
        core.Battle(guard);

        dialogueWriter("\nPast the gate, Milarion waits, his bow aimed at the darkness.", textDelay);
        dialogueWriter("═══ Milarion joins your party! ═══", textDelay);
        core.getParty().add(new Milarion());
    }

    private void world2() { 
        currentWorld = 2;
        dialogueWriter("\n=== FLOOR 2: THE OBSIDIAN WASTES ===", textDelay);
        dialogueWriter("Heat shimmers off the glass-like walls. The air is thick with sulfur.", textDelay);
        dialogueWriter("Every footstep echoes in the hollow forge of the ancestors.", textDelay);

        boolean r = false;
        do {
            dialogueWriter("\nA sealed vault sits to your left, heat radiating from the door.", textDelay);
            dialogueWriter("A. Breach the vault\nB. Continue the descent\nC. Explore surroundings\nD. Rest by the lava-hearth\nE. Scavenge for supplies\nF. Investigate the shadowy figure\n", textDelay);
            System.out.print(" > ");
            String s = scanner.next().trim().toUpperCase();
            if (s.equals("A")) {
                dialogueWriter("A Flame-Atronach erupts from the seal!", textDelay);
                core.Battle(new Enemy("Flame Atronach", 50, 9, 11));
                r = true;
            } else if (s.equals("B")) {
                dialogueWriter("You choose the safe path, though the riches behind the door remain a mystery.", textDelay);
                r = true;
            } else if (s.equals("C")) { core.explore(); }
            else if (s.equals("D")) { core.rest(); }
            else if (s.equals("E")) { core.merchant(); }
            else if (s.equals("F")) { sideQuestDeserter(); }
        } while(!r);

        dialogueWriter("\nIn the heart of the forge, you find a Dragonborn warrior encased in cursed obsidian.", textDelay);
        dialogueWriter("Lord Omcmize, the Forge-Master, stands between you and the prisoner.", textDelay);

        Enemy Omcmize = new Enemy("Lord Omcmize", 200, 20, 35);
        core.Battle(Omcmize);

        dialogueWriter("\nThe obsidian shatters. The Dragonborn breathes deep the scorching air.", textDelay);
        dialogueWriter("=== The Dragonborn joins your party! ===", textDelay);
        core.getParty().add(new DragonBorn());
    }

    private void world3() {
        currentWorld = 3;
        dialogueWriter("\n=== FLOOR 3: THE ABYSSAL TIDES ===", textDelay);
        dialogueWriter("The fellowship enters the drowned floors. The silence is crushing.", textDelay);

        dialogueWriter("Water seeps through every crack in the stone. The torchlight bends and wavers as if the dark itself is breathing.", textDelay);
 
    dialogueWriter("\nAn ancient specter of a scholar blocks the hallway.", textDelay);
    dialogueWriter("Its robes drift like kelp in a current that does not exist.", textDelay);
    dialogueWriter("SPECTER: \"You have descended far, wanderers. But the Abyssal Tides answer to no blade.\"", textDelay);
    dialogueWriter("SPECTER: \"I was a keeper of this floor once. Now I am its prisoner — bound until one worthy enough passes through.\"", textDelay);
    dialogueWriter("SPECTER: \"Answer my riddles, and the path to Khairos opens. Fail... and you join me in the dark.\"", textDelay);
 
 
    dialogueWriter("\nSPECTER: \"Riddle the first —", textDelay);
    dialogueWriter("I have cities, but no houses live there.", textDelay);
    dialogueWriter("I have mountains, but no trees grow there.", textDelay);
    dialogueWriter("I have water, but no fish swim there.", textDelay);
    dialogueWriter("I have roads, but no cars travel there. What am I?\"", textDelay);
    System.out.println("  [A] A dream");
    System.out.println("  [B] A map");
    System.out.println("  [C] A painting");
    System.out.print(" > ");
 
    boolean riddleFailed = false;
    String r1 = scanner.next().trim().toUpperCase();
    if (!r1.equals("B")) {
        dialogueWriter("SPECTER: \"Incorrect. You mistake illusion for truth — a fatal flaw in the deep.\"", textDelay);
        riddleFailed = true;
    } else {
        dialogueWriter("SPECTER: \"A map. Yes... you understand that a thing can be real without being alive.\"", textDelay);
    }
 
  
    if (!riddleFailed) {
        dialogueWriter("\nSPECTER: \"Riddle the second —", textDelay);
        dialogueWriter("The more you take, the more you leave behind. What am I?\"", textDelay);
        System.out.println("  [A] Time");
        System.out.println("  [B] Footsteps");
        System.out.println("  [C] Memories");
        System.out.print(" > ");
 
        String r2 = scanner.next().trim().toUpperCase();
        if (!r2.equals("B")) {
            dialogueWriter("SPECTER: \"Wrong. You walk the path but do not see what you leave behind.\"", textDelay);
            dialogueWriter("SPECTER: \"In the Abyss, what you forget still follows you.\"", textDelay);
            riddleFailed = true;
        } else {
            dialogueWriter("SPECTER: \"Footsteps. The ground remembers every step — long after the one who walked it is gone.\"", textDelay);
        }
    }
 
    
    if (!riddleFailed) { 
        dialogueWriter("\nSPECTER: \"Riddle the third — a torment that outlives the flesh —", textDelay); 
        dialogueWriter("I am a star you can see but can never reach.", textDelay); 
        dialogueWriter("I live in your thoughts all day, yet I do not know your name.", textDelay); 
        dialogueWriter("The closer I get, the faster your heart beats; the farther I stay, the more it aches. What am I?\"", textDelay); 
        System.out.println("  [A] A ghost"); 
        System.out.println("  [B] A crush"); 
        System.out.println("  [C] A shadow"); 
        System.out.print(" > "); 

        String r3 = scanner.next().trim().toUpperCase(); 
        if (!r3.equals("B")) { 
            dialogueWriter("SPECTER: \"Incorrect. You know nothing of the true horrors of the deep.\"", textDelay); 
            dialogueWriter("SPECTER: \"Mas sakit pa ni sa dungeon boss, brah... ang makita siyang malipayon sa kamot sa uban.\"", textDelay); 
            riddleFailed = true; 
        } else { 
            dialogueWriter("SPECTER: \"Isang sulyap, isang ngiti... isang pag-asang kailanman ay hindi magiging akin.\"", textDelay); 
            dialogueWriter("SPECTER: \"Akala ko baon sa limot ang aking nakaraan... ngunit hanggang sa kawalan, siya pa rin ang aking pinapangarap.\"", textDelay); 
        } 
    }
 
    if (riddleFailed) {
        dialogueWriter("\nThe specter's form fractures — patience spent, wrath unleashed.", textDelay);
        dialogueWriter("SPECTER: \"Then you will not pass. You will not leave.\"", textDelay);
        core.Battle(new Enemy("Hollow Specter", 90, 12, 18));
 
        if (core.getCurrentCharacter().isAlive()) {
            dialogueWriter("The specter dissolves with a hollow wail, its chains finally broken by force rather than wisdom.", textDelay);
            dialogueWriter("The path ahead opens — but the victory tastes of nothing.", textDelay);
        }
    } else {
        dialogueWriter("\nThe specter goes still. For a long moment, nothing moves.", textDelay);
        dialogueWriter("SPECTER: \"Correct. Understanding models the world.\"", textDelay);
        dialogueWriter("SPECTER: \"A rigid blade breaks easily. But a mind that bends... that is what survives the deep.\"", textDelay);
        dialogueWriter("Its form unravels slowly, thread by thread, like smoke in rising water.", textDelay);
        dialogueWriter("The hallway beyond it glows with a cold, blue light.", textDelay);
    }
        dialogueWriter("\nThe final chamber glows with a cold, blue light. Frederick, the Grand Regeant, awaits.", textDelay);
        dialogueWriter("Frederick: \"Your journey ends here. Let us see if your resolve can withstand the pressure.\"", textDelay);

        Enemy Frederick = new Enemy("Grand Regeant Frederick", 300, 35, 50);
        core.Battle(Frederick);

        dialogueWriter("\nFrederick fades into the mist. \"The descent is complete. You have mastered the Infinite.\"", 80);
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
    private void sideQuestDeserter() {
    if (deserterSeen) {
        dialogueWriter("The alcove is empty now.", textDelay);
        return;
    }
    deserterSeen = true;
 
    dialogueWriter("\nA figure crouches behind a collapsed forge wall.", textDelay);
    dialogueWriter("He wears Omcmize's insignia — cracked and scorched.", textDelay);
    dialogueWriter("DESERTER: \"I'm not your enemy. I left Omcmize's guard three days ago.\"", textDelay);
    dialogueWriter("DESERTER: \"I know how he fights. That's worth something, isn't it?\"", textDelay);
 
    System.out.println("\n[A] Bribe him (PHP 80)");
    System.out.println("[B] Threaten him");
    System.out.println("[C] Leave him alone");
    System.out.print(" > ");
 
    Characters.Character active = core.getCurrentCharacter();
    String choice = scanner.next().trim().toUpperCase();
 
    switch (choice) {
        case "A":
            if (active.getGold() < 80.0) {
                dialogueWriter("Not enough gold. He shrugs and says nothing.", textDelay);
                break;
            }
            active.useGold(80.0);
            dialogueWriter("He pockets the coin.", textDelay);
            dialogueWriter("DESERTER: \"Omcmize's left guard drops after his third hit. Every time. Use it.\"", textDelay);
            dialogueWriter("He tosses you a forge salve before disappearing into the dark.", textDelay);
            for (Characters.Character c : core.getParty()) {
                if (c.isAlive()) { c.heal(30); c.addEnergy(20); }
            }
            System.out.println("  Party healed: +30 HP, +20 Energy");
            break;
 
        case "B":
            dialogueWriter("DESERTER: \"I didn't survive Omcmize to be pushed around by you.\"", textDelay);
            dialogueWriter("He grabs a forge pick and lunges.", textDelay);
            core.Battle(new Enemy("Forge Deserter", 55, 8, 13));
            if (core.getCurrentCharacter().isAlive()) {
                dialogueWriter("DESERTER: \"...fine. His left guard drops after the third hit. Happy now?\"", textDelay);
            }
            break;
 
        case "C":
        default:
            dialogueWriter("You leave him where he sits. He watches you go in silence.", textDelay);
            break;
    }
}
 
}
