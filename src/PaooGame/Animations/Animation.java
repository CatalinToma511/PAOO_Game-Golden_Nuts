package PaooGame.Animations;
import java.util.*;
import java.awt.image.BufferedImage;

public abstract class Animation{
    protected List<BufferedImage> frames;
    protected int currentFrame = -1; // asta stie care e frameul curent, tot asta ne foloseste si ca sa trecem la urmatorul frame

    public Animation(List<BufferedImage> frames){
        this.frames = frames;
    }

    public BufferedImage getNextFrame(){
        currentFrame++;
        if(currentFrame >= this.frames.size()){
            currentFrame -= this.frames.size(); // sa nu iasa current frame din dimensiunea listei
        }
        return this.frames.get(currentFrame);
    }

    public boolean hasFinished(){
        return currentFrame == frames.size() - 1;
    }

    public int getCurrentFrame(){
        return currentFrame;
    }

    public void resetCurrentFrame(){
        currentFrame = -1;
    }
}