package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Animations.Animation;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public abstract class Snake extends  Character{

    private final int framesPerSecond = 60;
    private final double timeFrame = (float)1000000000 / framesPerSecond;
    private long currentTime = 0;
    private long jumpStartTime = 0;
    private Tile h1_ul, h1_ur, h1_bl, h1_br; //tileurile care contin coltul hitboxului pentru deplasat st-dr
    private Tile h2_ul, h2_ur, h2_bl, h2_br; //pentru deplasat sus-jos
    private int offset; //offset pentru hitbox
    protected boolean isAttacking;
    private boolean isGoingLeft;
    private int damage;
    public Snake(RefLinks refLink, float x, float y, int damage, float speed){
        super(refLink,
                x,
                y,
                128,
                64,
                speed);
        image = Assets.snake1_walking_list.get(1);
        anim = Assets.idle;
        normalBounds.x = 0;
        normalBounds.y = 64-52;
        normalBounds.width = 60;
        normalBounds.height = 52;
        offset = (int)speed*2;
        isGoingLeft = false;
        isAttacking = false;
        this.damage = damage;
    }

    @Override
    public void Update() {
        GetInput();
        UpdateAnimation();
        Move();
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

    private void GetInput(){

        xMove = 0;
        yMove = 0;
        currentTime = System.nanoTime();

        //miscare stanga-dreapta
        updateTiles();
        if(!isGoingLeft){
            if(!h1_bl.IsSolid() && !h1_ul.IsSolid() && h2_bl.IsSolid() && !isAttacking) //merge daca nu ataca, se poate deplasa fara sa intre in tileuri si coltul inca este pe un tile solid
            {
                xMove = -speed;
                isGoingLeft = false;
            }
            else{
                isGoingLeft = true;
            }
        }
        if(isGoingLeft){
            if(!h1_br.IsSolid() && !h1_ur.IsSolid() && h2_br.IsSolid() && !isAttacking)
            {
                xMove = speed;
                isGoingLeft = true;
            }
            else{
                isGoingLeft = false;
            }
        }

        //System.out.println(h2_ul.IsSolid() + " " + h2_ur.IsSolid() + " " + h2_bl.IsSolid() + " " + h2_br.IsSolid());

    }



    protected abstract void UpdateAnimation();

    public void startAttack(){
        if(!isAttacking){
            isAttacking = true;
        }
    }

    @Override
    public void Draw(Graphics g) {
        if(isGoingLeft) {
            g.drawImage(image, (int) x - 32, (int) y, width, height, null);
        }
        else{
            g.drawImage(image, (int) x + width - 32, (int) y, -width, height, null);
        }
        //.setColor(Color.CYAN);
        //g.drawRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

    public int getDamage(){
        return this.damage;
    }
}
