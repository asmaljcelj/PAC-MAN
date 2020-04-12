package src;

import src.enums.IDEnum;
import src.map.Cell;

import java.awt.*;

public abstract class GameObject {
//    int x, y;
    protected Cell currentCell;
    private IDEnum idEnum;
    private double velocity;

//    GameObject(int x, int y, IDEnum idEnum) {
//        this.x = x;
//        this.y = y;
//        this.idEnum = idEnum;
//
//    }


    public GameObject(Cell currentCell, IDEnum idEnum, double velocity) {
        this.currentCell = currentCell;
        this.idEnum = idEnum;
        this.velocity = velocity;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    //    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public int getX() {
//        return this.x;
//    }
//
//    public int getY() {
//        return this.y;
//    }

    public void setIdEnum(IDEnum idEnum) {
        this.idEnum = idEnum;
    }

    public IDEnum getIdEnum() {
        return this.idEnum;
    }

    public void setVelocity(double vel) {
        this.velocity = vel;
    }

    public double getVelocity() {
        return this.velocity;
    }

}
