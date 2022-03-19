package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.util.List;

public class ItemManager {
    private Hero neculai;
    private List<Snake> snakes; //lista cu inamicii
    private List<Nut> nuts; //lista cu obiecte colectionabile
    private RefLinks refLinks;
    public ItemManager(RefLinks refLinks, Hero hero, List<Snake> snakes, List<Nut> nuts){
        this.neculai = hero;
        this.refLinks = refLinks;
        this.snakes = snakes;
        this.nuts = nuts;
    }


    public int getNutCollision(){ //returneaza indexul nucii care trebuie stearsa
        Rectangle heroRect = neculai.getBounds();
        for(int i = 0; i < nuts.size(); ++i){
            if(heroRect.intersects(nuts.get(i).getBounds())){
                return i;
            }
        }
        return -1; //caz special, tratam separat
    }

    public Snake getSnakeCollision(){
        Rectangle heroRect = neculai.getBounds();
        for(int i = 0; i < snakes.size(); ++i){
            if(heroRect.intersects(snakes.get(i).getBounds())){
                return snakes.get(i); //daca e true, se va apela o metoda din hero care executa damage-ul
            }
        }
        return null;
    }
}
