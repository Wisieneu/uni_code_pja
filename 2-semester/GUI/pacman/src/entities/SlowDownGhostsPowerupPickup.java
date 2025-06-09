package entities;

import controller.GameController;
import model.CellType;

public class SlowDownGhostsPowerupPickup extends AbstractPowerup {
    public SlowDownGhostsPowerupPickup() {
        super(CellType.POWERUP_SLOW_GHOSTS);
    }

    @Override
    public void onPickup() {
        super.onPickup();
        GameController.instance.setGhostSpeed(500);
    }
}
