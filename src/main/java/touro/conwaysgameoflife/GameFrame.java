package touro.conwaysgameoflife;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Grid grid;
    private GridView gridView;
    private JPanel panel;
    private JButton clear;
    private JButton next;
    private JButton play;
    private int delay = 200;

    public GameFrame(GridView gridView, Grid grid) {
        this.grid = grid;
        this.gridView = gridView;

        setSize(420, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        clear = new JButton("Clear");
        clear.addActionListener(actionEvent -> reset());
        next = new JButton("Next >");
        next.addActionListener(actionEvent -> nextMove());
        play = new JButton("Play \u25B6");
        play.addActionListener(actionEvent -> playLoop());
        panel = new JPanel(new FlowLayout());

        panel.add(clear);
        panel.add(next);
        panel.add(play);

        add(gridView);
        add(panel, BorderLayout.SOUTH);

    }

    private void playLoop() {
        Thread thread = new Thread(() -> {
            while (true) {
                grid.makeMove();
                gridView.repaint();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void nextMove() {
        grid.makeMove();
        gridView.repaint();
    }

    private void reset() {
        grid.clearBoard();
        gridView.repaint();
    }
}