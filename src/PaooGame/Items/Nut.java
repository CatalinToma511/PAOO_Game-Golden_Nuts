package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Nut extends Item{
    private BufferedImage img;
    private final int framesPerSecond = 60;
    private final double timeFrame = (float)1000000000 / framesPerSecond;
    private float currentTime = 0, lastMoveTime = 0;
    private float move = 3;
    public Nut(RefLinks refLink, float x, float y){
        super(refLink, x, y, 64, 64);
        img = Assets.nut;
        offBx = 10;
        offBy = 10;
    }

    @Override
    public void Update() {
        //miscam putin
        currentTime = System.nanoTime();
        if(currentTime - lastMoveTime > 20 * timeFrame){
            lastMoveTime = currentTime;
            move = -move;
            y += move;
        }
        //verific coliziunea
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(img, (int) x, (int) y, width, height, null);
        //g.setColor(Color.YELLOW);
        //g.drawRect((int)(x + bounds.x + offBx), (int)(y + bounds.y + offBy), bounds.width - 2*offBx, bounds.height - 2*offBy);
    }

}
