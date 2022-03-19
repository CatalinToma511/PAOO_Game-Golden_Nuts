package PaooGame.States;

import PaooGame.Hud.Hud;
import PaooGame.Items.Hero;
import PaooGame.Items.ItemManager;
import PaooGame.Items.Nut;
import PaooGame.Items.Snake;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelState extends State{
    protected Hero hero;
    protected Map map;
    protected List<Snake> snakes;
    protected List<Nut> nuts;
    protected ItemManager itemManager;
    protected Hud hud;
    private int levelID;

    public LevelState(RefLinks refLink, int mapID) {
        super(refLink);
        MapFactory mapFactory = new MapFactory();
        map = mapFactory.Factory(refLink, mapID); //se construieste harta
        refLink.SetMap(map, mapID); //se updateaza harta (pentru refLink) cu cea construita mai sus

        levelID = mapID;
        hud = new Hud(refLink);
    }

    @Override
    public void Update(){
        refLink.SetHero(hero);
        refLink.GetGame().setCurrentLevel(levelID);
        map.Update();
        hero.Update();

        if(refLink.GetKeyManager().esc){
            refLink.GetGame().getPauseState().resetState();
            State.SetState(refLink.GetGame().getPauseState());
        }
        for(int i = 0; i < snakes.size(); ++i){
            snakes.get(i).Update();
        }
        for(int i = 0; i < nuts.size(); ++i){
            nuts.get(i).Update();
        }
        int index = itemManager.getNutCollision();
        if(index != -1 && index < nuts.size()){
            nuts.remove(index);
        }
        Snake attacker = itemManager.getSnakeCollision();
        if(attacker != null && hero.canTakeDamage()){
            //System.out.println(hero == refLink.getHero());
            hero.takeDamage(attacker.getDamage());
            attacker.startAttack();
        }
        hud.Update(hero);
        //System.out.println(hero.GetLife());

        boolean finished = nuts.isEmpty();
        if(finished){
            //setam un state de level terminat
            refLink.GetGame().getFinishedLevelState().resetState();
            State.SetState(refLink.GetGame().getFinishedLevelState());
        }
    }

    @Override
    public void Draw(Graphics g) {
        map.Draw(g);
        for(int i = 0; i < nuts.size(); ++i){
            nuts.get(i).Draw(g);
        }
        for(int i = 0; i < snakes.size(); ++i){
            snakes.get(i).Draw(g);
        }
        hero.Draw(g);
        hud.Draw(g);
    }

    @Override
    public void resetState() {

    }
}
