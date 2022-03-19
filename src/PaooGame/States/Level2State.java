package PaooGame.States;

import PaooGame.Hud.Hud;
import PaooGame.Items.*;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level2State extends LevelState{
    public Level2State(RefLinks refLink) {
        super(refLink, 2);
        hero = new Hero(refLink, 70, 400);

        snakes = new ArrayList<Snake>();
        snakes.add(new Snake1(refLink, 915, 98));
        snakes.add(new Snake1(refLink, 915, 192));
        snakes.add(new Snake2(refLink, 396, 544));
        snakes.add(new Snake2(refLink, 915, 544));
        snakes.add(new Snake2(refLink, 740, 544));
        snakes.add(new Snake1(refLink, 270, 32));

        nuts = new ArrayList<Nut>();
        nuts.add(new Nut(refLink, 590, 196));
        nuts.add(new Nut(refLink, 1172, 36));
        nuts.add(new Nut(refLink, 1172, 548));
        nuts.add(new Nut(refLink, 584, 548));

        itemManager = new ItemManager(refLink, hero, snakes, nuts);
    }
}
