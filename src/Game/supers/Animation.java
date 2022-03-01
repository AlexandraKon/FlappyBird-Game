package Game.supers;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {
    private int x;
    private int y;
    private int currentImage;

    private long delay;
    private long startTime;

    private boolean loop;
    private boolean running;

    private GameObject target;
    private BufferedImage[] images;

    public Animation(GameObject target, long delay, boolean loop, BufferedImage[] images) {
        this.x = target.getX();
        this.y = target.getY();
        this.currentImage = 0;
        this.delay = delay;
        this.startTime = 0;
        this.loop = loop;
        this.setTarget(target);
        this.images = images;
    }

    private void setTarget(GameObject target) {
    }

    public Animation(GameObject target, int x, int y, long delay, boolean loop, BufferedImage[] images) {
        this.x = target.getX() + x;
        this.y = target.getY() + y;
        this.currentImage = 0;
        this.delay = delay;
        this.startTime = 0;
        this.loop = loop;
        this.setTarget(target);
        this.images = images;
    }

    public Animation(int x, int y, long delay, boolean loop, BufferedImage[] images) {
        this.x = x;
        this.y = y;
        this.currentImage = 0;
        this.delay = delay;
        this.startTime = 0;
        this.loop = loop;
        this.setTarget(null);
        this.images = images;
    }

    public void render (Graphics g) {

        if (target == null) {
            g.drawImage(images[currentImage], x, y, null);
        }else {
            g.drawImage(images[currentImage], x + target.x, y + target.y, null);
        }
    }

    public void tick() {
        long pastTime = (System.nanoTime() - startTime) /1000000;

        if (pastTime >= delay && running) {
            currentImage++;
            startTime = System.nanoTime();
        }
        if (currentImage == images.length) {
            currentImage = 0;

            if (!loop) {
                stop();
            }
        }
    }

    public void start() {
      this.running = true;
      this.currentImage = 0;
      this.startTime = 0;
    }

    public void stop() {
        this.running = false;
        this.currentImage = 0;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(int currentImage) {
        this.currentImage = currentImage;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay (long delay) {
        this.delay = delay;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop ) {
        this.loop=loop;
    }
}