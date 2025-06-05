package view;

import controller.ControlsBindings;

import javax.swing.*;
import java.awt.*;

public class RootView {

    private JFrame frame;
    private JPanel cards; // Panel that uses CardLayout
    private CardLayout cardLayout;
    public static RootView instance;

    public RootView() {
        this.frame = new JFrame("Pacman");
        this.cardLayout = new CardLayout();
        this.cards = new JPanel(cardLayout);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cards);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);

        instance = this;

        setGlobalStyles();

        new ControlsBindings(this.frame.getRootPane());

        switchTo(new MenuView(this));
    }

    public void switchTo(JPanel view) {
        cards.removeAll();
        cards.add(view);
        cardLayout.show(cards, view.getName());
        cards.revalidate();
        cards.repaint();
    }

    public void showHighScores() {
        cards.removeAll();
        cards.add(new HighScoresView(this));
        cardLayout.show(cards, "Menu");
        cards.revalidate();
        cards.repaint();
    }

    private void setGlobalStyles() {
        frame.setBackground(Color.BLACK);
    }

    public void exit() {
        System.exit(0);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
