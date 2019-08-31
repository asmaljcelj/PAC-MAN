package src;

import src.PlayerLogic.KeyPressedLogic;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private static final int WIDTH = 464;
    private static final int HEIGHT = 535;

    private Thread thread;
    private boolean running = false;

    private Handler handler;

    private Game() {
        Window gameWindow = new Window(WIDTH, HEIGHT, "PAC-man", this);

        handler = new Handler();

        Player player = new Player(0, 0, ID.Player, gameWindow.getFrame().getContentPane().getWidth(), gameWindow.getFrame().getContentPane().getHeight());
        this.addKeyListener(new KeyPressedLogic(player));

        handler.addObject(player);
    }

    synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // gameloop: copied from Notch
        long lastTime = System.nanoTime();
        double ammountOfTicks = 60.0;
        double ns = 1000000000 / ammountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: "+frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();

    }

    public static void main(String[] args) {
        new Game();
    }
}
