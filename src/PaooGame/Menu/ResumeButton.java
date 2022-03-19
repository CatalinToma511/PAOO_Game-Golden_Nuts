package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.State;

public class ResumeButton extends Button{

    public ResumeButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, Assets.resumeButton, xpos, ypos, width, height);
    }

    @Override
    public void doAction() {
        State.SetState(State.GerPreviousState());
    }
}
