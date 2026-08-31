import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {

        Frame frame = new Frame("Football Simulation");

        SimulationPanel panel = new SimulationPanel();

        panel.setPreferredSize(new Dimension(1000, 650));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            }
        );
    }
}