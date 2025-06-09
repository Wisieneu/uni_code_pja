package controller;

import entities.Ghost;
import entities.Pacman;
import model.CellType;

import java.util.List;

public class SpeedUpTimer extends Thread {
    private final int duration;
    private final Pacman pacman;

    public SpeedUpTimer(Pacman pacman, int duration) {
        this.pacman = pacman;
        this.duration = duration;
    }

    @Override
    public void run() {
        synchronized (pacman) {
            pacman.setMoveCooldown(100);
        }

        try {
            Thread.sleep(this.duration * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        synchronized (pacman) {
            pacman.setMoveCooldown(200);
        }
    }
}
