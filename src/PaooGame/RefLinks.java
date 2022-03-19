package PaooGame;

import PaooGame.Items.Hero;
import PaooGame.Maps.Map;

import PaooGame.Input.KeyManager;

public class RefLinks {
    private Game game;
    private Map map1;
    private Map map2;
    private double scor;
    private Hero hero;
    private long currentTime;
    private final int framesPerSecond = 60;
    private final double timeFrame = (float)1000000000 / framesPerSecond;

    public RefLinks(Game game){
        this.game = game;
    }

    //settere si gettere:

    public KeyManager GetKeyManager(){
        return game.GetKeyManager();
    }

    public int GetWidth(){
        return game.GetWidth();
    }

    public int GetHeight(){
        return game.GetHeight();
    }

    public Game GetGame(){
        return game;
    }

    public void SetGame(Game game){
        this.game = game;
    }

    public Map GetMap(){
        if(this.game.getCurrentLevel() == 1) {
            return map1;
        }
        else if(this.game.getCurrentLevel() == 2) {
            return map2;
        }
        return map1;
    }

    public void SetMap(Map map, int mapID){
        if(mapID == 1) {
            map1 = map;
        }
        else if(mapID == 2) {
            map2 = map;
        }
    }

    public void SetHero(Hero hero){
        this.hero = hero;
    }

    public Hero getHero(){
        return this.hero;
    }

    public void setScor(double scor){
        this.scor = scor;
    }

    public double getScor() {
        return this.scor;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public long getFramesPerSecond(){
        return this.framesPerSecond;
    }

    public double getTimeFrame(){
        return (float)1000000000 / framesPerSecond;
    }
}
