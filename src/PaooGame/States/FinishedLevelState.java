package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Menu.*;
import PaooGame.Menu.Button;
import PaooGame.RefLinks;

import java.awt.*;
import PaooGame.RefLinks;

import java.util.ArrayList;
import java.util.List;

public class FinishedLevelState extends State{
    private ButtonManager btnmng1;
    public FinishedLevelState(RefLinks refLink) {
        super(refLink);

    }

    @Override
    public void resetState(){
        List<Button> btnList = new ArrayList<Button>();

        if(refLink.GetGame().getCurrentLevel() < refLink.GetGame().getMaxLevels()){

            //System.out.println(refLink.GetGame().getCurrentLevel() + " < " + refLink.GetGame().getMaxLevels());
            btnList.add(new NextLevelButton(refLink, 512, 256, 256, 64));
            //System.out.println("DRAGI TOVARASI");
        }
        btnList.add(new RestartButton(refLink, 512, 384, 256, 64));
        btnList.add(new BackToMenuButton(refLink, 512, 512, 256, 64));
        btnmng1 = new ButtonManager(refLink, btnList);
    }

    @Override
    public void Update() {

        btnmng1.Update();
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.grayBackground, 0, 0, 1280, 640, null);

        //g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
        double scor = refLink.getScor();
        int nivel = refLink.GetGame().getCurrentLevel();
        g.setColor(Color.YELLOW);
        g.fillRoundRect(270, 20, 764, 145, 20, 20);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Pixelated Regular", Font.BOLD, 52));
        g.drawString("AI TERMINAT NIVELUL " + nivel + " IN ", 340, 72);
        g.drawString(String.format("%.2f", scor) + " SECUNDE", 490, 134);
        btnmng1.Draw(g);
    }

}
