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
        assertFalse(grid.checkInBounds(-1,1));

    }


    @Test
    public void insufficientAliveNeighbors() {
        //GIVEN
        Grid grid = new Grid();
        grid.setAlive(1,1);

        //WHEN
        grid.makeMove();

        //THEN
        assertFalse(grid.isAlive(1,1));
    }

    /**
     * test that cell will become alive if it has 3 alive neighbors
     */
    @Test
    public void sufficientAliveNeighbors(){

        //GIVEN
        Grid grid = new Grid();

        //WHEN
        grid.setAlive(0,0);
        grid.setAlive(1,0);
        grid.setAlive(2,0);

        //THEN
        grid.isAlive(1,1);

    }

    @Test
    public void setDead(){
        //GIVEN
        Grid grid = new Grid();
        grid.setAlive(0,0);

        //WHEN
        grid.setDead(0,0);

        //THEN
        assertFalse(grid.isAlive(0,0));
    }

    @Test
    public void clearBoard(){
        //GIVEN
        Grid grid = new Grid();
        grid.setAlive(0,1);
        grid.setAlive(0,0);

        //WHEN
        grid.clearBoard();

        //THEN
        assertFalse(grid.isAlive(0,1));
        assertFalse(grid.isAlive(0,0 ));
    }

    @Test
    public void getBoard(){
        //GIVEN
        Grid grid = new Grid();

        //WHEm/THEN
        assertNotNull(grid.getBoard());

    }

    @Test
    public void isAliveVariable(){
        //GIVEN
        Grid grid = new Grid();

        //WHEN
        grid.setDead(0,0);
        grid.setAlive(0,0);

        //THEN
        grid.isAlive(0,0);
    }


}