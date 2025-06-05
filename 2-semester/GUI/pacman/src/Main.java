import view.RootView;

import javax.swing.*;

public class Main implements Runnable {
    @Override
    public void run() {
        RootView rootView = new RootView();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

}
