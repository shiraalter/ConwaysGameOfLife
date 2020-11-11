package touro.conwaysgameoflife;

import javax.swing.*;

public class LifeGameMain {
    public static void main(String[] args) {

        Grid grid = new Grid();
        GridView gridView = new GridView(grid);
        new GameFrame(gridView,grid).setVisible(true);

//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new GameFrame(gridView, grid).setVisible(true);
//            }
//        });
    }
}
