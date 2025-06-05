package entities;

import controller.GameController;
import model.CellType;

public class Ghost extends AbstractEntity {
    private boolean isLethal;
    private boolean isChasing;
    private boolean isFrozen;
    private boolean doesDropPowerup;

    public Ghost(int x, int y) {
        super(CellType.GHOST, true, x, y);
        this.isLethal = true;
        this.isChasing = true;
        this.isFrozen = false;
        this.standingOver = new PointPickup();
    }

    public void setLethal(boolean setVal) {
        this.isLethal = setVal;
    }

    public void setIsChasing(boolean isChasing) {
        this.isChasing = isChasing;
    }

    public void schedulePowerupDrop() {
        this.doesDropPowerup = true;
    }

    public void respawn() {
        GameController controller = GameController.instance;
        controller.getMapModel().setCellValue(this.getX(), this.getY(), CellType.EMPTY);

        int[] spawn = GameController.instance.getMapModel().getSpawnCords();

        GameController.instance.getMapModel().setEntityAt(this.getX(), this.getY(), this);

        this.setX(spawn[0]);
        this.setY(spawn[1]);

        this.doesDropPowerup = false;
        this.standingOver = new PointPickup();
        GameController.instance.getMapModel().setEntityAt(this.getX(), this.getY(), this);
    }

    @Override
    public void move(int[] direction) {
        if (this.isFrozen) return;
        int oldX = this.getX();
        int oldY = this.getY();
        int newX = oldX + direction[0];
        int newY = oldY + direction[1];
        GameController controller = GameController.instance;
        long time = System.currentTimeMillis();

        if (this.doesDropPowerup) {
            this.doesDropPowerup = false;
            this.standingOver = AbstractPowerup.getRandomPowerup();
        }
        if (isMoveLegal(newX, newY) && time - this.lastMoved > this.moveCooldown) {
            if (standingOver != null)
                this.standingOver = new PointPickup();
            controller.getMapModel().setCellValue(oldX, oldY, this.standingOver.getCellType());
            controller.getMapModel().setEntityAt(oldX, oldY, this.standingOver);

            this.standingOver = controller.getMapModel().getEntityAt(newX, newY);

            Pacman pacman = controller.getPacman();
            if (pacman.getX() == newX && pacman.getY() == newY) {
                System.out.println("ghost kill");
                System.out.println("pacman cords ======== " + controller.getPacman().getX() + " " + controller.getPacman().getY());
                System.out.println();
                controller.killPlayer();
            }
        }
        super.move(direction);
    }

    public void moveDirectlyTowardsPacman() {
        GameController controller = GameController.instance;

        int pacmanX = controller.getPacman().getX();
        int pacmanY = controller.getPacman().getY();

        int dx = Integer.compare(pacmanX, this.getX());
        int dy = Integer.compare(pacmanY, this.getY());

        // najpierw skracamy ten dluzszy dystans, jesli sie nie da to ten krotszy, jesli jestesmy na wprost ale przez sciane to probujemy losowo obejsc
        if (Math.abs(pacmanX - this.getX()) > Math.abs(pacmanY - this.getY())) {
            if (isMoveLegal(this.getX() + dx, this.getY()))
                dy = 0;
            else if (dy != 0)
                dx = 0;
            else
                dy = (int) (-1 + Math.random() * 3);
        } else {
            if (isMoveLegal(this.getX(), this.getY() + dy))
                dx = 0;
            else if (dx != 0)
                dy = 0;
            else
                dx = (int) (-1 + Math.random() * 3);
        }

        // DEBUG:TODO:
        int newX = this.getX() + dx;
        int newY = this.getY() + dy;
        System.out.println("moving from " + this.getX() + " " + this.getY() + " to " + newX + " " + newY + ", walking over: " + GameController.instance.getMapModel().getCellValue(newX, newY));

        move(new int[]{dx, dy});
    }

    public void setIsFrozen(boolean frozenState) {
        this.isFrozen = frozenState;
    }

    public void onPickup() {
        if (this.isLethal) {
            GameController.instance.killPlayer();
            this.respawn();
            System.out.println("game over");
        } else {
            this.respawn();
        }
    }
}
