package labs.lab9;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final String currentActivity;
    private final Mood mood;
    private final List<String> taggedFriends;

    public User(String name) {
        this.name = name;
        this.currentActivity = "";
        this.mood = Mood.Happy;
        this.taggedFriends = new ArrayList<>();
    }
    public User(String name, String newActivity, Mood newMood, List<String> newtagged) {
        this.name = name;
        this.currentActivity = newActivity;
        this.mood = newMood;
        this.taggedFriends = newtagged;
    }

    public String getName() {
        return name;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public Mood getMood() {
        return mood;
    }

    public List<String> getTaggedFriends() {
        return taggedFriends;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s is feeling %s, %s", name, mood, currentActivity));
        if (!taggedFriends.isEmpty()) {
            sb.append(" with ");
            sb.append(String.join(", ", taggedFriends));
        }
        return sb.toString();
    }
}
