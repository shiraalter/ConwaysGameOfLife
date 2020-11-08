package touro.ConwaysGameOfLife;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    Grid grid;

    private JPanel panel;
    private JButton clear;
    private JButton play;
    private JButton next;

    public GameFrame(GridView gridView, GridMouseListener mouseListener) {
        setSize(1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        clear = new JButton("Clear");
        clear.addActionListener(actionEvent -> reset());
        play = new JButton("Play");
        play.addActionListener(actionEvent -> playGame());
        next = new JButton("Next >");
        next.addActionListener(actionEvent -> nextMove());
        panel = new JPanel(new FlowLayout());
        panel.add(clear);
        panel.add(play);
        panel.add(next);

        add(gridView, BorderLayout.CENTER);
        addMouseListener(mouseListener);
        add(panel, BorderLayout.SOUTH);
    }

    private void nextMove() {
        //does this make continuous moves or a single move?
        //grid.makeMove();
    }

    private void playGame() {
        //does this make continuous moves or a single move?
        //grid.makeMove();
    }

    private void reset() {
        grid.setDead(getX(),getY());
    }
}