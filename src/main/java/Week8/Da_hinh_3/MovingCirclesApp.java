package Week8.Da_hinh_3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MovingCirclesApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Circles Example");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MovingCirclesPanel movingCirclesPanel = new MovingCirclesPanel();
            frame.add(movingCirclesPanel);

            Timer timer = new Timer(16, e -> movingCirclesPanel.moveCircles(frame.getWidth(), frame.getHeight()));
            timer.start();

            frame.setVisible(true);
        });
    }
}