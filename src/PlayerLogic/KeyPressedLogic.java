package src.PlayerLogic;

import src.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressedLogic implements KeyListener {
    private Player player;

    public KeyPressedLogic(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.setDirection(0);
                break;
            case KeyEvent.VK_RIGHT:
                player.setDirection(1);
                break;
            case KeyEvent.VK_DOWN:
                player.setDirection(2);
                break;
            case KeyEvent.VK_LEFT:
                player.setDirection(3);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
