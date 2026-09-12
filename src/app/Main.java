package app;

import java.awt.*;
import java.awt.event.*;

import entities.Attacker;
import entities.Ball;
import entities.Defender;
import entities.Goalkeeper;
import entities.Midfielder;
import ui.SimulationPanel;
import entities.Player;

public class Main {

    public static void main(String[] args) {

        int pitchWidth = 1000;
        int pitchHeight = 650;

        Frame frame = new Frame("Football Simulation");

        Goalkeeper redGoalkeeper = new Goalkeeper(1, pitchWidth / 12, pitchHeight / 2);
        Defender redDefender1 = new Defender(2, pitchWidth / 5, pitchHeight / 3);
        Defender redDefender2 = new Defender(3, pitchWidth / 5, (pitchHeight * 2) / 3);
        Midfielder redMidfielder1 = new Midfielder(4, (pitchWidth * 2) / 5, pitchHeight / 5);
        Midfielder redMidfielder2 = new Midfielder(5, (pitchWidth * 2) / 5, (pitchHeight * 4) / 5);
        Attacker redAttacker = new Attacker(6, (pitchWidth * 3) / 5, pitchHeight / 2);

        Goalkeeper blueGoalkeeper = new Goalkeeper(1, (pitchWidth * 11) / 12, pitchHeight / 2);
        Defender blueDefender1 = new Defender(2, (pitchWidth * 4) / 5, pitchHeight / 3);
        Defender blueDefender2 = new Defender(3, (pitchWidth * 4) / 5, (pitchHeight * 2) / 3);
        Midfielder blueMidfielder1 = new Midfielder(4, (pitchWidth * 3) / 5, pitchHeight / 5);
        Midfielder blueMidfielder2 = new Midfielder(5, (pitchWidth * 3) / 5, (pitchHeight * 4) / 5);

        Attacker blueAttacker = new Attacker(6, (pitchWidth * 2) / 5, pitchHeight / 2);
Player[] redPlayers = {
        redGoalkeeper,
        redDefender1,
        redDefender2,
        redMidfielder1,
        redMidfielder2,
        redAttacker
};

        Player[] bluePlayers = {
        blueGoalkeeper,
        blueDefender1,
        blueDefender2,
        blueMidfielder1,
        blueMidfielder2,
        blueAttacker
};

        Ball ball = new Ball(
                redGoalkeeper.getXPos(),
                redGoalkeeper.getYPos());

        SimulationPanel panel = new SimulationPanel(redPlayers, bluePlayers, ball);


        panel.setPreferredSize(new Dimension(pitchWidth, pitchHeight));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        System.exit(0);
                    }
                });
    }
}