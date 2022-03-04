package labs.lab9;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FriendTrackerGUI extends JFrame{
    private static final String title = "Friend Tracker - Keyu Zhang - 19898090";

    private final String currentUserStr;
    private final User currentUser;
    private final JMenuBar menuBar;
    private final JTextArea currentActivity;
    private final JComboBox<Mood> moodBox;
    private final ArrayList<JCheckBox> tagFriends;
    private final JTextArea feed;


    public FriendTrackerGUI(String currentUserStr) {
        this.currentUserStr = currentUserStr;
        UserActivities.users.putIfAbsent(currentUserStr, new User(currentUserStr));
        currentUser = UserActivities.users.get(currentUserStr);
        // initialize fields
        menuBar = new JMenuBar();
        currentActivity = new JTextArea(5, 30);
        moodBox = new JComboBox<>(Mood.values());
        tagFriends = new ArrayList<>();
        feed = new JTextArea(10, 40);
        // set gui
        setTitle(title);
        createMenuBar();
        makeGUI();
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMenuBar() {
        setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createUserMenu());
    }

    static class ExitItemListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    public JMenu createFileMenu() {
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        ActionListener listener = new ExitItemListener();
        exitItem.addActionListener(listener);
        menu.add(exitItem);
        return menu;
    }

    public JMenu createUserMenu() {
        JMenu menu = new JMenu("Users");
        JMenuItem item = new JMenuItem("Switch User");
        ActionListener listener = new SwitchUser();
        item.addActionListener(listener);
        menu.add(item);
        return menu;
    }

    public void makeGUI() {
        // set layout
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        // add each component
        createCurrentUser(); // current user
        createCurrentActivity(); // current activity
        createMood(); // mood
        createTagFriends(); // tag friends
        createSave(); // save
        createFriendsFeed(); // friends feed
    }

    void createCurrentUser() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("current user: " + currentUserStr));
        add(panel);
    }

    void createCurrentActivity() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Current Activity:"));
        currentActivity.setLineWrap(true);
        currentActivity.setText(currentUser.getCurrentActivity());
        panel.add(currentActivity, BorderLayout.CENTER);
        add(panel);
    }

    void createMood() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Mood: "));
        panel.add(moodBox);
        moodBox.setSelectedItem(currentUser.getMood());
        add(panel);
    }

    void createTagFriends() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Tag friends:"));
        for (String s : UserActivities.users.keySet()) {
            if (!s.equals(currentUserStr)) {
                JCheckBox checkBox = new JCheckBox(s);
                if (currentUser.getTaggedFriends().contains(s)) {
                    checkBox.setSelected(true);
                }
                tagFriends.add(checkBox);
            }
        }
        for (JCheckBox cb : tagFriends) {
            panel.add(cb);
        }
        add(panel);
    }

    void createSave() {
        JPanel panel = new JPanel();
        JButton save = new JButton("Save");
        ActionListener saveAction = new SaveStatus(currentUserStr, currentActivity, moodBox, tagFriends);
        save.addActionListener(saveAction);
        panel.add(save);
        add(panel);
    }

    void createFriendsFeed() {
        JPanel panel = new JPanel();
        feed.setBorder(new TitledBorder("Friends"));
        feed.setEditable(false);
        List<String> friends = new ArrayList<>();
        for (User u : UserActivities.users.values()) {
            if (!u.getName().equals(currentUserStr)) {
                friends.add(u.toString());
            }
        }
        feed.setText(String.join("\n", friends));
        feed.setLineWrap(false);
        JScrollPane scrollPane = new JScrollPane(feed);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                scrollPane.getVerticalScrollBar().setValue(0);
            }
        });
        panel.add(scrollPane);
        add(panel);
    }
}
