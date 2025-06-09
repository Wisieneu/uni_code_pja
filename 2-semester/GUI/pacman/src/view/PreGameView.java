package view;

import javax.swing.*;
import java.awt.*;

public class PreGameView extends JPanel {
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton submitButton;

    public PreGameView(RootView rootView) {
        Font font = new Font("Monospaced", Font.BOLD, 18);

        setLayout(null);
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));

        Font retroFont = new Font("Monospaced", Font.BOLD, 18);

        JLabel label1 = new JLabel("MAP WIDTH:");
        label1.setBounds(60, 30, 200, 30);
        label1.setForeground(Color.GREEN);
        label1.setFont(retroFont);

        spinner1 = new JSpinner(new SpinnerNumberModel(40, 10, 100, 1));
        spinner1.setBounds(210, 30, 120, 30);
        spinner1.setFont(retroFont);
        JComponent editor1 = spinner1.getEditor();
        JFormattedTextField tf1 = ((JSpinner.DefaultEditor) editor1).getTextField();
        tf1.setBackground(Color.BLACK);
        tf1.setForeground(Color.GREEN);
        tf1.setCaretColor(Color.GREEN);
        tf1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

        JLabel label2 = new JLabel("MAP HEIGHT:");
        label2.setBounds(60, 80, 200, 30);
        label2.setForeground(Color.GREEN);
        label2.setFont(retroFont);

        spinner2 = new JSpinner(new SpinnerNumberModel(40, 10, 100, 1));
        spinner2.setBounds(210, 80, 120, 30);
        spinner2.setFont(retroFont);
        JComponent editor2 = spinner2.getEditor();
        JFormattedTextField tf2 = ((JSpinner.DefaultEditor) editor2).getTextField();
        tf2.setBackground(Color.BLACK);
        tf2.setForeground(Color.GREEN);
        tf2.setCaretColor(Color.GREEN);
        tf2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(100, 190, 120, 40);
        submitButton.setFont(retroFont);
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.BLACK);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

        add(label1);
        add(spinner1);
        add(label2);
        add(spinner2);
        add(submitButton);

        submitButton.addActionListener(e -> {
            int widthInput = (int) spinner1.getValue();
            int heightInput = (int) spinner2.getValue();
            if (widthInput > 100 || widthInput < 10 || heightInput > 100 || heightInput < 10) {
                JOptionPane.showMessageDialog(rootView.getFrame(), "invalid input values: please enter 10-100 width and height", "Invalid values", JOptionPane.INFORMATION_MESSAGE);
            }
            rootView.switchTo(new GameView(rootView, widthInput, heightInput));
        });
    }
}
