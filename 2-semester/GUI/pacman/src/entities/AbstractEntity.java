package entities;

import controller.GameController;
import model.CellType;

public abstract class AbstractEntity {
    private boolean isMovable;
    private CellType cellType;

    protected int xPosition;
    protected int yPosition;

    protected long lastMoved;
    protected long moveCooldown;

    protected AbstractEntity standingOver; // which tile type is the entity currently standing over

    public AbstractEntity(CellType cellType, boolean isMovable, int x, int y) {
        this.isMovable = isMovable;
        this.cellType = cellType;
        this.xPosition = x;
        this.yPosition = y;
        this.lastMoved = System.currentTimeMillis();
        this.moveCooldown = 200;
    }

    public AbstractEntity(CellType cellType) {
        this.cellType = cellType;
    }

    public void move(int[] direction) {
        if (!isMovable) return;

        GameController controller = GameController.instance;

        int oldX = this.getX();
        int oldY = this.getY();
        int newX = oldX + direction[0];
        int newY = oldY + direction[1];
        long time = System.currentTimeMillis();

        if (isMoveLegal(newX, newY) && time - this.lastMoved > this.moveCooldown) {
            this.setY(newY);
            this.setX(newX);
            GameController.instance.getMapModel().setCellValue(newX, newY, this.cellType);
            GameController.instance.getMapModel().setEntityAt(newX, newY, this);
            this.lastMoved = time;
        }
    }

    public boolean isMoveLegal(int x, int y) {
        AbstractEntity walkedOverEntity = GameController.instance.getMapModel().getEntityAt(x, y);
        CellType cellType = GameController.instance.getMapModel().getCellValue(x, y);

        boolean notOutsideOfMap = x > -1 && x < GameController.instance.getMapModel().getColumnCount() && y > -1 && y < GameController.instance.getMapModel().getRowCount();
        // isnt a ghost OR is a ghost and isnt walking over another ghost
        boolean notGhostsWalkingOverEachOther = walkedOverEntity == null || this.getCellType() != CellType.GHOST || (this.getCellType() == CellType.GHOST && walkedOverEntity.getCellType() != CellType.GHOST);
        boolean notWalkingOverIllegalTerrain = cellType != CellType.WALL && cellType != CellType.SPAWNING_POOL;

        return notOutsideOfMap && notWalkingOverIllegalTerrain && notGhostsWalkingOverEachOther;
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public void setX(int x) {
        this.xPosition = x;
    }

    public void setY(int y) {
        this.yPosition = y;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public void setMoveCooldown(int value) {
        this.moveCooldown = value;
    }

    public abstract void onPickup();

    public void setSpeed(int value) {
        this.moveCooldown = value;
    }
}
