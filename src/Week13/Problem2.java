package Week13;

import javax.swing.*;
import java.awt.*;

public class Problem2 extends JFrame {

    public Problem2() {
        setTitle("House Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a custom JPanel for drawing the house
        HousePanel housePanel = new HousePanel();
        add(housePanel); // Add the panel to the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Problem2 frame = new Problem2();
            frame.setVisible(true);
        });
    }

    // Custom JPanel for drawing the house
    static class HousePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw the lower part of the house (rectangle)
            int houseWidth = 200;
            int houseHeight = 150;
            int houseX = (getWidth() - houseWidth) / 2; // Center horizontally
            int houseY = (getHeight() - houseHeight) / 2 + 50; // Slightly lower to make space for the roof

            g2d.setColor(Color.LIGHT_GRAY); // House color
            g2d.fillRect(houseX, houseY, houseWidth, houseHeight); // Draw the house rectangle

            // Draw the roof (triangle)
            int roofHeight = 100; // Height of the triangle roof
            int roofTopX = houseX + (houseWidth / 2); // Top point
            int roofTopY = houseY - roofHeight; // Vertical position of the top point

            Polygon roof = new Polygon(
                    new int[] {houseX, roofTopX, houseX + houseWidth}, // x-coordinates
                    new int[] {houseY, roofTopY, houseY}, // y-coordinates
                    3 // Number of points
            );

            g2d.setColor(Color.RED); // Roof color
            g2d.fillPolygon(roof); // Draw the roof triangle

            // Draw the door (rectangle)
            int doorWidth = 50;
            int doorHeight = 80;
            int doorX = houseX + (houseWidth - doorWidth) / 2; // Center horizontally
            int doorY = houseY + houseHeight - doorHeight; // Lower edge

            g2d.setColor(Color.DARK_GRAY); // Door color
            g2d.fillRect(doorX, doorY, doorWidth, doorHeight); // Draw the door rectangle

            // Draw the window (rectangle)
            int windowWidth = 40;
            int windowHeight = 40;
            int windowX = houseX + 30; // Some offset from the left edge
            int windowY = houseY + 30; // Some offset from the top edge

            g2d.setColor(Color.WHITE); // Window color
            g2d.fillRect(windowX, windowY, windowWidth, windowHeight); // Draw the window rectangle
        }
    }
}
