package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Menu.*;
import PaooGame.Menu.Button;
import PaooGame.RefLinks;

import java.awt.*;
import PaooGame.RefLinks;

import java.util.ArrayList;
import java.util.List;

public class HelpState extends State{
    private ButtonManager btnmng;
    public HelpState(RefLinks refLink) {
        super(refLink);
        List<Button> btnList = new ArrayList<Button>();
        btnList.add(new NullButton(refLink, 512, -128, 256, 64));
        btnList.add(new BackButton(refLink, 128, 48, 256, 64));
        btnmng = new ButtonManager(refLink, btnList);
    }

    @Override
    public void Update() {
        btnmng.Update();
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.blueBackground, 0, 0, 1280, 640, null);
        g.drawImage(Assets.story, 128, 144, 1024, 450, null);

        btnmng.Draw(g);
    }

    @Override
    public void resetState() {

    }
}
