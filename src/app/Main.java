package app;

import java.awt.*;
import java.awt.event.*;

import entities.Attacker;
import entities.Ball;
import entities.Defender;
import entities.Goalkeeper;
import entities.Midfielder;
import ui.SimulationPanel;

public class Main {

    public static void main(String[] args) {

        int pitchWidth = 1000;
        int pitchHeight = 650;

        Frame frame = new Frame("Football Simulation");

        SimulationPanel panel = new SimulationPanel();

        Goalkeeper goalkeeper = new Goalkeeper(1, pitchWidth / 12, pitchHeight / 2);
        Defender defender1 = new Defender(2, pitchWidth / 5, pitchHeight / 3);
        Defender defender2 = new Defender(3, pitchWidth / 5, (pitchHeight * 2) / 3);
        Midfielder midfielder1 = new Midfielder(4, (pitchWidth * 2) / 5, pitchHeight / 5);
        Midfielder midfielder2 = new Midfielder(5, (pitchWidth * 2) / 5, (pitchHeight * 4) / 5);
        Attacker attacker = new Attacker(6, (pitchWidth * 3) / 5, pitchHeight / 2);

        Ball ball = new Ball(
                goalkeeper.getXPos(),
                goalkeeper.getYPos());

        System.out.println(goalkeeper.hasPossession(ball));
        System.out.println(defender1.hasPossession(ball));

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