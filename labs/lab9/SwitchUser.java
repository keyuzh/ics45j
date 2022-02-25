package labs.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchUser implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        LoginGUI login = new LoginGUI();
        String newUser = login.newLogin();
        if (newUser != null) {
            FriendTracker.showGUI(newUser);
        }
    }
}
