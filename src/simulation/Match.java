package simulation;

import entities.Ball;
import entities.Player;
import entities.Team;

import java.util.ArrayList;

public class Match {

    private Team redTeam;
    private Team blueTeam;
    private Ball ball;

    private GameState gameState;
    private Ruleset ruleset;

    
    private ArrayList<GoalEvent> goalEvents;

    private final ArrayList<MatchListener> listeners = new ArrayList<>();

    public void addMatchListener(MatchListener listener) {
    listeners.add(listener);
    }

    public void removeMatchListener(MatchListener listener) {
    listeners.remove(listener);
    }

    
    public Match(Team redTeam, Team blueTeam, Ball ball) {

        this.redTeam = redTeam;
        this.blueTeam = blueTeam;
        this.ball = ball;

        this.gameState = new GameState(
                redTeam,
                blueTeam,
                ball
        );
        this.ruleset = new Ruleset();
        this.goalEvents = new ArrayList<>();
    }

    

    public void start() {

        if (!gameState.isRunning()) {
            gameState.startMatch();

            System.out.println("Match started!");
        }
    }

    

    public void pause() {

        if (gameState.isRunning() && !gameState.isPaused()) {
            gameState.pauseMatch();

            System.out.println("Match paused.");

            for (MatchListener listener : listeners) {
            listener.onMatchStarted();
        }
        }
    }

    
    public void resume() {

        if (gameState.isRunning() && gameState.isPaused()) {
            gameState.resumeMatch();

            System.out.println("Match resumed.");
        }
    }


    public void end() {

        if (gameState.isRunning()) {
            gameState.endMatch();

            System.out.println("Match finished!");

            for (MatchListener listener : listeners) {
             listener.onMatchEnded();
            }
            
            System.out.println(
                    "Final Score: "
                            + gameState.getRedScore()
                            + " - "
                            + gameState.getBlueScore()
            );
            printMatchStatistics();
        }
    }

   

    public void update(int seconds) {

        if (!gameState.isRunning()) {
            return;
        }

        if (gameState.isPaused()) {
            return;
        }

        gameState.updateTime(seconds);
    }

    

    public void recordGoal(
            Player scorer,
            Team scoringTeam,
            Player assister,
            boolean ownGoal) {

        if (!gameState.isRunning()) {
            return;
        }

        GoalEvent goalEvent = new GoalEvent(
                scorer,
                scoringTeam,
                assister,
                gameState.getElapsedTime(),
                ownGoal
        );

        goalEvents.add(goalEvent);

        for (MatchListener listener : listeners) {
         listener.onGoalScored(goalEvent);
        }

       
        if (scoringTeam == redTeam) {
            gameState.addRedGoal();
        } else if (scoringTeam == blueTeam) {
            gameState.addBlueGoal();
        }

        System.out.println(goalEvent);
        System.out.println(
                "Score: "
                        + gameState.getRedScore()
                        + " - "
                        + gameState.getBlueScore()
        );
    }

    public void reset() {

        gameState.reset();
        goalEvents.clear();

        System.out.println("Match reset.");
    }

    public GameState getGameState() {
        return gameState;
    }

    public Team getRedTeam() {
        return redTeam;
    }

    public Team getBlueTeam() {
        return blueTeam;
    }

    public Ball getBall() {
        return ball;
    }

    public Ruleset getRuleset() {
    return ruleset;
    }

    public ArrayList<GoalEvent> getGoalEvents() {
        return goalEvents;
    }

    public MatchStatistics getStatistics() {
        return new MatchStatistics(goalEvents);
    }

    public void printMatchStatistics() {
        MatchStatistics stats = getStatistics();

        System.out.println("=== MATCH STATISTICS ===");
        System.out.println("Total goals: "
                + stats.getTotalGoals());
        System.out.println("Own goals: "
                + stats.getOwnGoals());
        System.out.println("Goals by player: "
                + stats.getPlayerGoals());
        System.out.println("Top scorer goal count: "
                + stats.getTopScorerGoalCount());
    }

}
