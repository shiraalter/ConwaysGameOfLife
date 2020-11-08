package touro.ConwaysGameOfLife;

public class LifeGameMain {

    public static void main(String[] args) {
        //All the things we need
        int HEIGHT = 20;
        int WIDTH = 20;
        Grid grid = new Grid(WIDTH, HEIGHT);

        GridMouseListener mouseListener = new GridMouseListener(grid);
        GridView gridView = new GridView(mouseListener, grid);
        new GameFrame(gridView, grid, mouseListener).setVisible(true);

    }
}
