package entities;

import controller.GameController;
import model.CellType;

public class SpeedUpPowerupPickup extends AbstractPowerup {
    public SpeedUpPowerupPickup() {
        super(CellType.POWERUP_SPEED_UP);
    }

    @Override
    public void onPickup() {
        super.onPickup();
        GameController.instance.pacmanSpeedUpTrigger(10);
    }
}
