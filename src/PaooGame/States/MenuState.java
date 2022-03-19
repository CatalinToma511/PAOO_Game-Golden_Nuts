package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Menu.*;
import PaooGame.Menu.Button;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import PaooGame.RefLinks;

public class MenuState extends State{
    private ButtonManager btnmng;
    private BufferedImage logo;
    public MenuState(RefLinks refLink) {
        super(refLink);
        List<Button> buttonList = new ArrayList<Button>();
        buttonList.add(new NullButton(refLink, 512, -128, 256, 64)); //ajuta atunci cand se apasa BackToMainMenu sa nu deschida direct PLAY
        buttonList.add(new PlayButton(refLink, 512, 256, 256, 64));
        buttonList.add(new HelpButton(refLink, 512, 384, 256, 64));
        buttonList.add(new ExitButton(refLink, 512, 512, 256, 64));
        btnmng = new ButtonManager(refLink, buttonList);
        logo = Assets.logo;
    }

    @Override
    public void Update() {
        btnmng.Update();
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.blueBackground, 0, 0, 1280, 640, null);
        btnmng.Draw(g);
        g.drawImage(logo, 384, 48, 512, 164, null);//deseneaza logo

    }

    @Override
    public void resetState() {
        btnmng.setCurrentButton(0);
    }
}
