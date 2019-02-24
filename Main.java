package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;


    private Canvas canvas;
    public Main() {
        Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        Container cp = getContentPane();
        cp.add(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setTitle("PAC MAN 1.0");
        // TODO: scalable with height and size
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class Canvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}


