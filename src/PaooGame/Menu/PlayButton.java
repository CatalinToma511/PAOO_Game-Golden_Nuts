package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.State;

import java.awt.image.BufferedImage;

public class PlayButton extends Button{

    public PlayButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, Assets.playButton, xpos, ypos, width, height);
    }

    @Override
    public void doAction() {
        refLink.GetGame().getMenuState().resetState();
        State.SetState(refLink.GetGame().getLevel1State());
    }
}
