package PaooGame.Menu;

import PaooGame.Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuBackground {
    private static final BufferedImage menuBckgnd = Assets.background;
    public static void Draw(Graphics g){
        g.drawImage(menuBckgnd, 0, 0, 1280, 640, null);
    }
}