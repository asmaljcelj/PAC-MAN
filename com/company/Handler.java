package com.company;

import java.awt.*;
import java.util.LinkedList;

// update and render all objects
public class Handler {
    // loop over all objects, update them and put them on screen

    private LinkedList<GameObject> object = new LinkedList<>();

    void tick() {
        for (GameObject tempObject : object) {
            tempObject.tick();
        }
    }

    void render(Graphics g) {
        for (GameObject tempObject : object) {
            tempObject.render(g);
        }
    }

    void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}
