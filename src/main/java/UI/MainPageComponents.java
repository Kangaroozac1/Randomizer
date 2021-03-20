package UI;

import javax.swing.*;

class MainPageComponents {

    public static JButton button(String name) {
        JButton button = new JButton();
        button.setText(name);

        return button;
    }

    public static JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalTextPosition(JLabel.CENTER);
        return label;
    }

}
