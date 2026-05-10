package Engine;

import java.util.ArrayList;

public class QuestLog {

    private ArrayList<String> completedQuests;

    public QuestLog() {
        this.completedQuests = new ArrayList<>();
    }
    //mark if quest is completed
    public void complete(String questId) {
        if (!isCompleted(questId)) {
            completedQuests.add(questId);
            System.out.println("  [Quest Log] ✔ " + formatId(questId));
        }
    }

   //chech if the quest is already completed
    public boolean isCompleted(String questId) {
        return completedQuests.contains(questId);
    }
    //return the total number of completed quests
    public int getTotalCompleted() {
        return completedQuests.size();
    }
}