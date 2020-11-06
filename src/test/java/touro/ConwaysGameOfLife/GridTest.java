package touro.ConwaysGameOfLife;


import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {


    /**
     * test that constructor populates the board
     */
    @Test
    public void populateBoardCells(){
        //GIVEN & WHEN
        Grid grid = new Grid(10,10);

        //THEN
        assertNotNull(grid);
    }

    @Test
    public void countAliveNeighbors(){
        //GIVEN
        Grid grid = new Grid(20,20);
        grid.setAlive(1,1);
        grid.setAlive(1,3);

        //WHEN
        int count =  grid.countAliveNeighbors(1,2);

        //THEN
        assertEquals(2, count);
    }


    @Test
    public void checkStatus(){

        //GIVEN
        Grid grid = new Grid(20,20);


        //WHEN/THEN
        assertFalse(grid.checkStatus(-1,1));

    }


    @Test
    public void makeMove() {
        //GIVEN
        Grid grid = new Grid(10,10);
        grid.setAlive(1,1);
        //grid.setAlive(1,3);

        //WHEN
        grid.makeMove();

        //THEN
        assertFalse(grid.isAlive(1,1));

    }
}