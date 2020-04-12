package src.playerLogic;

import src.Player;
import src.enums.DirectionEnum;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressedLogic implements KeyListener {
    private Player player;

    public KeyPressedLogic(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // empty because not needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.setDirection(DirectionEnum.UP);
                break;
            case KeyEvent.VK_RIGHT:
                player.setDirection(DirectionEnum.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                player.setDirection(DirectionEnum.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                player.setDirection(DirectionEnum.LEFT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
