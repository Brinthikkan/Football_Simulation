import java.awt.*;

public class SimulationPanel extends Panel {

    SimulationPanel(){
        setBackground(Color.GREEN);
    }

    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        int width = getWidth();
        int height = getHeight();

        System.out.println("Width: " + width);
        System.out.println("Height:" + height);


        g.drawLine(width/2, 0, width/2, height);
        g.drawRect(0, 175, 150, 300);
        g.drawRect(width-150, 175, 150, 300);
    }

}