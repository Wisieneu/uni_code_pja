package entities;

import controller.GameController;
import model.CellType;

public class PointPickup extends AbstractPowerup {

    public PointPickup() {
        super(CellType.POINT);
    }

    @Override
    public void onPickup() {
        GameController.instance.getScoreObj().addScore();
    }
}
