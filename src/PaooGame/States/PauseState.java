package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Menu.*;
import PaooGame.Menu.Button;
import PaooGame.RefLinks;

import java.awt.*;
import PaooGame.RefLinks;

import java.util.ArrayList;
import java.util.List;

public class PauseState extends State{
    private ButtonManager btnmng;
    public PauseState(RefLinks refLink) {
        super(refLink);
        List<Button> btnList = new ArrayList<Button>();
        btnList.add(new ResumeButton(refLink, 512, 128, 256, 64));
        btnList.add(new RestartButton(refLink, 512, 256, 256, 64));
        btnList.add(new BackToMenuButton(refLink, 512, 384, 256, 64));
        btnmng = new ButtonManager(refLink, btnList);
    }

    @Override
    public void Update() {
        btnmng.Update();
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.grayBackground, 0, 0, 1280, 640, null);
        btnmng.Draw(g);
    }

    @Override
    public void resetState() {
        btnmng.setCurrentButton(0);
    }
}
