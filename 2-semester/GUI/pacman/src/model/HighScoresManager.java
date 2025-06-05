package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScoresManager implements Serializable {
    private final List<ScoreEntry> scores = new ArrayList<>();

    public void addScore(ScoreEntry entry) {
        scores.add(entry);
        Collections.sort(scores, (a, b) -> Integer.compare(b.getScore(), a.getScore()));
        if (scores.size() > 10) {
            scores.remove(scores.size() - 1);
        }
    }

    public List<ScoreEntry> getScores() {
        return new ArrayList<>(scores);
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(filename)))) {
            out.writeObject(this);
        }
    }

    public static HighScoresManager loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(filename)))) {
            return (HighScoresManager) in.readObject();
        }
    }
}

// Użycie:
// HighScoresManager manager = new HighScoresManager();
// manager.addScore(new ScoreEntry("John", 100));
// manager.saveToFile("scores.dat");
// HighScoresManager loadedManager =
// HighScoresManager.loadFromFile("scores.dat");
