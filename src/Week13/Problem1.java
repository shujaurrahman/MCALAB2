package Week13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1 extends JFrame {

    private JTextField timeInput;
    private ClockPanel clockPanel;

    public Problem1() {
        setTitle("Clock Face");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the user input and button
        JPanel controlPanel = new JPanel();
        JLabel instructionLabel = new JLabel("Enter time (hh:mm):");
        timeInput = new JTextField(5);
        JButton setButton = new JButton("Set Time");

        controlPanel.add(instructionLabel);
        controlPanel.add(timeInput);
        controlPanel.add(setButton);

        add(controlPanel, BorderLayout.NORTH); // Position at the top

        // Create the clock panel
        clockPanel = new ClockPanel();
        add(clockPanel, BorderLayout.CENTER); // Main drawing area

        // Add action listener to the button
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeText = timeInput.getText();
                if (isValidTime(timeText)) {
                    clockPanel.setTime(timeText);
                    clockPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid time format. Please use hh:mm.");
                }
            }
        });
    }

    private boolean isValidTime(String time) {
        // Check if the input matches the hh:mm format
        Pattern pattern = Pattern.compile("^\\d{2}:\\d{2}$");
        Matcher matcher = pattern.matcher(time);
        if (matcher.find()) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return (hour >= 0 && hour < 24) && (minute >= 0 && minute < 60);
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Problem1 frame = new Problem1();
            frame.setVisible(true);
        });
    }

    // Custom JPanel for drawing the clock face
    static class ClockPanel extends JPanel {
        private String timeText = "00:00"; // Default time

        public void setTime(String timeText) {
            this.timeText = timeText;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw the clock face
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = 150;

            g2d.setColor(Color.WHITE); // Clock face
            g2d.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

            g2d.setColor(Color.BLACK); // Clock outline
            g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

            // Draw the minute ticks
            int tickLength = 10;
            for (int i = 0; i < 60; i++) {
                double angle = 2 * Math.PI * i / 60; // Radians
                int startX = (int) (centerX + (radius - tickLength) * Math.cos(angle));
                int startY = (int) (centerY + (radius - tickLength) * Math.sin(angle));
                int endX = (int) (centerX + radius * Math.cos(angle));
                int endY = (int) (centerY + radius * Math.sin(angle));
                g2d.drawLine(startX, startY, endX, endY);
            }

            // Parse the input time
            String[] parts = timeText.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            // Calculate the angles for the hour and minute hands
            double minuteAngle = 2 * Math.PI * minute / 60;
            double hourAngle = 2 * Math.PI * ((hour % 12) * 60 + minute) / 720;

            // Draw the minute hand
            g2d.setColor(Color.BLUE);
            int minuteEndX = (int) (centerX + (radius - tickLength) * Math.cos(minuteAngle - Math.PI / 2));
            int minuteEndY = (int) (centerY + (radius - tickLength) * Math.sin(minuteAngle - Math.PI / 2));
            g2d.drawLine(centerX, centerY, minuteEndX, minuteEndY);

            // Draw the hour hand
            g2d.setColor(Color.RED);
            int hourEndX = (int) (centerX + (radius - 40) * Math.cos(hourAngle - Math.PI / 2));
            int hourEndY = (int) (centerY + (radius - 40) * Math.sin(hourAngle - Math.PI / 2));
            g2d.drawLine(centerX, centerY, hourEndX, hourEndY);

            // Draw the center dot
            g2d.fillOval(centerX - 5, centerY - 5, 10, 10); // Center pivot
        }
    }
}

