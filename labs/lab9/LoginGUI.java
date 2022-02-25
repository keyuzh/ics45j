package labs.lab9;

import javax.swing.*;

public class LoginGUI extends JOptionPane {
    private static final String prompt = "Enter your username:";
    private final JFrame frame;

    public LoginGUI() {
        this.frame = new JFrame("input");
    }

    public String newLogin() {
        String username = "";
        while (username != null && username.isBlank()) {
            username = JOptionPane.showInputDialog(frame, prompt);
        }
        return username;
    }
}
