package controller;

import entities.Ghost;

import java.util.List;

public class GhostMover extends Thread {
    private boolean running = true;

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
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        while (running && GameController.instance != null) {
            synchronized (GameController.instance.getMapModel()) {
                try {
                    ghost.moveDirectlyTowardsPacman();
                } finally {}
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
