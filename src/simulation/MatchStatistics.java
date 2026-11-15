package simulation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import entities.Player;

public class MatchStatistics {

    private final List<GoalEvent> goals;

    public MatchStatistics(List<GoalEvent> goals) {
        this.goals = goals;
    }

 public long getTotalGoals() {
        return goals.stream().count();
    }

public long getOwnGoals() {
        return goals.stream()
                .filter(GoalEvent::isOwnGoal)
                .count();
    }

 public Map<Player, Long> getPlayerGoals() {
        return goals.stream()
                .filter(goal -> !goal.isOwnGoal())
                .filter(goal -> goal.getScorer() != null)
                .collect(Collectors.groupingBy(
                        GoalEvent::getScorer,
                        Collectors.counting()
                ));
    }

public long getTopScorerGoalCount() {
        return getPlayerGoals().values().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0);
    }
}
