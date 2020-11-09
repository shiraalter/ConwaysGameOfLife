package touro.ConwaysGameOfLife;

public class LifeGameMain {

    public static void main(String[] args) {
        //All the things we need
        Grid grid = new Grid();
        GridView gridView = new GridView(grid);
        new GameFrame(gridView, grid).setVisible(true);

    }
}
