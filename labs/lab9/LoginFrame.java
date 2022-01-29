package labs.lab9;

import javax.swing.*;

public class LoginFrame {
    private JFrame frame;
    private String newUserName;

    public LoginFrame() {
        frame = new JFrame("input");
        frame.setSize(300, 300);
        newUserName = JOptionPane.showInputDialog(frame, "Enter your username:");
    }

    public String getNewUserName() {
        return newUserName;
    }
}
