package entities;

public class Midfielder extends Player {

    public Midfielder(int number, double xPos, double yPos) {
        super(number, xPos, yPos);
    }

    @Override
    public void pass() {
        if (!hasPossession(ball)) {
            return;
        }

        Player receiver = team.getPlayers()[5];

        ball.moveTo(receiver.getXPos(), receiver.getYPos());
    }

}