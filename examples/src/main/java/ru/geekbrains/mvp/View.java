package ru.geekbrains.mvp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View {
    // A list of listeners subscribed to this view
    private final ArrayList<ViewListener> listeners;
    private final JLabel label;

    public View() {
        final JFrame frame = new JFrame();
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new  GridLayout());

         JButton button = new JButton("Your Prediction for 2022");
                button.setHorizontalAlignment(SwingConstants.CENTER);

        button.addActionListener(e -> notifyListenersOnButtonClicked());
        frame.add(button);

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);

        this.listeners = new ArrayList<>();

        frame.setVisible(true);
    }

    // Iterate through the list, notifying each listner individualy
    private void notifyListenersOnButtonClicked() {
        listeners.forEach(ViewListener::onButtonClicked);
    }

    // Subscribe a listener
    public void addListener(final ViewListener listener) {
        listeners.add(listener);
    }

    public void setLabelText(final String text) {
        label.setText(text);
    }
}
