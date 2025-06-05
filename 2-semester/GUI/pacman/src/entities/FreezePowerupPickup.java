package entities;

import controller.GameController;
import model.CellType;

public class FreezePowerupPickup extends AbstractPowerup {
    public FreezePowerupPickup() {
        super(CellType.POWERUP_FREEZE);
    }

    @Override
    public void onPickup() {
        super.onPickup();
        GameController.instance.freezeGhosts(5);
    }
}
