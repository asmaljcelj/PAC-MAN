package src;

import java.awt.*;

public abstract class GameObject {
    int x, y;
    private ID id;
//     protected int velX, velY;
    double velocity;

    GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return this.id;
    }

    public void setVel(double vel) {
        this.velocity = vel;
    }

    public double getVel() {
        return this.velocity;
    }
    /*public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return this.velX;
    }
    public int getVelY() {
        return this.velY;
    }*/

}