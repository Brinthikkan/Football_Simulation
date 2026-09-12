package app;

import java.awt.*;
import java.awt.event.*;

import entities.Attacker;
import entities.Ball;
import entities.Defender;
import entities.Goalkeeper;
import entities.Midfielder;
import entities.Player;

import ui.SimulationPanel;

import world.GameMap;
import world.PlaySpace;
import world.MapPreset;

public class Main {

        public static void main(String[] args) {

                GameMap map = new GameMap(MapPreset.DEFAULT);
                PlaySpace playSpace = map.getPlaySpace();

                Frame frame = new Frame("Football Simulation");

                Goalkeeper redGoalkeeper = new Goalkeeper(1, playSpace.getWidth() / 12, playSpace.getHeight() / 2);
                Defender redDefender1 = new Defender(2, playSpace.getWidth() / 5, playSpace.getHeight() / 3);
                Defender redDefender2 = new Defender(3, playSpace.getWidth() / 5, (playSpace.getHeight() * 2) / 3);
                Midfielder redMidfielder1 = new Midfielder(4, (playSpace.getWidth() * 2) / 5,
                                playSpace.getHeight() / 5);
                Midfielder redMidfielder2 = new Midfielder(5, (playSpace.getWidth() * 2) / 5,
                                (playSpace.getHeight() * 4) / 5);
                Attacker redAttacker = new Attacker(6, (playSpace.getWidth() * 3) / 5, playSpace.getHeight() / 2);

                Goalkeeper blueGoalkeeper = new Goalkeeper(1, (playSpace.getWidth() * 11) / 12,
                                playSpace.getHeight() / 2);
                Defender blueDefender1 = new Defender(2, (playSpace.getWidth() * 4) / 5, playSpace.getHeight() / 3);
                Defender blueDefender2 = new Defender(3, (playSpace.getWidth() * 4) / 5,
                                (playSpace.getHeight() * 2) / 3);
                Midfielder blueMidfielder1 = new Midfielder(4, (playSpace.getWidth() * 3) / 5,
                                playSpace.getHeight() / 5);
                Midfielder blueMidfielder2 = new Midfielder(5, (playSpace.getWidth() * 3) / 5,
                                (playSpace.getHeight() * 4) / 5);

                Attacker blueAttacker = new Attacker(6, (playSpace.getWidth() * 2) / 5, playSpace.getHeight() / 2);

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
                                playSpace.getWidth() / 2,
                                playSpace.getHeight() / 2);

                // redGoalkeeper.getXPos(),
                // redGoalkeeper.getYPos());

                SimulationPanel panel = new SimulationPanel(
                                map,
                                redPlayers,
                                bluePlayers,
                                ball);

                panel.setPreferredSize(
                                new Dimension(
                                                (int) (playSpace.getWidth() + map.getMarginX() * 2),
                                                (int) (playSpace.getHeight() + map.getMarginY() * 2)));

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