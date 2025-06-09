package model;

import controller.GameController;
import controller.ScoreTracker;

import javax.swing.*;

public class GameScore {
    public static GameScore instance;

    public JLabel scoreLabel;

    private int score;
    private int lives;
    private float gameTime;

    private ScoreTracker scoreTracker;

    public GameScore(JLabel scoreLabel) {
        score = 0;
        this.scoreLabel = scoreLabel;
        this.lives = 3;
        this.gameTime = 0.0f;

        this.scoreTracker = new ScoreTracker(this);
    }

    public void initCounter() {
        this.scoreTracker.start();
    }

    public GameScore(int customScoreStart, JLabel scoreLabel) {
        score = customScoreStart;
        this.scoreLabel = scoreLabel;
    }

    public void addScore() {
        score += 1;
    }

    public void addScore(int scoreIncrease) {
        score += scoreIncrease;
    }

    public int getScore() {
        return this.score;
    }

    public void setGameTime(float newGameTime) {
        this.gameTime = newGameTime;
    }

    public void addLife() {
        this.lives++;
    }

    public void reduceLife() {
        this.lives--;
        if (this.lives == 0)
            GameController.instance.endGame();
    }

    @Override
    public String toString() {
        return "Score: " + this.score + " | Lives " + this.lives + " | Time: " + String.format("%.1f", this.gameTime);
    }
}
