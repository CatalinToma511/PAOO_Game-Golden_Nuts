package PaooGame.Items;

import java.awt.*;

import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

public class Hero extends  Character{
    private long jumpStartTime = 0;
    private Tile h1_ul, h1_ur, h1_bl, h1_br; //tileurile care contin coltul hitboxului pentru deplasat st-dr
    private Tile h2_ul, h2_ur, h2_bl, h2_br; //pentru deplasat sus-jos
    private int offset; //offset pentru hitboxrile mele dubioase
    private boolean isJumping;
    private boolean isGoingLeft;
    private boolean isAttacked;
    private long lastAttackedTime;
    private long deadTime;
    private int timer;
    public Hero(RefLinks refLink, float x, float y){
        super(refLink,
                x,
                y,
                128,
                64,
                DEFAULT_SPEED*1.75f);
        framesPerAnim = 5;
        image = Assets.hero;
        anim = Assets.idle;
        normalBounds.x = 0;
        normalBounds.y = 64-52;
        normalBounds.width = 60;
        normalBounds.height = 52;
        offset = (int)speed*2;
    }

    private void updateTimer(){
        timer ++;
    }

    @Override
    public void Update() {
        updateTimer();
        GetInput();
        UpdateAnimation();
        Move();
        //aici animatia
    }

    private void updateTiles(){
        h1_ul = refLink.GetMap().GetTile((int)((x + normalBounds.x)/32), (int)((y + normalBounds.y + offset)/32));
        h1_ur = refLink.GetMap().GetTile((int)((x + normalBounds.x + normalBounds.width)/32), (int)((y + normalBounds.y + offset)/32));
        h1_bl = refLink.GetMap().GetTile((int)((x + normalBounds.x )/32), (int)((y + normalBounds.y + normalBounds.height - offset)/32));
        h1_br = refLink.GetMap().GetTile((int)((x + normalBounds.x + normalBounds.width)/32), (int)((y + normalBounds.y + normalBounds.height - offset)/32));

        h2_ul = refLink.GetMap().GetTile((int)((x + normalBounds.x + offset)/32), (int)((y + normalBounds.y)/32));
        h2_ur = refLink.GetMap().GetTile((int)((x + normalBounds.x + normalBounds.width - offset)/32), (int)((y + normalBounds.y)/32));
        h2_bl = refLink.GetMap().GetTile((int)((x + normalBounds.x + offset)/32), (int)((y + normalBounds.y + normalBounds.height)/32));
        h2_br = refLink.GetMap().GetTile((int)((x + normalBounds.x + normalBounds.width - offset)/32), (int)((y + normalBounds.y + normalBounds.height)/32));
    }

    private boolean canJump(){

        return (h2_bl.IsSolid() || h2_br.IsSolid()); //sta pe ceva solid
    }

    private boolean isAlive(){
        return life > 0;
    }

    private void GetInput(){
        xMove = 0;
        yMove = 0;

        updateTiles();

        if(refLink.GetKeyManager().jump && canJump() && !isJumping)
        {
            jumpStartTime = refLink.getCurrentTime();
            isJumping = true;
        }

        if(isAlive() && !isAttacked) {
            if ((refLink.getCurrentTime() - jumpStartTime < refLink.getTimeFrame() * 24)
                    && isJumping && (refLink.GetKeyManager().jump ||
                    (refLink.getCurrentTime() - jumpStartTime < refLink.getTimeFrame() * 12))) { //saritura dureaza x frameuri, e apasata tasta W si trebuie sa dureze minim y sec
                if (!h2_ul.IsSolid() && !h2_ur.IsSolid()) { //se poate duce in sus
                    yMove = -speed * 1.5f;
                } else {
                    isJumping = false;
                }
            } else {
                isJumping = false;
            }
        }

        if(yMove == 0 && !h2_bl.IsSolid() && !h2_br.IsSolid()) //nu primeste sarit in sus, aplicam gravitatia
        {
            yMove = speed * 1.75f;
        }

        if(isAlive() && !isAttacked) {
            if (refLink.GetKeyManager().left && !h1_bl.IsSolid() && !h1_ul.IsSolid()) {
                xMove = -speed;
                isGoingLeft = true;
            }
            if (refLink.GetKeyManager().right && !h1_br.IsSolid() && !h1_ur.IsSolid()) {
                xMove = speed;
                isGoingLeft = false;
            }
            //System.out.println(h2_ul.IsSolid() + " " + h2_ur.IsSolid() + " " + h2_bl.IsSolid() + " " + h2_br.IsSolid());
        }

        if((refLink.getCurrentTime() - deadTime >= 60 * refLink.getTimeFrame()) && !isAlive()){
            State.SetState(refLink.GetGame().getDeadScreenState());
        }

    }

    private void UpdateAnimation(){
        if(isAlive()) {
            if (isAttacked) {
                PlayAnimation(Assets.getsAttacked);
                if (this.anim.hasFinished()) {
                    isAttacked = false;
                    speed = DEFAULT_SPEED*1.75f;
                }
            }
            if (!isAttacked) {
                if (xMove == 0 && yMove == 0) { //daca sta pe loc
                    PlayAnimation(Assets.idle);
                } else if (xMove != 0 && yMove == 0) { //se misca in lateral
                    PlayAnimation(Assets.walking);
                } else if (yMove < 0) { //sare
                    PlayAnimation(Assets.jumping);
                } else if (yMove > 0) { //cade
                    PlayAnimation(Assets.falling);
                }
            }
        }
        else{
            PlayAnimation(Assets.dying);
        }
    }

    public void takeDamage(int dmg){
        if(this.canTakeDamage()){
            lastAttackedTime = refLink.getCurrentTime();
            if(this.life - dmg <= 0 && this.life > 0){
                deadTime = refLink.getCurrentTime();
            }
            this.life -= dmg;
            if(this.life < 0){
                this.life = 0;
            }
            isAttacked = true;
            speed = speed/2;
        }
    }



    @Override
    public void Draw(Graphics g) {
        if(!isGoingLeft) {
            g.drawImage(image, (int) x - 32, (int) y, width, height, null);
        }
        else{
            g.drawImage(image, (int) x + width - 32, (int) y, -width, height, null);
        }
        //g.drawString("Neculai", (int)x+5, (int)y - 5);
        //g.setColor(Color.MAGENTA);
        //g.drawRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        //System.out.println(x+ " " + y);
    }

    public boolean canTakeDamage(){
        return refLink.getCurrentTime() - lastAttackedTime > 100 * refLink.getTimeFrame();
    }

    public int getTimer(){
        return timer;
    }
}
