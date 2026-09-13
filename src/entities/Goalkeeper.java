package entities;

public class Goalkeeper extends Player {

    public Goalkeeper(int number, double xPos, double yPos) {
        super(number, xPos, yPos);
    }

    @Override
    public void pass() {
        if (!hasPossession(ball)) {
            return;
        }

        int index = Math.random() < 0.5 ? 1 : 2;
        Player receiver = team.getPlayers()[index];

        ball.moveTo(receiver.getXPos(), receiver.getYPos());
    }

}