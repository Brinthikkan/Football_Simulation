package entities;

public abstract class Player extends Entity {

    int number;

    Player(int number, int xPos, int yPos) {
        super(xPos, yPos);
        this.number = number;
    }

    public boolean hasPossession(Ball ball) {
        return xPos == ball.xPos && yPos == ball.yPos;
    }

    abstract void pass();

}