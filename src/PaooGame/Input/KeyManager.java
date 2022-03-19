package PaooGame.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyManager extends KeyAdapter {
    private boolean[] keys;
    public boolean jump;
    public boolean left;
    public boolean right;
    public boolean enter;
    public boolean down;
    public boolean esc;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void Update(){ //se actualizeaza starea tastelor
        jump = keys[KeyEvent.VK_W];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        down = keys[KeyEvent.VK_S];
        enter = keys[KeyEvent.VK_ENTER];
        esc = keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true; //tasta apasata
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false; //tasta "dezapasata"
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
