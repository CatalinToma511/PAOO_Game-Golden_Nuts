package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Ref;

abstract public class Button {
    private BufferedImage buttonimg;
    private int xpos;
    private int ypos;
    private int width;
    private int height;
    protected RefLinks refLink;
    public Button(RefLinks refLink, BufferedImage img, int xpos, int ypos, int width, int height){
        this.refLink = refLink;
        this.buttonimg = img;
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    public void Draw(Graphics g){
        g.drawImage(buttonimg, xpos, ypos, width, height, null);
    }

    public void DrawSelected(Graphics g){
        g.drawImage(Assets.selectButton, xpos, ypos, width, height, null);
    }

    public abstract void doAction();
}
