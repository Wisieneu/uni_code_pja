package controller;

public class SlowDownGhostsTimer extends Thread {
    private final int duration;

    public SlowDownGhostsTimer(int duration) {
        this.duration = duration;
    }

    @Override
    public void run() {
        GameController.instance.setGhostSpeed(800);

        try {
            Thread.sleep(this.duration * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        GameController.instance.setGhostSpeed(400);
    }
}
