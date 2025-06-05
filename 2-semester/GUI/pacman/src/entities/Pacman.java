package entities;

import controller.GameController;
import model.CellType;

import javax.swing.*;

public class Pacman extends AbstractEntity {
    int xPosition;
    int yPosition;

    public Pacman(int x, int y) {
        super(CellType.PACMAN, true, x, y);
        this.xPosition = x;
        this.yPosition = y;
    }

    @Override
    public void move(int[] direction) {
        int oldX = this.getX();
        int oldY = this.getY();
        int newX = oldX + direction[0];
        int newY = oldY + direction[1];
        long time = System.currentTimeMillis();
        GameController controller = GameController.instance;

        AbstractEntity walkedOver = controller.getMapModel().getEntityAt(newX, newY);

        super.move(direction);

        if (isMoveLegal(newX, newY) && time - this.lastMoved > this.moveCooldown) {
            controller.getMapModel().setCellValue(oldX, oldY, CellType.EMPTY);
            controller.getMapModel().setCellValue(newX, newY, CellType.PACMAN);
            walkedOver.onPickup();
            this.lastMoved = time;
        }
    }

    public void respawn() {
        GameController controller = GameController.instance;

        int rows = controller.getMapModel().getRowCount();
        int cols = controller.getMapModel().getColumnCount();
        int newX = this.getX() > (cols - 1 - this.getX()) ? 1 : cols - 2;
        int newY = this.getY() > (rows - 1 - this.getY()) ? 1 : rows - 2;
        controller.getMapModel().setCellValue(this.getX(), this.getY(), CellType.EMPTY);
        this.setX(newX);
        this.setY(newY);

        controller.getMapModel().setCellValue(newX, newY, CellType.PACMAN);
        controller.getMapModel().setEntityAt(newX, newY, this);
    }

    public void onPickup() {
        return;
    }
}
