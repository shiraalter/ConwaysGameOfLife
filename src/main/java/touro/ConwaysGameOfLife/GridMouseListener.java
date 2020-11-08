package touro.ConwaysGameOfLife;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GridMouseListener implements MouseListener {

    private Grid grid;
    int x;
    int y;
    boolean[][] board;


    public GridMouseListener(Grid grid) {
        this.grid = grid;
        board = grid.getBoard();
    }

//    public void setCellCords(int x, int y){
//        this.x = x;
//        this.y = y;
//
//    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        boolean cellValue = board[x][y];
        System.out.println("x = " + x + " y = " + y + " val was = " + board[x][y]);
        if(cellValue) grid.setDead(x,y);
        else grid.setAlive(x,y);
        System.out.println("is now: " + board[x][y]);

    }

    //Theres porb a better way to do this. look it up.
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("");
    }
}
