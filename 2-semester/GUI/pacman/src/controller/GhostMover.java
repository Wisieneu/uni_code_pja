package controller;

import entities.Ghost;

import java.util.List;

public class GhostMover extends Thread {
    private volatile boolean running = true; // volatile = will be modified by different threads

    private final Ghost ghost;

    public GhostMover(Ghost ghost) {
        this.ghost = ghost;
    }

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        while (running && GameController.instance != null) {
            synchronized (GameController.instance.getMapModel()) {
                ghost.moveDirectlyTowardsPacman();
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
