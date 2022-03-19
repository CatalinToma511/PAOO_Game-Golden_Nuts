package PaooGame.Maps;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Level2Map implements Map {
    private RefLinks refLink;
    private int width; //latimea in nr de tileuri
    private int height; //inailtimea --//--
    private int [][] tiles; // matrea cu codificarea tileuri pentru harta
    private String mapPath = "res/maps/testlevelmap2";

    public Level2Map(RefLinks refLink){
        this.refLink = refLink;
        LoadWorld();
    }

    public void Update(){
    }

    public void Draw(Graphics g){
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++) {
            for (int x = 0; x < refLink.GetGame().GetWidth() / Tile.TILE_WIDTH; x++) {
                GetTile(x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
            }
        }
    }

    public Tile GetTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.PlatformTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.BackgroundTile;
        }
        return t;
    }

    private void LoadWorld(){
        width = 40;
        height = 20;
        int [][] map = ReadTestLevel() ;
        tiles = new int[width][height];
        for(int y = 0; y < height; ++y)
        {
            for(int x = 0; x < width; ++x)
            {
                tiles[x][y] = map[y][x];
            }
        }

    }

    private int [][] ReadTestLevel(){
        Scanner input = null;
        int [][] map = new int[height][width] ;
        try {
            input = new Scanner(new File(mapPath));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < height; ++i)
        {
            for(int j = 0; j < width; ++j)
            {
                if(input.hasNextInt())
                {
                    map[i][j] = input.nextInt();
                }

            }
        }
        return map;
    }
}
