import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {

        Frame frame = new Frame("Virus Simulation");

        SimulationPanel panel = new SimulationPanel();

        frame.add(panel);

        frame.setSize(800, 600);
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