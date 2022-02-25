package labs.lab9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SaveStatus implements ActionListener {
    private final String user;
    private final JTextArea activity;
    private final JComboBox<Mood> mood;
    private final ArrayList<JCheckBox> friends;

    public SaveStatus(String user, JTextArea activity, JComboBox<Mood> mood, ArrayList<JCheckBox> friends) {
        this.user = user;
        this.activity = activity;
        this.mood = mood;
        this.friends = friends;
    }

    private List<String> taggedFriends() {
        List<String> res = new ArrayList<>();
        for (JCheckBox cb : friends) {
            if (cb.isSelected()) {
                res.add(cb.getText());
            }
        }
        return res;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Mood currentMood = mood.getItemAt(mood.getSelectedIndex());
        UserActivities.users.put(user, new User(user, activity.getText(), currentMood, taggedFriends()));
        JFrame popup = new JFrame();
        JOptionPane.showMessageDialog(popup, "Status saved");
    }
}
