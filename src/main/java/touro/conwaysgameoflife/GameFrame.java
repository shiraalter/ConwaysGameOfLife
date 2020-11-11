package touro.conwaysgameoflife;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameFrame extends JFrame {

    private AtomicBoolean paused;
    private Grid grid;
    private GridView gridView;
    private Thread thread;
    private JPanel panel;
    private JButton clear;
    private JButton playPause;
    private JButton next;

    public GameFrame(GridView gridView, Grid grid) {
        this.grid = grid;
        this.gridView = gridView;
        paused = new AtomicBoolean(false);

        setSize(420, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        initComponents();

        add(gridView);
        add(panel, BorderLayout.SOUTH);

    }

    private void initComponents() {
        clear = new JButton("Clear");
        clear.addActionListener(actionEvent -> reset());
        playPause = new JButton("Play \u25b6");
        playPause.addActionListener(actionEvent -> changeButton());
        playPause.addActionListener(actionEvent -> playGame());
        next = new JButton("Next >");
        next.addActionListener(actionEvent -> nextMove());
        panel = new JPanel(new FlowLayout());

        panel.add(clear);
        panel.add(playPause);
        panel.add(next);
    }

    private void nextMove() {
        grid.makeMove();
        gridView.repaint();
    }

    private void changeButton() {
        if (!paused.get()) {
            playPause.setText("Pause \u23F8");
            paused.set(true);
        } else {
            playPause.setText("Play \u25b6");
            paused.set(false);

            //resume
            synchronized (thread) {
                thread.notify();
            }
        }
    }

    private void playGame() {
        //runnable that plays game continuously
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(paused.get()) {
                        synchronized (thread) {
                            //pause
                            try {
                                thread.wait();;
                            } catch (InterruptedException e){
                            }
                        }
                    }
                    //play game
                    grid.makeMove();

                    //sleep
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                    }
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    private void reset() {
        grid.clearBoard();
        gridView.repaint();
    }
}