package Engine;

import Story.WorldController;

public class Game {
    private Core core;
    private WorldController worldController;
    private boolean isRunning = true;

    public Game(){
        core = new Core();
        worldController = new WorldController(core);
    }

    public void start(){
        worldController.startAdventure();
    }

    public void setIsRunning(boolean running){
        this.isRunning = running;
    }

    public boolean getIsRunnning(){
        return isRunning;
    }

    public Core getCore(){
        return core;
    }

    public WorldController getWordController(){
        return worldController;
    }

}
