package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

public class Snake2 extends Snake{

    public Snake2(RefLinks refLink, float x, float y) {
        super(refLink, x, y, 2, DEFAULT_SPEED*1);
    }

    @Override
    protected void UpdateAnimation(){
        if(life == 0){
            //animatia de murit
        }

        if(xMove != 0 && !isAttacking){ //se misca in lateral
            PlayAnimation(Assets.snake2_walking);
        }
        else if(isAttacking){
            PlayAnimation(Assets.snake2_attacking);

            if(Assets.snake2_attacking.hasFinished()){
                isAttacking = false;
            }
        }
    }
}
