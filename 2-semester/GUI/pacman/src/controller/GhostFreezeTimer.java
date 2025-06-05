package controller;

import entities.Ghost;

import java.util.List;

public class GhostFreezeTimer extends Thread {
    private final List<Ghost> ghosts;
    private final int duration;

    public GhostFreezeTimer(List<Ghost> ghosts, int duration) {
        this.ghosts = ghosts;
        this.duration = duration;
    }

    @Override
    public void run() {
        synchronized (ghosts) {
            for (Ghost ghost : this.ghosts) {
                ghost.setIsFrozen(true);
            }
        }

        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        synchronized (ghosts) {
            for (Ghost ghost : this.ghosts) {
                ghost.setIsFrozen(false);
            }
        }
    }
}
