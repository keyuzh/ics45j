package labs.lab9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FriendTrackerGUI extends JFrame{
    private static final String title = "Friend Tracker - Keyu Zhang - 19898090";
    private JMenuBar menuBar;


    public FriendTrackerGUI() {
        setTitle(title);
        createMenuBar();
        setSize(600, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMenuBar() {
        this.menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createUserMenu());
    }

    class ExitItemListener implements ActionListener {
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
        JMenuItem exitItem = new JMenuItem("Switch User");
        ActionListener listener = new ExitItemListener();
        exitItem.addActionListener(listener);
        menu.add(exitItem);
        return menu;
    }

}
