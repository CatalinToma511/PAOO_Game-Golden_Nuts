package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.State;

public class HelpButton extends Button{

    public HelpButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, Assets.helpButton, xpos, ypos, width, height);
    }

    @Override
    public void doAction() {
        State.SetState(refLink.GetGame().getHelpState());
    }
}
