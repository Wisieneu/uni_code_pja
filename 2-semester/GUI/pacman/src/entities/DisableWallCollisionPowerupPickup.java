package entities;

import controller.GameController;
import model.CellType;

public class DisableWallCollisionPowerupPickup extends AbstractPowerup {
    public DisableWallCollisionPowerupPickup() {
        super(CellType.POWERUP_NO_WALL);
    }

    @Override
    public void onPickup() {
        super.onPickup();
        GameController.instance.disableWallCollision(5);
    }
}
