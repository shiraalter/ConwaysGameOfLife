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
        Grid grid = new Grid();

        //THEN
        assertNotNull(grid);
    }

    @Test
    public void countAliveNeighbors(){
        //GIVEN
        Grid grid = new Grid();
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
        Grid grid = new Grid();

        //WHEN/THEN
        assertFalse(grid.checkStatus(-1,1));

    }


    @Test
    public void insufficientAliveNeighbors() {
        //GIVEN
        Grid grid = new Grid();
        grid.setAlive(1,1);
        //grid.setAlive(1,3);

        //WHEN
        grid.makeMove();

        //THEN
        assertFalse(grid.isAlive(1,1));

    }

    @Test
    public void sufficientAliveNeighbors(){
        //GIVEN
        Grid grid = new Grid();

    }

}