package controller;

import model.Directions;
import view.MenuView;
import view.RootView;

import javax.swing.*;
import java.awt.event.ActionEvent;

class GameplayControls {

    //

    static class MoveUpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameController.instance != null)
                GameController.instance.getPacman().move(Directions.UP);
        }
    }

    static class MoveDownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameController.instance != null)
                GameController.instance.getPacman().move(Directions.DOWN);
        }
    }

    static class MoveLeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameController.instance != null)
                GameController.instance.getPacman().move(Directions.LEFT);
        }
    }

    static class MoveRightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameController.instance != null)
                GameController.instance.getPacman().move(Directions.RIGHT);
        }
    }

    static class HardResetAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            RootView.instance.switchTo(new MenuView(RootView.instance));
        }
    }
}
