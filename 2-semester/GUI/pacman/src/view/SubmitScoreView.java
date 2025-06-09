package view;

import model.ScoreEntry;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class SubmitScoreView extends JPanel {
    private JFrame frame;
    private RootView rootView;
    private int score;
    private File saveFile;
    private ArrayList<ScoreEntry> scoreList;

    public SubmitScoreView(RootView rootView, int score) {
        this.score = score;
        this.rootView = rootView;

        this.saveFile = new File("out/production/pacman/highscores.dat");
        try {
            if (!saveFile.exists())
                saveFile = new File("src/highscores.dat");
        } catch (Error e) {
            saveFile = new File("src/highscores.dat");
        }
        this.scoreList = loadScores();

        rootView.getFrame().setSize(700, 300);

        setBackground(Color.BLACK);
        setLayout(null);

        Font font = new Font("Monospaced", Font.BOLD, 18);

        JLabel nameLabel = new JLabel("ENTER YOUR NAME:");
        nameLabel.setBounds(40, 40, 250, 30);
        nameLabel.setForeground(Color.GREEN);
        nameLabel.setFont(font);

        JTextField nameField = new JTextField();
        nameField.setBounds(300, 40, 250, 30);
        nameField.setBackground(Color.LIGHT_GRAY);
        nameField.setFont(font);

        JLabel scoreLabel = new JLabel("YOUR SCORE: " + score);
        scoreLabel.setBounds(40, 90, 250, 30);
        scoreLabel.setForeground(Color.GREEN);
        scoreLabel.setFont(font);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(140, 150, 250, 40);
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.BLACK);
        submitButton.setFont(font);

        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            scoreList.add(new ScoreEntry(name, score));
            saveScores();
            JOptionPane.showMessageDialog(this, "Score saved successfully. Returning to main menu now.");
            rootView.switchTo(new MenuView(rootView));
        });

        add(nameLabel);
        add(nameField);
        add(scoreLabel);
        add(submitButton);
    }

    private void saveScores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            oos.writeObject(scoreList);
        } catch (IOException e) {
            e.printStackTrace();
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
