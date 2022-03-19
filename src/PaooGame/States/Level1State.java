package PaooGame.States;

import PaooGame.Hud.Hud;
import PaooGame.Items.*;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level1State extends LevelState{

    public Level1State(RefLinks refLink) {
        super(refLink, 1);
        this.hero = new Hero(refLink, 70, 400);

        snakes = new ArrayList<Snake>();
        snakes.add(new Snake1(refLink, 212, 385));
        snakes.add(new Snake2(refLink, 785, 547));

        nuts = new ArrayList<Nut>();
        nuts.add(new Nut(refLink, 50, 190));
        nuts.add(new Nut(refLink, 1135, 226));
        nuts.add(new Nut(refLink, 800, 550));

        itemManager = new ItemManager(refLink, hero, snakes, nuts);
    }
}
