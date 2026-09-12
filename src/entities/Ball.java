package entities;

public class Ball extends Entity {

    public Ball(double xPos, double yPos) {
        super(xPos, yPos);
    }

    void move(double x, double y) {
        xPos += x;
        yPos += y;
    }

}
