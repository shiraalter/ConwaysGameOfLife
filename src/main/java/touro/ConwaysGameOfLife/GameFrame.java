package touro.ConwaysGameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class GameFrame extends JFrame {

    private JPanel panel;
    private JButton clear;
    private JButton play;
    private JButton next;
    private JPanel viewPanel;
    private GridMouseListener mouseListener;
    private GridView gridView;
    private Grid grid;
    public GameFrame( GridView gridView, Grid grid, GridMouseListener mouseListener) {
        mouseListener = mouseListener;
        gridView = gridView;
        grid = grid;

        setSize(400, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        clear = new JButton("Clear");
        play = new JButton("Play");
        next = new JButton("Next >");
        panel = new JPanel(new FlowLayout());


        panel.add(clear);
        panel.add(play);
        panel.add(next);

        add(gridView);
//        addMouseListener(mouseListener);
        add(panel, BorderLayout.SOUTH);

    }

}