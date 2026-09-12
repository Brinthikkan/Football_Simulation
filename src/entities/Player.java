package entities;

public abstract class Player extends Entity {

    int number;

    double spawnX;
    double spawnY;

    Player(int number, double xPos, double yPos) {
        super(xPos, yPos);
        this.number = number;
        this.spawnX = xPos;
        this.spawnY = yPos;
    }

    public void resetPositon(){
        xPos = spawnX;
        yPos = spawnY;
    }


    public boolean hasPossession(Ball ball) {
        return xPos == ball.xPos && yPos == ball.yPos;
    }

    abstract void pass();

}