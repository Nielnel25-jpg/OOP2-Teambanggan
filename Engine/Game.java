package Engine;

import Story.WorldController;

public class Game {
    private Core core;
    private WorldController worldController;

    public Game(){
        core = new Core();
        worldController = new WorldController(core);
    }

    public void start(){
        worldController.startAdventure();
    }

}
