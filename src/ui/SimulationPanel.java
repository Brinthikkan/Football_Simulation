package ui;

import java.awt.*;
import entities.Player;
import entities.Ball;

public class SimulationPanel extends Panel {

    private Player[] redPlayers;
    private Player[] bluePlayers;
    private Ball ball;

    public SimulationPanel(
            Player[] redPlayers,
            Player[] bluePlayers,
            Ball ball) {

        this.redPlayers = redPlayers;
        this.bluePlayers = bluePlayers;
        this.ball = ball;

        setBackground(Color.GREEN);
    }

    private void drawPlayers(Graphics g, Player[] players, Color colour) {

        int playerSize = 24;

        g.setColor(colour);

        for (Player player : players) {
            g.fillOval(
                    player.getXPos() - playerSize / 2,
                    player.getYPos() - playerSize / 2,
                    playerSize,
                    playerSize);
        }
    }

    public void paint(Graphics g) {

        g.setColor(Color.WHITE);

        int width = getWidth();
        int height = getHeight();

        g.drawLine(width / 2, 0, width / 2, height);
        g.drawRect(0, 175, 150, 300);
        g.drawRect(width - 150, 175, 150, 300);

        g.setColor(Color.RED);

        drawPlayers(g, redPlayers, Color.RED);
        drawPlayers(g, bluePlayers, Color.BLUE);
        int ballSize = 12;

        g.setColor(Color.WHITE);
        g.fillOval(
                ball.getXPos() - ballSize / 2,
                ball.getYPos() - ballSize / 2,
                ballSize,
                ballSize);

        g.setColor(Color.BLACK);
        g.drawOval(
                ball.getXPos() - ballSize / 2,
                ball.getYPos() - ballSize / 2,
                ballSize,
                ballSize);
    }
}