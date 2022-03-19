package PaooGame.Graphics;
import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage       spriteSheet;
    private static final int    tileWidth   = 64;
    private static final int    tileHeight  = 64;

    public SpriteSheet(BufferedImage buffImg) {
        spriteSheet = buffImg;
    }

    public BufferedImage crop(int x, int y){
        return spriteSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }

    public BufferedImage crop(int x, int y, int width, int height){
        return spriteSheet.getSubimage(x * width, y * height, width, height);
    }
}
