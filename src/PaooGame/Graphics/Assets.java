package PaooGame.Graphics;

import PaooGame.Animations.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Assets {
    public static BufferedImage hero;
    public static BufferedImage platform;
    public static BufferedImage background;
    public static List<BufferedImage> idle_list;
    public static Idle idle;
    public static List<BufferedImage> walking_list;
    public static Walking walking;
    public static List<BufferedImage> jumping_list;
    public static Jumping jumping;
    public static List<BufferedImage> falling_list;
    public static Falling falling;
    public static List<BufferedImage> getsAttacked_list;
    public static GetsAttacked getsAttacked;
    public static List<BufferedImage> dying_list;
    public static Dying dying;
    public static BufferedImage playButton;
    public static BufferedImage selectButton;
    public static BufferedImage exitButton;
    public static BufferedImage resumeButton;
    public static List<BufferedImage> snake1_walking_list;
    public static Snake1Walking snake1_walking;
    public static List<BufferedImage> snake1_attacking_list;
    public static Snake1Attacking snake1_attacking;
    public static List<BufferedImage> snake2_walking_list;
    public static Snake2Walking snake2_walking;
    public static List<BufferedImage> snake2_attacking_list;
    public static Snake2Attacking snake2_attacking;
    public static BufferedImage nut;
    public static BufferedImage heart;
    public static BufferedImage apple;
    public static BufferedImage emptyHeart;
    public static BufferedImage restartButton;
    public static BufferedImage backToMenuButton;
    public static BufferedImage nextLevelButton;
    public static BufferedImage helpButton;
    public static BufferedImage backButton;
    public static BufferedImage logo;
    public static BufferedImage blueBackground;
    public static BufferedImage grayBackground;
    public static BufferedImage story;

    public static void Init(){
        SpriteSheet map = new SpriteSheet(ImageLoader.LoadImage("/textures/temporary_map.png"));
        SpriteSheet neculai = new SpriteSheet(ImageLoader.LoadImage("/textures/neculai.png"));
        SpriteSheet buttons = new SpriteSheet(ImageLoader.LoadImage("/textures/buttons.png"));
        SpriteSheet snake = new SpriteSheet(ImageLoader.LoadImage("/textures/snake.png"));
        SpriteSheet snake2 = new SpriteSheet(ImageLoader.LoadImage("/textures/snake2.png"));
        SpriteSheet things = new SpriteSheet(ImageLoader.LoadImage("/textures/things.png"));
        SpriteSheet mainlogo = new SpriteSheet(ImageLoader.LoadImage("/textures/mainlogo.png"));
        SpriteSheet backgrounds = new SpriteSheet(ImageLoader.LoadImage("/textures/backgrounds.png"));
        SpriteSheet sstory = new SpriteSheet(ImageLoader.LoadImage("/textures/story.png"));

        blueBackground = backgrounds.crop(0,0,4,4);
        grayBackground = backgrounds.crop(1,0,4,4);

        story = sstory.crop(0,0,1024,450);

        background = map.crop(1, 0);
        platform = map.crop(0, 0);
        hero = neculai.crop(0,0, 128, 64);
        idle_list = new ArrayList<BufferedImage>();
        idle_list.add(hero);
        idle_list.add(neculai.crop(1,0, 128, 64));
        idle_list.add(neculai.crop(2,0, 128, 64));
        idle_list.add(neculai.crop(3,0, 128, 64));
        idle_list.add(neculai.crop(4,0, 128, 64));
        idle_list.add(neculai.crop(5,0, 128, 64));
        idle_list.add(hero); //pentru o miscare mai placuta a animatiei, dublez primul frame
        idle = new Idle(idle_list);

        walking_list = new ArrayList<BufferedImage>();
        walking_list.add(neculai.crop(0,1, 128, 64));
        walking_list.add(neculai.crop(1,1, 128, 64));
        walking_list.add(neculai.crop(2,1, 128, 64));
        walking_list.add(neculai.crop(3,1, 128, 64));
        walking_list.add(neculai.crop(4,1, 128, 64));
        walking_list.add(neculai.crop(5,1, 128, 64));
        walking_list.add(neculai.crop(6,1, 128, 64));
        //walking_list.add(neculai.crop(7,1, 128, 64));
        walking = new Walking(walking_list);

        jumping_list = new ArrayList<BufferedImage>();
        jumping_list.add(walking_list.get(0));
        jumping_list.add(walking_list.get(1));
        //jumping_list.add(walking_list.get(2));
        jumping = new Jumping(jumping_list);

        falling_list = new ArrayList<BufferedImage>();
        falling_list.add(neculai.crop(6,0, 128, 64));
        falling = new Falling(falling_list);

        selectButton = buttons.crop(0,0, 256, 64);
        playButton = buttons.crop(0, 1, 256, 64);
        exitButton = buttons.crop(0,2, 256, 64);
        resumeButton = buttons.crop(0, 3, 256, 64);
        restartButton = buttons.crop(0, 4, 256, 64);
        backToMenuButton = buttons.crop(0, 5, 256, 64);
        nextLevelButton = buttons.crop(0, 6, 256, 64);
        helpButton = buttons.crop(0, 7, 256, 64);
        backButton = buttons.crop(0, 8, 256, 64);
        logo = mainlogo.crop(0,0, 512, 164);

        snake1_walking_list = new ArrayList<BufferedImage>();
        snake1_walking_list.add(snake.crop(0,0, 128, 64));
        snake1_walking_list.add(snake.crop(1,0, 128, 64));
        snake1_walking_list.add(snake.crop(2,0, 128, 64));
        snake1_walking_list.add(snake.crop(3,0, 128, 64));
        snake1_walking_list.add(snake.crop(4,0, 128, 64));
        snake1_walking_list.add(snake.crop(5,0, 128, 64));
        snake1_walking_list.add(snake.crop(6,0, 128, 64));
        snake1_walking_list.add(snake.crop(7,0, 128, 64));
        snake1_walking = new Snake1Walking(snake1_walking_list);

        snake1_attacking_list = new ArrayList<BufferedImage>();
        //snake1_attacking_list.add(snake.crop(0,1, 128, 64));
        //snake1_attacking_list.add(snake.crop(1,1, 128, 64));
        snake1_attacking_list.add(snake.crop(2,1, 128, 64));
        snake1_attacking_list.add(snake.crop(3,1, 128, 64));
        snake1_attacking_list.add(snake.crop(4,1, 128, 64));
        snake1_attacking_list.add(snake.crop(5,1, 128, 64));
        snake1_attacking = new Snake1Attacking(snake1_attacking_list);

        snake2_walking_list = new ArrayList<BufferedImage>();
        //snake2_walking_list.add(snake2.crop(0,0, 128, 64));
        //snake2_walking_list.add(snake2.crop(1,0, 128, 64));
        snake2_walking_list.add(snake2.crop(2,0, 128, 64));
        snake2_walking_list.add(snake2.crop(3,0, 128, 64));
        snake2_walking_list.add(snake2.crop(4,0, 128, 64));
        snake2_walking_list.add(snake2.crop(5,0, 128, 64));
        snake2_walking_list.add(snake2.crop(6,0, 128, 64));
        snake2_walking_list.add(snake2.crop(7,0, 128, 64));
        snake2_walking = new Snake2Walking(snake2_walking_list);

        snake2_attacking_list = new ArrayList<BufferedImage>();
        snake2_attacking_list.add(snake2.crop(0,1, 128, 64));
        snake2_attacking_list.add(snake2.crop(1,1, 128, 64));
        snake2_attacking_list.add(snake2.crop(2,1, 128, 64));
        snake2_attacking_list.add(snake2.crop(3,1, 128, 64));
        snake2_attacking_list.add(snake2.crop(4,1, 128, 64));
        snake2_attacking_list.add(snake2.crop(5,1, 128, 64));
        snake2_attacking = new Snake2Attacking(snake2_attacking_list);

        nut = things.crop(0,0,64, 64);
        heart = things.crop(1, 0, 64, 64);
        emptyHeart = things.crop(2, 0, 64, 64);
        apple = things.crop(3, 0, 64, 64);

        getsAttacked_list = new ArrayList<BufferedImage>();
        getsAttacked_list.add(neculai.crop(0, 2, 128, 64));
        getsAttacked_list.add(neculai.crop(1, 2, 128, 64));
        getsAttacked_list.add(neculai.crop(2, 2, 128, 64));
        getsAttacked_list.add(neculai.crop(3, 2, 128, 64));
        getsAttacked_list.add(neculai.crop(2, 2, 128, 64));
        getsAttacked = new GetsAttacked(getsAttacked_list);

        dying_list = new ArrayList<BufferedImage>();
        dying_list.add(neculai.crop(0, 3, 128, 64));
        dying_list.add(neculai.crop(1, 3, 128, 64));
        dying_list.add(neculai.crop(2, 3, 128, 64));
        dying = new Dying(dying_list);

        //g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));

        //incarca fontul:
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/res/font/pixelated.ttf")));
        } catch (IOException |FontFormatException e) {
            //Handle exception
        }
    }
}
