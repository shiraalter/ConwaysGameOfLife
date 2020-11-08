package touro.ConwaysGameOfLife;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class GridView extends JComponent {

    private Grid grid;
    private int CELL_SIZE = 20;
    private GridMouseListener mouseListener;
    boolean[][] board;

    public GridView(GridMouseListener mouseListener, Grid grid) {
        this.grid = grid;
        this.board =  grid.getBoard();
        this.mouseListener = mouseListener;

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        addMouseListener(mouseListener);
        paintBoard(g);
    }

    private void paintBoard(Graphics g) {

        grid.setAlive(0,1);
        grid.setAlive(5,1);
        grid.setAlive(10,5);
        grid.setAlive(4,10);

        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board.length; j++){

                if(board[i][j]){
                    g.setColor(Color.BLUE);
                    g.fillRect(i * CELL_SIZE,j* CELL_SIZE,CELL_SIZE, CELL_SIZE);

                }
                else{
                    g.setColor(Color.BLACK);
                    g.drawRect(i* CELL_SIZE,j* CELL_SIZE,CELL_SIZE, CELL_SIZE);
                }


            }

        }



    }


}




