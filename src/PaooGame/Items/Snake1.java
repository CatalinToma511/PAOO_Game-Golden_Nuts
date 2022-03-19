package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

public class Snake1 extends Snake{

    public Snake1(RefLinks refLink, float x, float y) {
        super(refLink, x, y, 1, DEFAULT_SPEED*0.75f);
    }

    @Override
    protected void UpdateAnimation(){
        if(life == 0){
            //animatia de murit
        }

        if(xMove != 0 && !isAttacking){ //se misca in lateral
            PlayAnimation(Assets.snake1_walking);
        }
        else if(isAttacking){
            PlayAnimation(Assets.snake1_attacking);

            if(Assets.snake1_attacking.hasFinished()){
                isAttacking = false;
            }
        }
    }
}
