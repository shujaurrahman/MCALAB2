package Week13;
import javax.swing.*;
import java.awt.*;

public class Problem4 extends JFrame {

    public Problem4() {
        setTitle("Bull's Eye Pattern");
        setSize(400, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a custom JPanel for drawing the bull's eye pattern
        BullsEyePanel bullsEyePanel = new BullsEyePanel();
        add(bullsEyePanel); // Add the panel to the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Problem4 frame = new Problem4();
            frame.setVisible(true);
        });
    }

    // Custom JPanel for drawing the bull's eye pattern
    static class BullsEyePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int totalRings = 5; // Number of concentric rings
            int initialDiameter = 200; // Diameter of the largest circle
            int centerX = getWidth() / 2; // Horizontal center
            int centerY = getHeight() / 2; // Vertical center

            // Loop to draw concentric rings
            for (int i = 0; i < totalRings; i++) {
                // Alternate the color between black and white
                if (i % 2 == 0) {
                    g2d.setColor(Color.BLACK); // Black for even indices
                } else {
                    g2d.setColor(Color.WHITE); // White for odd indices
                }

                // Diameter of the current circle
                int diameter = initialDiameter - (i * (initialDiameter / totalRings));

                // Calculate the position to keep circles centered
                int x = centerX - (diameter / 2);
                int y = centerY - (diameter / 2);

                // Draw the filled circle
                g2d.fillOval(x, y, diameter, diameter);
            }
        }
    }
}

