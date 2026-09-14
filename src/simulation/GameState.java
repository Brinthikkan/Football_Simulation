package simulation;

import entities.Ball;
import entities.Team;

public class GameState {

    private Team redTeam;
    private Team blueTeam;
    private Ball ball;

    private int redScore;
    private int blueScore;

    private int elapsedTime;

    private boolean running;
    private boolean paused;

    private MatchPhase currentPhase;

    public GameState(Team redTeam, Team blueTeam, Ball ball) {
        this.redTeam = redTeam;
        this.blueTeam = blueTeam;
        this.ball = ball;

        this.redScore = 0;
        this.blueScore = 0;

        this.elapsedTime = 0;

        this.running = false;
        this.paused = false;

        this.currentPhase = MatchPhase.NOT_STARTED;
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



    public int getRedScore() {
        return redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }

    public void addRedGoal() {
        redScore++;
    }

    public void addBlueGoal() {
        blueScore++;
    }



    public int getElapsedTime() {
        return elapsedTime;
    }

    public void updateTime(int seconds) {
        if (running && !paused && seconds > 0) {
            elapsedTime += seconds;
        }
    }



    public boolean isRunning() {
        return running;
    }

    public boolean isPaused() {
        return paused;
    }

    public void startMatch() {
        running = true;
        paused = false;
        currentPhase = MatchPhase.FIRST_HALF;
    }

    public void pauseMatch() {
        if (running) {
            paused = true;
        }
    }

    public void resumeMatch() {
        if (running) {
            paused = false;
        }
    }

    public void endMatch() {
        running = false;
        paused = false;
        currentPhase = MatchPhase.FINISHED;
    }



    public MatchPhase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(MatchPhase currentPhase) {
        this.currentPhase = currentPhase;
    }

    

    public void reset() {
        redScore = 0;
        blueScore = 0;
        elapsedTime = 0;

        running = false;
        paused = false;

        currentPhase = MatchPhase.NOT_STARTED;
    }

    
    public String toString() {
        return "GameState{" +
                "redScore=" + redScore +
                ", blueScore=" + blueScore +
                ", elapsedTime=" + elapsedTime +
                ", running=" + running +
                ", paused=" + paused +
                ", currentPhase=" + currentPhase +
                '}';
    }
}