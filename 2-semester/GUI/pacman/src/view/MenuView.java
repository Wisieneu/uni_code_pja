package view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel {
    private JFrame frame;
    private RootView rootView;

    public MenuView(RootView rootView) {
        this.rootView = rootView;
        this.frame = rootView.getFrame();

        buildComponents();

        frame.setSize(600, 600);
        frame.setResizable(false);
        this.setName("Menu");
    }

    private void buildComponents() {
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());

        JLabel title = new JLabel("PACMAN");
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 36));
        title.setForeground(Color.GREEN);
        add(title);

        add(Box.createVerticalStrut(40));

        JButton startBtn = createMenuButton("START GAME");
        startBtn.addActionListener(e -> rootView.switchTo(new GameView(rootView)));
        add(startBtn);

        add(Box.createVerticalStrut(20));

        JButton scoresBtn = createMenuButton("HIGH SCORES");
        scoresBtn.addActionListener(e -> rootView.switchTo(new HighScoresView(rootView)));
        add(scoresBtn);

        add(Box.createVerticalStrut(20));

        JButton exitBtn = createMenuButton("EXIT");
        exitBtn.addActionListener(e -> rootView.exit());
        add(exitBtn);

        add(Box.createVerticalGlue());
    }

    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setAlignmentX(CENTER_ALIGNMENT);
        btn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.GREEN);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }
}
