package view;

import model.ScoreEntry;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Comparator;

public class HighScoresView extends JPanel {
    private File saveFile = new File("out/production/pacman/highscores.dat");
    private DefaultListModel<String> listModel;
    private JList<String> scoreJList;

    public HighScoresView(RootView rootView) {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        scoreJList = new JList<>(listModel);

        loadAndDisplayScores();

        JButton btn = new JButton(">> BACK TO MENU <<");
        btn.setAlignmentX(CENTER_ALIGNMENT);
        btn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.GREEN);
        btn.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btn.addActionListener(e -> rootView.switchTo(new MenuView(rootView)));

        scoreJList.setFont(new Font("Monospaced", Font.BOLD, 32));
        scoreJList.setBackground(Color.BLACK);
        scoreJList.setForeground(Color.GREEN);
        scoreJList.setSelectionBackground(Color.GREEN);
        scoreJList.setSelectionForeground(Color.BLACK);
        scoreJList.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));

        JScrollPane scrollPane = new JScrollPane(scoreJList);
        add(btn, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadAndDisplayScores() {
        ArrayList<ScoreEntry> scoreList = loadScores();
        scoreList.sort(Comparator.comparingInt(ScoreEntry::getScore).reversed());
        listModel.clear();
        for (ScoreEntry entry : scoreList) {
            listModel.addElement(entry.toString());
        }
    }

    private ArrayList<ScoreEntry> loadScores() {
        if (!saveFile.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
            return (ArrayList<ScoreEntry>) ois.readObject();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }
}
