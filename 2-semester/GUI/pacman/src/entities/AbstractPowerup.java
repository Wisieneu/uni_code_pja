package entities;

import controller.GameController;
import model.CellType;

public abstract class AbstractPowerup extends AbstractEntity {
    public AbstractPowerup(CellType cellType) {
        super(cellType);
    }

    @Override
    public void onPickup() {
        GameController.instance.getScoreObj().addScore(10);
    }

    public static AbstractPowerup getRandomPowerup() {
        AbstractPowerup[] arr = new AbstractPowerup[]{
                new PointPickup(),
                new FreezePowerupPickup(),
                new DisableWallCollisionPowerupPickup()
        };
        return arr[(int) (Math.random() * (arr.length - 1))];
    }
}
