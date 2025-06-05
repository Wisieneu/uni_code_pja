package controller;

import entities.*;
import model.GameScore;
import model.PlayableMapTableModel;
import view.RootView;

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
//        this.initGhostMover();
        gameScore.initCounter();
    }

    private void initGhostMover() {
        for (Ghost ghost : GameController.instance.getMapModel().getGhostsArr()) {
            new GhostMover(ghost).start();
        }
    }

    public void freezeGhosts(int duration) {
        new GhostFreezeTimer(ghosts, duration).start();
    }

    public void disableWallCollision(int duration) {

    }

    public PlayableMapTableModel getMapModel() {
        return this.mapModel;
    }

    public void killPlayer() {
        this.getScoreObj().reduceLife();
        this.getPacman().respawn();
        freezeGhosts(5);
    }

    public void endGame() {

    }

    public GameScore getScoreObj() {
        return this.gameScore;
    }

    public Pacman getPacman() {
        return this.pacman;
    }
}
