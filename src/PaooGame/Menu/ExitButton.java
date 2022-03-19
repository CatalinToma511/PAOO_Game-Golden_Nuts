package PaooGame.Menu;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.image.BufferedImage;

public class ExitButton extends Button{

    public ExitButton(RefLinks refLink, int xpos, int ypos, int width, int height) {
        super(refLink, Assets.exitButton, xpos, ypos, width, height);
    }

    @Override
    public void doAction() {
        System.exit(0);
    }
}