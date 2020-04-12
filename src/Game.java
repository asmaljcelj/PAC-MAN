package src;

import src.map.Grid;
import src.playerLogic.KeyPressedLogic;
import src.enums.IDEnum;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public static final int FRAME_WIDTH = 700;
    public static final int FRAME_HEIGHT = 700;
    public static final int COLUMNS = 20;
    public static final int ROWS = 20;

    private Thread thread;
    private boolean running = false;

    private Handler handler;

    private Game() {
        Window.createWindow(FRAME_WIDTH, FRAME_HEIGHT, "PAC-man", this);

        handler = new Handler();

        Grid gameGrid = new Grid(ROWS, COLUMNS, calculateSingleCellWidth(), calculateSingleCellHeight());

        Player player = new Player(gameGrid.getSpecificCell(0, 0), IDEnum.Player);
        this.addKeyListener(new KeyPressedLogic(player));

        handler.addObject(player);
    }

    private int calculateSingleCellWidth() {
        return FRAME_WIDTH / COLUMNS;
    }

    private int calculateSingleCellHeight() {
        return FRAME_HEIGHT / ROWS;
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
        double amountOfTicks = 2.0;
        double ns = 1000000000 / amountOfTicks;
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
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();

    }

    public static void main(String[] args) {
        new Game();
    }
}
