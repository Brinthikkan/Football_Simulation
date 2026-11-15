package simulation;

public interface MatchListener {

    void onMatchStarted();

    void onGoalScored(GoalEvent goal);

    void onMatchEnded();
}
