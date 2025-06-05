package controller;

import model.GameScore;

import javax.swing.*;

public class ScoreTracker extends Thread {
    private final JLabel scoreLabel;
    private final GameScore scoreObj;

    public ScoreTracker(GameScore scoreObj) {
        this.scoreObj = scoreObj;
        this.scoreLabel = this.scoreObj.scoreLabel;
    }

    @Override
    public void run() {
        scoreObj.setGameTime(0);
        int startTime = (int) System.currentTimeMillis();
        while (GameController.instance != null) {
            synchronized (scoreObj) {
                float newTime = ((float) (((int) System.currentTimeMillis() - startTime) / 100)) / 10;
                scoreObj.setGameTime(newTime);
                this.scoreLabel.setText(scoreObj.toString());
            }
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
