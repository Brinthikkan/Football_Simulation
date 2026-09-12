package world;

public class PlaySpace {

    private double width;
    private double height;

    private Goal leftGoal;
    private Goal rightGoal;

    public PlaySpace(double width, double height) {
        this.width = width;
        this.height = height;

        double goalWidth = 150;
        double goalHeight = 300;

        double goalY = (height - goalHeight) / 2;

        leftGoal = new Goal(
                0,
                goalY,
                goalWidth,
                goalHeight);

        rightGoal = new Goal(
                width - goalWidth,
                goalY,
                goalWidth,
                goalHeight);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Goal getLeftGoal() {
        return leftGoal;
    }

    public Goal getRightGoal() {
        return rightGoal;
    }

}