package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.State;

import java.awt.image.BufferedImage;

public class RestartButton extends Button{

    public RestartButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, Assets.restartButton, xpos, ypos, width, height);
    }

    @Override
    public void doAction() {
        if(refLink.GetGame().getCurrentLevel() == 1) {
            refLink.GetGame().resetLevel1();
            State.SetState(refLink.GetGame().getLevel1State());
        }
        else if(refLink.GetGame().getCurrentLevel() == 2) {
            refLink.GetGame().resetLevel2();
            State.SetState(refLink.GetGame().getLevel2State());
        }

    }
}
