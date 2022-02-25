package labs.lab9;

public class FriendTracker {
    private static FriendTrackerGUI gui;

    public static void showGUI(String name) {
        if (gui != null) {
            gui.dispose();
        }
        gui = new FriendTrackerGUI(name);
        gui.setVisible(true);
    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
        String name = login.newLogin();
        if (name == null) {
            System.exit(0);
        }
        showGUI(name);
    }
}
