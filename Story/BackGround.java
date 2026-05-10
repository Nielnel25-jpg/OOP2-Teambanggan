package Story;

public class BackGround {

    private WorldController control;

    public BackGround(WorldController control) {
        this.control = control;
    }

    public void gameDisplay() {
        System.out.println("  ██████╗ ██╗   ██╗███╗   ██╗ ██████╗ ███████╗ ██████╗ ███╗   ██╗");
        System.out.println("  ██╔══██╗██║   ██║████╗  ██║██╔════╝ ██╔════╝██╔═══██╗████╗  ██║");
        System.out.println("  ██║  ██║██║   ██║██╔██╗ ██║██║  ███╗█████╗  ██║   ██║██╔██╗ ██║");
        System.out.println("  ██║  ██║██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██║   ██║██║╚██╗██║");
        System.out.println("  ██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝███████╗╚██████╔╝██║ ╚████║");
        System.out.println("  ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═══╝");
        System.out.println("                     ██████╗ ██╗   ██╗███████╗███████╗████████╗");
        System.out.println("                     ██╔═══██╗██║   ██║██╔════╝██╔════╝╚══██╔══╝");
        System.out.println("                     ██║   ██║██║   ██║█████╗  ███████╗   ██║   ");
        System.out.println("                     ██║▄▄ ██║██║   ██║██╔══╝  ╚════██║   ██║   ");
        System.out.println("                     ╚██████╔╝╚██████╔╝███████╗███████║   ██║   ");
        System.out.println("                      ╚══▀▀═╝  ╚═════╝ ╚══════╝╚══════╝   ╚═╝   ");
        System.out.println();
    }

    public void gameDisplay2(){
        System.out.println("_____/\\\\\\\\\\\\\\\\\\\\\\____/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\____/\\\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\_______/\\\\\\\\\\\\\\\\\\\\\\______________/\\\\\\\\\\\\\\\\\\\\\\\\\\_______/\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\_____/\\\\\\__/\\\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\__/\\\\\\\\____________/\\\\\\\\__/\\\\\\\\\\\\\\\\\\\\\\________/\\\\\\\\\\\\\\\\\\_      ");
        System.out.println(" ___/\\\\\\/////////\\\\\\_\\///////\\\\\\/////___/\\\\\\///////\\\\\\___\\/\\\\\\///////////____/\\\\\\/////////\\\\\\___/\\\\\\/////////\\\\\\___________\\/\\\\\\/////////\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\\\\\__\\/\\\\\\\\\\\\___\\/\\\\\\_\\/\\\\\\////////\\\\\\__\\/\\\\\\///////////__\\/\\\\\\\\\\\\________/\\\\\\\\\\\\_\\/////\\\\\\///______/\\\\\\////////__  ");
        System.out.println("  __\\//\\\\\\______\\///________\\/\\\\\\_______\\/\\\\\\_____\\/\\\\\\___\\/\\\\\\______________\\//\\\\\\______\\///___\\//\\\\\\______\\///____________\\/\\\\\\_______\\/\\\\\\__/\\\\\\/////////\\\\\\_\\/\\\\\\/\\\\\\__\\/\\\\\\_\\/\\\\\\______\\//\\\\\\_\\/\\\\\\_____________\\/\\\\\\//\\\\\\____/\\\\\\//\\\\\\_____\\/\\\\\\_______/\\\\\\/___________ ");
        System.out.println(" ___/ / / / / _, _/ _, _/___/ / /_/ / / ____/ ___ |/ /|  / /_/ / /___/ /  / // // /___   ");
        System.out.println("/____/ /_/ /_/ |_/_/ |_/____/\\____/ /_/   /_/  |_/_/ |_/_____/_____/_/  /_/___/\\____/   ");
    }


    public void DrowRanger() {
        control.dialogueWriter("Drow, a strong and determined individual, he knows pain and suffering.", 40);
        control.dialogueWriter("He likes challenges and is always up for a good fight.", 40);
        control.dialogueWriter("Deep inside, Drow has something others don't, the ability to endure.", 40);
    }

   
    public void Elf() {
        control.dialogueWriter("Elf is the definition of chill and hardworking, he knows when to get serious and when to relax.", 40);
        control.dialogueWriter("He likes to listen to music and enjoy the simple things in life.", 40);
        control.dialogueWriter("He was given the alias \"kabalomasakitan\" by his tribe.", 40);
    }

    
    public void DragonBorn() {
        control.dialogueWriter("DragonBorn, a quiet and relaxed individual.", 40);
        control.dialogueWriter("He likes to laze around and do nothing, often spends his time sleeping.", 40);
        control.dialogueWriter("But make no mistake, when it's time to fight, he won't hesitate.", 40);
    }
    
}