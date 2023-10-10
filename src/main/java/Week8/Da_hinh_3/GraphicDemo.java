package Week8.Da_hinh_3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicDemo extends JPanel {

    public static void main(String[] args) {
        GraphicDemo panel = new GraphicDemo();

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the drawing color to red.
        g.setColor(Color.RED);

        // Draw a line from (0, 0) to (100, 100).
        g.drawLine(0, 0, 100, 100);

        // Draw a circle at (50, 50) with a radius of 20.
        g.drawOval(50, 50, 20, 20);
    }
}