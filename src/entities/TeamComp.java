package entities;

import world.PlaySpace;

public class TeamComp {

    public static Player[] createLeftTeam(PlaySpace playSpace) {

        return new Player[] {
                new Goalkeeper(
                        1,
                        playSpace.getWidth() / 12,
                        playSpace.getHeight() / 2),

                new Defender(
                        2,
                        playSpace.getWidth() / 5,
                        playSpace.getHeight() / 3),

                new Defender(
                        3,
                        playSpace.getWidth() / 5,
                        (playSpace.getHeight() * 2) / 3),

                new Midfielder(
                        4,
                        (playSpace.getWidth() * 2) / 5,
                        playSpace.getHeight() / 5),

                new Midfielder(
                        5,
                        (playSpace.getWidth() * 2) / 5,
                        (playSpace.getHeight() * 4) / 5),

                new Attacker(
                        6,
                        (playSpace.getWidth() * 3) / 5,
                        playSpace.getHeight() / 2)

        };

    }

    public static Player[] createRightTeam(PlaySpace playSpace) {

        return new Player[] {
                new Goalkeeper(
                        1,
                        (playSpace.getWidth() * 11) / 12,
                        playSpace.getHeight() / 2),

                new Defender(
                        2,
                        (playSpace.getWidth() * 4) / 5,
                        playSpace.getHeight() / 3),

                new Defender(
                        3,
                        (playSpace.getWidth() * 4) / 5,
                        (playSpace.getHeight() * 2) / 3),

                new Midfielder(
                        4,
                        (playSpace.getWidth() * 3) / 5,
                        playSpace.getHeight() / 5),

                new Midfielder(
                        5,
                        (playSpace.getWidth() * 3) / 5,
                        (playSpace.getHeight() * 4) / 5),

                new Attacker(
                        6,
                        (playSpace.getWidth() * 2) / 5,
                        playSpace.getHeight() / 2)

        };

    }

}
