package controller;

import entities.Ghost;

import java.util.List;

public class PowerupSpawner extends Thread {
    private volatile boolean running = true;
    private final List<Ghost> ghosts;

    public PowerupSpawner(List<Ghost> ghosts) {
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
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (ghosts) {
                for (Ghost ghost : this.ghosts) {
                    if (Math.random() < 0.25) {
                        ghost.schedulePowerupDrop();
                    }
                }
            }
        }
    }
}
