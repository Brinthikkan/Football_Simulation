package app;

import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;               // added to try get the ball to Update every n milliseconds

import entities.Ball;
import entities.Player;
import entities.TeamComp;
import entities.Team;
import ui.SimulationPanel;

import world.GameMap;
import world.PlaySpace;
import world.MapPreset;

public class Main {

        public static void main(String[] args) {

                GameMap map = new GameMap(MapPreset.DEFAULT);
                PlaySpace playSpace = map.getPlaySpace();

                Frame frame = new Frame("Football Simulation");

                Player[] redPlayers = TeamComp.createLeftTeam(playSpace);
                Player[] bluePlayers = TeamComp.createRightTeam(playSpace);

                Team redTeam = new Team("Red Team", Color.RED, redPlayers);
                Team blueTeam = new Team("Blue Team", Color.BLUE, bluePlayers);

                Ball ball = new Ball(
                                playSpace.getWidth() / 2,
                                playSpace.getHeight() / 2);

                SimulationPanel panel = new SimulationPanel(
                                map,
                                redTeam,
                                blueTeam,
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