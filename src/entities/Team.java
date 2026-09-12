package entities;

import java.awt.Color;

public class Team {

    private String name;
    private Color color;
    private Player[] players;

    public Team(String name, Color color, Player[] players) {
        this.name = name;
        this.color = color;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Player[] getPlayers() {
        return players;
    }

}