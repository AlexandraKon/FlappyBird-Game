package Game.GameFirst;

import Game.GameObjects.Bird;
import Game.handlers.ObjectHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.net.ServerSocket;

public class GameInit extends Canvas implements Runnable {

    public static final int WIDTH = 432;
    public static final int HEIGHT = 768;

    public boolean running;

    public static Bird bird;

    Thread thread;
    ServerSocket serverSocket;

    public static void main(String[] args) {
        new Window(WIDTH, HEIGHT, "FlappyBird", new GameInit());

    }
    public synchronized void start() {
        running = true;
        thread = new Thread();
        thread.start();
        run();
    }
    public void init() {
        bird = new Bird(360,360, 360, 264);
    }
    public void tick() {
        ObjectHandler.tick();

    }
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        ObjectHandler.render(g);
        g.dispose();
        bs.show();
    }
    @Override
    public void run() {
        init();
        this.requestFocus();

        long pastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - pastTime) / ns;
            pastTime = now;

            while (delta > 0) {
                tick();
                updates++;

                render();
                frames++;

                delta--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer +=1000;
                System.out.println("FPS: " +frames +"| TICKS " +updates);
                updates = 0;
                frames = 0;
            }
        }
    }
}