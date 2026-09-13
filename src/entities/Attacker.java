package entities;

public class Attacker extends Player {

    public Attacker(int number, double xPos, double yPos) {
        super(number, xPos, yPos);
    }

    @Override
    public void pass() {
        if (!hasPossession(ball)) {
            return;
        }

        int index = Math.random() < 0.5 ? 3 : 4;
        Player receiver = team.getPlayers()[index];

        ball.moveTo(receiver.getXPos(), receiver.getYPos());
    }

}
