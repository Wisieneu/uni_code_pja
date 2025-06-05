package controller;

import entities.Pacman;
import model.PlayableMapTableModel;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ControlsBindings {
    private InputMap inputMap;
    private ActionMap actionMap;

    public ControlsBindings(JComponent component) {
        this.inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        this.actionMap = component.getActionMap();
        setupGameplayKeyBindings();
    }

    public void setupGameplayKeyBindings() {
        addKeyBind(KeyEvent.VK_W, 0, new GameplayControls.MoveUpAction());
        addKeyBind(KeyEvent.VK_S, 0, new GameplayControls.MoveDownAction());
        addKeyBind(KeyEvent.VK_A, 0, new GameplayControls.MoveLeftAction());
        addKeyBind(KeyEvent.VK_D, 0, new GameplayControls.MoveRightAction());
        addKeyBind(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK, new GameplayControls.HardResetAction());
    }

    public void addKeyBind(int keyCode, int modifiers, AbstractAction action) {
        String key = keyCode + "" + modifiers;
        inputMap.put(KeyStroke.getKeyStroke(keyCode, modifiers), key);
        actionMap.put(key, action);
    }
}
