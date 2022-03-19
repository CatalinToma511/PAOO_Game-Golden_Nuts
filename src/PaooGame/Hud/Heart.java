package PaooGame.Hud;

import PaooGame.Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Heart {
    private BufferedImage img;
    public static void Draw(Graphics g, Boolean isFull, int x, int y) {
        if (isFull) {
            g.drawImage(Assets.heart, x, y, 64, 64, null);
        }
        else{
            g.drawImage(Assets.emptyHeart, x, y, 64, 64, null);
        }
    }
}
