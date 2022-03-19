package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.State;

import java.awt.image.BufferedImage;

public class NextLevelButton extends Button{

    public NextLevelButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, Assets.nextLevelButton, xpos, ypos, width, height);
    }

    @Override
    public void doAction() {
        int currentLvl = refLink.GetGame().getCurrentLevel();
        switch(currentLvl){
            case 1:
                //System.out.println("NEXT LEVEL");
                refLink.GetGame().resetLevel1();
                State.SetState(refLink.GetGame().getLevel2State());
                break;
            default:
                State.SetState(refLink.GetGame().getMenuState());
                break;
        }
        //refLink.GetGame().resetLevel1();
        //State.SetState(refLink.GetGame().getMenuState());
        //State.SetState(refLink.GetGame().getMenuState());
    }
}
