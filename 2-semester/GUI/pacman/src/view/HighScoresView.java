package view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HighScoresView extends JPanel {
    private JList<String> scoreList;
    private static final String SCORES_FILE = "highscores.dat";

    public HighScoresView(RootView rootView) {
        setBackground(Color.BLACK);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(getClass().getResource("/images/ghost-orange.png")));
        add(label);
    }
}
