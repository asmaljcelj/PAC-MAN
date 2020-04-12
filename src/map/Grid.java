package src.map;

import src.enums.DirectionEnum;
import src.enums.GridTypeEnum;

public class Grid {
    public static int CELL_WIDTH;
    public static int CELL_HEIGHT;
    private Cell[][] grid;

    public Grid(int rows, int columns, int singleCellWidth, int singleCellHeight) {
        this.grid = new Cell[rows][columns];
        CELL_WIDTH = singleCellWidth;
        CELL_HEIGHT = singleCellHeight;
        fillGrid();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    private void fillGrid() {
        int id = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell(id, this, GridTypeEnum.DEFAULT);
                id++;
            }
        }
    }

    public Cell getNeighborCell(Cell current, DirectionEnum direction) {
        int neighbourId = current.getId();
        int row = neighbourId / grid.length;
        int column = neighbourId % grid[0].length;
        // consider the direction possible edge cases
        switch (direction) {
            case UP:
                if (neighbourId < grid[0].length) {
                    neighbourId = column + (grid.length - 1) * grid[0].length;
                } else {
                    neighbourId -= grid.length;
                }
                break;
            case RIGHT:
                if ((neighbourId + 1) % grid[0].length == 0) {
                    neighbourId = row * grid[0].length;
                } else {
                    neighbourId++;
                }
                break;
            case DOWN:
                if (neighbourId >= (grid.length - 1) * grid[0].length) {
                    neighbourId = column;
                } else {
                    neighbourId += grid.length;
                }
                break;
            case LEFT:
                if (neighbourId % row == 0) {
                    neighbourId = (row + 1) * grid[0].length - 1;
                } else {
                    neighbourId--;
                }
                break;
        }
        return getSpecificCellById(neighbourId);
    }

    public Cell getSpecificCellById(int id) {
        int row = id / grid.length;
        int column = id % grid[0].length;
        return getSpecificCell(row, column);
    }

    public Cell getSpecificCell(int row, int column) {
        return grid[row][column];
    }
}
