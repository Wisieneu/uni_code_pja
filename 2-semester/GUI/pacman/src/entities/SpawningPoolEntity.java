package entities;

import model.CellType;

public class SpawningPoolEntity extends AbstractEntity {

    public SpawningPoolEntity() {
        super(CellType.SPAWNING_POOL);
    }

    @Override
    public void onPickup() {
        return;
    }
}
