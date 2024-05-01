package WEEK_10;

import java.util.Random;

public class w10q3 {
    private static final int NUM_PARTICLES = 30;
    private static final int MAX_ITERATIONS = 100;
    private static final double C1 = 2.0;
    private static final double C2 = 2.0;
    private static final double INERTIA_WEIGHT = 0.5;

    private static final double LOWER_BOUND = -10.0;
    private static final double UPPER_BOUND = 10.0;

    public static void main(String[] args) {
        w10q3 pso = new w10q3();
        double[] bestPosition = pso.psoAlgorithm();
        double bestFitness = pso.fitnessFunction(bestPosition);
        System.out.println("Optimal Solution: ");
        for (int i = 0; i < bestPosition.length; i++) {
            System.out.println("x[" + i + "] = " + bestPosition[i]);
        }
        System.out.println("Fitness Value: " + bestFitness);
    }

    private double[] psoAlgorithm() {
        Particle[] swarm = new Particle[NUM_PARTICLES];
        double[] globalBestPosition = new double[2]; // Assuming 2 dimensions for simplicity
        double globalBestFitness = Double.POSITIVE_INFINITY;

        Random rand = new Random();
        // Initialize particles and velocities randomly
        for (int i = 0; i < NUM_PARTICLES; i++) {
            double[] position = {LOWER_BOUND + (UPPER_BOUND - LOWER_BOUND) * rand.nextDouble(),
                    LOWER_BOUND + (UPPER_BOUND - LOWER_BOUND) * rand.nextDouble()};
            double[] velocity = {(rand.nextDouble() - 0.5) * 0.1, (rand.nextDouble() - 0.5) * 0.1};
            swarm[i] = new Particle(position, velocity);
        }

        for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
            for (Particle particle : swarm) {
                double[] currentPosition = particle.getPosition();
                double[] currentVelocity = particle.getVelocity();
                double[] personalBestPosition = particle.getPersonalBestPosition();
                double personalBestFitness = particle.getPersonalBestFitness();

                double[] newVelocity = new double[currentVelocity.length];
                double[] newPosition = new double[currentPosition.length];

                for (int i = 0; i < currentPosition.length; i++) {
                    // Update velocity
                    newVelocity[i] = INERTIA_WEIGHT * currentVelocity[i] +
                            C1 * rand.nextDouble() * (personalBestPosition[i] - currentPosition[i]) +
                            C2 * rand.nextDouble() * (globalBestPosition[i] - currentPosition[i]);

                    // Update position
                    newPosition[i] = currentPosition[i] + newVelocity[i];

                    // Apply bounds
                    if (newPosition[i] < LOWER_BOUND) {
                        newPosition[i] = LOWER_BOUND;
                        newVelocity[i] *= -1;
                    } else if (newPosition[i] > UPPER_BOUND) {
                        newPosition[i] = UPPER_BOUND;
                        newVelocity[i] *= -1;
                    }
                }

                // Update particle
                particle.setPosition(newPosition);
                particle.setVelocity(newVelocity);

                // Update personal best
                double newFitness = fitnessFunction(newPosition);
                if (newFitness < personalBestFitness) {
                    particle.setPersonalBestFitness(newFitness);
                    particle.setPersonalBestPosition(newPosition);
                }

                // Update global best
                if (newFitness < globalBestFitness) {
                    globalBestFitness = newFitness;
                    globalBestPosition = newPosition;
                }
            }
        }
        return globalBestPosition;
    }

    private double fitnessFunction(double[] position) {
        // Example fitness function: f(x) = x^2
        double result = 0;
        for (double x : position) {
            result += x * x;
        }
        return result;
    }

    private static class Particle {
        private double[] position;
        private double[] velocity;
        private double[] personalBestPosition;
        private double personalBestFitness;

        public Particle(double[] position, double[] velocity) {
            this.position = position;
            this.velocity = velocity;
            this.personalBestPosition = position.clone();
            this.personalBestFitness = Double.POSITIVE_INFINITY;
        }

        public double[] getPosition() {
            return position;
        }

        public void setPosition(double[] position) {
            this.position = position;
        }

        public double[] getVelocity() {
            return velocity;
        }

        public void setVelocity(double[] velocity) {
            this.velocity = velocity;
        }

        public double[] getPersonalBestPosition() {
            return personalBestPosition;
        }

        public void setPersonalBestPosition(double[] personalBestPosition) {
            this.personalBestPosition = personalBestPosition;
        }

        public double getPersonalBestFitness() {
            return personalBestFitness;
        }

        public void setPersonalBestFitness(double personalBestFitness) {
            this.personalBestFitness = personalBestFitness;
        }
    }
}
