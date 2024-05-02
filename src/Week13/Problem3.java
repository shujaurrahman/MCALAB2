package Week13;
import javax.swing.*;
import java.awt.*;

public class Problem3 extends JFrame {

    public Problem3() {
        setTitle("Circle Grid");
        setSize(300, 300); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a custom JPanel for drawing the grid of circles
        CirclePanel circlePanel = new CirclePanel();
        add(circlePanel); // Add the panel to the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Problem3 frame = new Problem3();
            frame.setVisible(true);
        });
    }

    // Custom JPanel for drawing the grid of circles
    static class CirclePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int circleDiameter = 40; // Diameter of the circles
            int padding = 20; // Space between circles
            int offsetX = 50; // Horizontal offset from the left edge
            int offsetY = 50; // Vertical offset from the top edge

            // Colors for the circles
            Color filledColor = Color.BLACK; // Color for filled circles
            Color emptyColor = Color.WHITE; // Color for empty circles

            // 3x3 grid pattern with filled circles
            Color[][] gridPattern = {
                    {filledColor, emptyColor, emptyColor}, // First row
                    {emptyColor, filledColor, emptyColor}, // Second row
                    {emptyColor, emptyColor, filledColor}  // Third row
            };

            // Draw the grid of circles based on the pattern
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int x = offsetX + col * (circleDiameter + padding); // Horizontal position
                    int y = offsetY + row * (circleDiameter + padding); // Vertical position

                    // Set the fill color based on the pattern
                    g2d.setColor(gridPattern[row][col]);
                    g2d.fillOval(x, y, circleDiameter, circleDiameter); // Draw the filled circle

                    // Draw a black outline for all circles
                    g2d.setColor(Color.BLACK);
                    g2d.drawOval(x, y, circleDiameter, circleDiameter); // Draw the outline
                }
            }
        }
    }
}
