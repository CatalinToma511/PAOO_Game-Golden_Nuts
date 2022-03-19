package PaooGame.Hud;

import PaooGame.Items.Hero;
import PaooGame.RefLinks;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Hud {
    private int life;
    private RefLinks refLinks;
    private int x1, x2, x3;
    private int y;
    private int timer;
    private double scor;
    public Hud(RefLinks refLinks){
        this.refLinks = refLinks;
    }

    public void Update(Hero neculai){
        life = neculai.GetLife();
        timer = neculai.getTimer();
    }

    public void Draw(Graphics g){
        switch(life) {
            case 0:
                Heart.Draw(g, false, 32, 32);
                Heart.Draw(g, false, 96, 32);
                Heart.Draw(g, false, 160, 32);
                break;
            case 1:
                Heart.Draw(g, true, 32, 32);
                Heart.Draw(g, false, 96, 32);
                Heart.Draw(g, false, 160, 32);
                break;
            case 2:
                Heart.Draw(g, true, 32, 32);
                Heart.Draw(g, true, 96, 32);
                Heart.Draw(g, false, 160, 32);
                break;
            case 3:
                Heart.Draw(g, true, 32, 32);
                Heart.Draw(g, true, 96, 32);
                Heart.Draw(g, true, 160, 32);
                break;
            default:
                break;
        }

        g.setColor(Color.WHITE);

        g.setFont(new Font("Pixelated Regular", Font.BOLD, 38));
        scor = (float)timer/60;
        refLinks.setScor(scor);
        g.drawString("TIME: " + String.format("%.2f", scor), 230, 72);
    }

    public double getScor(){
        return scor;
    }


}
