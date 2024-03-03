package WEEK_10;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class w10q2 {
    private static final int POPULATION_SIZE = 100;
    private static final double MUTATION_RATE = 0.01;
    private static final int TARGET_PRIME = 97;
    private static final int MAX_GENERATIONS = 1000;

    public static void main(String[] args) {
        w10q2 finder = new w10q2();
        int foundPrime = finder.geneticAlgorithm();
        System.out.println("Found prime number: " + foundPrime);
    }

    private int geneticAlgorithm() {
        List<Chromosome> population = initializePopulation();
        int generation = 0;
        while (generation < MAX_GENERATIONS) {
            population = selectPopulation(population);
            population = crossoverPopulation(population);
            mutatePopulation(population);
            for (Chromosome chromosome : population) {
                if (isPrime(chromosome.getValue())) {
                    return Integer.parseInt(chromosome.getValue(), 2); // Parse binary string to int
                }
            }
            generation++;
        }
        return -1; // Prime not found within maximum generations
    }

    private List<Chromosome> initializePopulation() {
        List<Chromosome> population = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            int value = random.nextInt(TARGET_PRIME * 2) + 2; // Random number between 2 and 2 * TARGET_PRIME
            population.add(new Chromosome(value));
        }
        return population;
    }

    private List<Chromosome> selectPopulation(List<Chromosome> population) {
        // For simplicity, let's just use a tournament selection
        List<Chromosome> selected = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            int idx1 = random.nextInt(population.size());
            int idx2 = random.nextInt(population.size());
            Chromosome chromosome1 = population.get(idx1);
            Chromosome chromosome2 = population.get(idx2);
            selected.add(chromosome1.getFitness() > chromosome2.getFitness() ? chromosome1 : chromosome2);
        }
        return selected;
    }

    private List<Chromosome> crossoverPopulation(List<Chromosome> population) {
        // For simplicity, let's use single-point crossover
        List<Chromosome> newPopulation = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            int idx1 = random.nextInt(population.size());
            int idx2 = random.nextInt(population.size());
            Chromosome parent1 = population.get(idx1);
            Chromosome parent2 = population.get(idx2);
            int crossoverPoint = random.nextInt(Chromosome.CHROMOSOME_LENGTH);
            String childValue = parent1.getValue().substring(0, crossoverPoint) +
                    parent2.getValue().substring(crossoverPoint);
            newPopulation.add(new Chromosome(childValue));
        }
        return newPopulation;
    }

    private void mutatePopulation(List<Chromosome> population) {
        Random random = new Random();
        for (Chromosome chromosome : population) {
            if (random.nextDouble() < MUTATION_RATE) {
                int mutationPoint = random.nextInt(Chromosome.CHROMOSOME_LENGTH);
                String newValue = chromosome.getValue();
                char bit = newValue.charAt(mutationPoint);
                if (bit == '0') {
                    bit = '1';
                } else {
                    bit = '0';
                }
                newValue = newValue.substring(0, mutationPoint) + bit + newValue.substring(mutationPoint + 1);
                chromosome.setValue(newValue);
            }
        }
    }

    private boolean isPrime(String value) {
        int number = Integer.parseInt(value, 2); // Convert binary string to integer
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }


    private static class Chromosome {
        private static final int CHROMOSOME_LENGTH = 8; // Number of bits for simplicity
        private String value;

        public Chromosome(int value) {
            this.value = String.format("%" + CHROMOSOME_LENGTH + "s", Integer.toBinaryString(value)).replace(' ', '0');
        }

        public Chromosome(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getFitness() {
            return Math.abs(Integer.parseInt(value, 2) - TARGET_PRIME);
        }
    }
}
