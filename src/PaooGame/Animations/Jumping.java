package PaooGame.Animations;

import java.awt.image.BufferedImage;
import java.util.List;

public class Jumping extends Animation{
    public Jumping(List<BufferedImage> frames) {
        super(frames);
    }

    public BufferedImage getNextFrame(){  //caz special, executa primele frame-uri, apoi trebuie sa afiseze doar ultimul frame
        currentFrame++;
        if(currentFrame >= this.frames.size()){
            currentFrame = this.frames.size() - 1;
        }
        return this.frames.get(currentFrame);
    }
}
