package src;

import src.enums.DirectionEnum;
import src.enums.GridTypeEnum;
import src.enums.IDEnum;
import src.map.Cell;
import src.map.Grid;

import java.awt.*;

public class Player extends GameObject {
    private DirectionEnum direction;

    public Player(Cell cell, IDEnum idEnum) {
        super(cell, idEnum, 1);
        currentCell.setType(GridTypeEnum.PLAYER);
        this.direction = DirectionEnum.HOLD;
    }

    @Override
    public void tick() {
        Cell neighbourCell = currentCell;
        switch (direction) {
            case UP:
                neighbourCell = currentCell.getNeighbourCell(DirectionEnum.UP);
                break;
            case RIGHT:
                neighbourCell = currentCell.getNeighbourCell(DirectionEnum.RIGHT);
                break;
            case DOWN:
                neighbourCell = currentCell.getNeighbourCell(DirectionEnum.DOWN);
                break;
            case LEFT:
                neighbourCell = currentCell.getNeighbourCell(DirectionEnum.LEFT);
                break;
        }
        setCurrentCell(neighbourCell);
    }

    @Override
    public void render(Graphics g) {
        int row = currentCell.getId() / currentCell.getGrid().getGrid().length;
        int column = currentCell.getId() % currentCell.getGrid().getGrid()[0].length;
        System.out.println(row + "     " + column);

        g.setColor(Color.RED);
        g.fillRect(column * Grid.CELL_WIDTH, row * Grid.CELL_HEIGHT, Grid.CELL_WIDTH, Grid.CELL_HEIGHT);
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public DirectionEnum getDirection() {
        return this.direction;
    }

}
