package com.company;

import java.awt.*;

public class Player extends GameObject {
    public Player(int x, int y, ID id) {
        super(x, y, id);
        velocity = 1;
    }

    @Override
    public void tick() {
        if (this.desno)
            x+=velocity;
        else
            x-=velocity;
        if (x > 750) {
            this.desno = false;
        } else if (x <= 0) {
            this.desno = true;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 32, 32);
    }
}
