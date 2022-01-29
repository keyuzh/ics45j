package labs.lab9;

import java.util.ArrayList;

public class User {
    private final String name;
    private String currentActivity;
    private String mood;
    private ArrayList<User> taggedFriends;

    public User(String name, String currentActivity, String mood) {
        this.name = name;
        this.currentActivity = currentActivity;
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public ArrayList<User> getTaggedFriends() {
        return taggedFriends;
    }

    public void setTaggedFriends(ArrayList<User> taggedFriends) {
        this.taggedFriends = taggedFriends;
    }

    public void save(String newActivity, String newMood, ArrayList<User> newtagged) {
        this.currentActivity = newActivity;
        this.mood = newMood;
        this.taggedFriends = newtagged;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("%s is feeling %s, %s", name, mood, currentActivity));
        if (!taggedFriends.isEmpty()) {
            result.append(" with ");
            for (int i = 0; i < taggedFriends.size(); i++) {
                result.append(taggedFriends.get(i).getName());
                if (i != taggedFriends.size()-1) {
                    result.append(", ");
                }
            }
        }
        return result.toString();
    }
}
