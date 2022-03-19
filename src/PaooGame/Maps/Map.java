package PaooGame.Maps;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Map {

    public void Update();

    public void Draw(Graphics g);

    public Tile GetTile(int x, int y);

    //private void LoadWorld();

    //private int [][] ReadTestLevel();
}
