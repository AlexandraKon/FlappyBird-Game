package Game.GameObjects;

import Game.handlers.ObjectHandler;
import Game.loaders.GraphicsLoader;
import Game.supers.Animation;
import Game.supers.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird extends GameObject {

    Animation animation;

    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);

        BufferedImage[] images = new BufferedImage[3];

        for (int i = 0; i < images.length; i++) {
            images[i] = GraphicsLoader.loadGraphics("bird" + i + ".png");
        }

        animation = new Animation(this, 300, true, images);
        animation.start();

        ObjectHandler.addObject(this);
    }

    @Override
    public void tick() {
        animation.tick();
    }

    @Override
    public void render(Graphics g) {
        animation.render(g);
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
