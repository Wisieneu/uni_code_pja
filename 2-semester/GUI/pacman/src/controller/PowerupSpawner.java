package controller;

import entities.Ghost;

public class PowerupSpawner extends Thread {
    private volatile boolean running = true;
    private final Ghost[] ghosts;

    public PowerupSpawner(Ghost[] ghosts) {
        super();
        this.ghosts = ghosts;
    }

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000); // 5 sekund
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            for (Ghost ghost : this.ghosts) {
                if (Math.random() < 0.25) {
                    ghost.schedulePowerupDrop();
                }
            }
        }
    }
}
