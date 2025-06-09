package controller;

import entities.*;
import model.GameScore;
import model.PlayableMapTableModel;
import view.RootView;
import view.SubmitScoreView;

import java.util.List;

public class GameController {
    private final PlayableMapTableModel mapModel;
    private final GameScore gameScore;
    private final Pacman pacman;
    private final List<Ghost> ghosts;

    public static GameController instance;

    private final RootView rootView;

    public GameController(PlayableMapTableModel mapModel, GameScore gameScore, Pacman pacman, List<Ghost> ghosts, RootView rootView) {
        this.mapModel = mapModel;
        this.gameScore = gameScore;
        this.pacman = pacman;
        this.ghosts = ghosts;
        this.rootView = rootView;
        instance = this;
    }

    public void initAll() {
        this.initGhostMover();
        gameScore.initCounter();
        new PowerupSpawner(this.ghosts).start();
    }

    private void initGhostMover() {
        for (Ghost ghost : GameController.instance.getMapModel().getGhostsArr()) {
            new GhostMover(ghost).start();
        }
    }

    public void addLife() {
        this.getScoreObj().addLife();
    }

    public void freezeGhosts(int duration) {
        new GhostFreezeTimer(this.ghosts, duration).start();
    }

    public void makePacmanLethal(int duration) {
        new HarmlessGhostsTimer(this.ghosts, duration).start();
    }

    public void disableWallCollision(int duration) {
        new SlowDownGhostsTimer(duration).start();
    }

    public void setGhostSpeed(int value) {
        for (Ghost ghost : GameController.instance.getMapModel().getGhostsArr()) {
            ghost.setSpeed(value);
        }
    }

    public void pacmanSpeedUpTrigger(int duration) {
        new SpeedUpTimer(this.pacman, duration).start();
    }

    public PlayableMapTableModel getMapModel() {
        return this.mapModel;
    }

    public void killPlayer() {
        this.getScoreObj().reduceLife();
        this.getPacman().respawn();
        freezeGhosts(4);
    }

    public void endGame() {
        instance = null;
        rootView.switchTo(new SubmitScoreView(rootView, gameScore.getScore()));
    }

    public GameScore getScoreObj() {
        return this.gameScore;
    }

    public Pacman getPacman() {
        return this.pacman;
    }

}
