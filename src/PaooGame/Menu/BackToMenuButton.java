package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.State;

import java.awt.image.BufferedImage;

public class BackToMenuButton extends Button{

    public BackToMenuButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, Assets.backToMenuButton, xpos, ypos, width, height);

    }

    @Override
    public void doAction() {
        refLink.GetGame().resetLevel1();
        refLink.GetGame().resetLevel2();
        State.SetState(refLink.GetGame().getMenuState());
    }
}
