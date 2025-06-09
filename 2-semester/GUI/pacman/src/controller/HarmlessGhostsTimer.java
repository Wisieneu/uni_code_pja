package controller;

import entities.Ghost;
import model.CellType;

import java.util.List;

public class HarmlessGhostsTimer extends Thread {
    private final List<Ghost> ghosts;
    private final int duration;

    public HarmlessGhostsTimer(List<Ghost> ghosts, int duration) {
        this.ghosts = ghosts;
        this.duration = duration;
    }

    @Override
    public void run() {
        synchronized (ghosts) {
            for (Ghost ghost : this.ghosts) {
                ghost.setIsLethal(false);
                ghost.setCellType(CellType.GHOST_HARMLESS);
            }
        }

        try {
            Thread.sleep(this.duration * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        synchronized (ghosts) {
            for (Ghost ghost : this.ghosts) {
                ghost.setIsLethal(true);
                ghost.setCellType(CellType.GHOST);
            }
        }
    }
}
