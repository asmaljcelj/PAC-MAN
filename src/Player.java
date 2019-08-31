package src;

import java.awt.*;

public class Player extends GameObject {
    // direction: 0-up, 1-right, 2-down, 3-left
    private int direction;
    private int windowWidth;
    private int windowHeight;

    public Player(int x, int y, ID id, int width, int height) {
        super(x, y, id);
        velocity = 0.5;
        // default direction
        this.direction = 1;
        this.windowWidth = width;
        this.windowHeight = height;
    }

    @Override
    public void tick() {
        int movementIncrement = 8;
        switch (direction) {
            case 0:
                if (getY() > 0) {
                    setY(getY() - movementIncrement);
                }
                break;
            case 1:
                if (getX() < windowWidth - 16) {
                    setX(getX() + movementIncrement);
                }
                break;
            case 2:
                if (getY() < windowHeight - 16) {
                    setY(getY() + movementIncrement);
                }
                break;
            case 3:
                if (getX() > 0) {
                    setX(getX() - movementIncrement);
                }
                break;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 16, 16);
    }

    public void setDirection(int dir) {
        this.direction = dir;
    }

    public int getDirection() {
        return this.direction;
    }

}
