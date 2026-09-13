package entities;

public abstract class Player extends Entity {

    int number;
    Ball ball;
    Team team;

    double spawnX;
    double spawnY;

    Player(int number, double xPos, double yPos) {
        super(xPos, yPos);
        this.number = number;
        this.spawnX = xPos;
        this.spawnY = yPos;
    }

    public void setMatchDetails(Ball ball, Team team) {
        this.ball = ball;
        this.team = team;
    }

    public void resetPositon() {
        xPos = spawnX;
        yPos = spawnY;
    }

    public boolean hasPossession(Ball ball) {
        return xPos == ball.xPos && yPos == ball.yPos;
    }

    public abstract void pass();

}