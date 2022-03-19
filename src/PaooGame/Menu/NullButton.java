package PaooGame.Menu;

import PaooGame.RefLinks;

import java.awt.image.BufferedImage;

public class NullButton extends Button{
    public NullButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, null, xpos, ypos, width, height);
    }

    @Override
    public void doAction() {
        //do nothing
    }
}
