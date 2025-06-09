package entities;

import controller.GameController;
import model.CellType;

public class HarmlessGhostsPowerupPickup extends AbstractPowerup {
    public HarmlessGhostsPowerupPickup() {
        super(CellType.POWERUP_HARMLESS_GHOSTS);
    }

    @Override
    public void onPickup() {
        super.onPickup();
        GameController.instance.makePacmanLethal(10);
    }
}
