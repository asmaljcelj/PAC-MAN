package src.map;

import src.enums.DirectionEnum;
import src.enums.GridTypeEnum;

public class Cell {
    private int id;
    private Grid grid;
    private GridTypeEnum type;

    public Cell(int id, Grid grid, GridTypeEnum type) {
        this.id = id;
        this.grid = grid;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridTypeEnum getType() {
        return type;
    }

    public void setType(GridTypeEnum type) {
        this.type = type;
    }

    public Cell getNeighbourCell(DirectionEnum direction) {
        return grid.getNeighborCell(this, direction);
    }

}
