package entities;

import controller.GameController;
import model.CellType;

public class ExtraLifePowerupPickup extends AbstractPowerup {
    public ExtraLifePowerupPickup() {
        super(CellType.POWERUP_EXTRA_LIFE);
    }

    @Override
    public void onPickup() {
        super.onPickup();
        GameController.instance.addLife();
    }
}
