import java.util.*;

public class Main {
    public static void main(String[] args) {
        String idealWord = "ala ma kota";
        List<Individual> population = new ArrayList<>();
        int numberOfpopulation = 1000;
        for (int i = 0; i < numberOfpopulation; i++) {
            population.add(new Individual(idealWord));
        }

        for (int t = 0; t < 500; t++) {
            int sumOfFit = 0;
            for (Individual individual : population) {
                individual.fitness(idealWord);
                sumOfFit += individual.fit;
            }


            for (Individual individual : population) {
                individual.setBetween01(sumOfFit);

            }


            population.sort(Individual.comp());
            if (population.get(0).word.equals(idealWord)) {

                System.out.println(t + " time");
                break;
            }


            Random generator = new Random();
            List<Individual> newPopulation = new ArrayList<>();
            for (int i = 0; i < numberOfpopulation; i++) {
                double x = generator.nextDouble();
                int indexM = numberOfpopulation - 1;
                double which = 0;
                for (int j = 0; j < numberOfpopulation; j++) {
                    which += population.get(j).between01;

                    if (which > x) {
                        indexM = j;
                        break;
                    }
                }
                x = generator.nextDouble();
                which = 0;
                int indexF = numberOfpopulation - 1;
                for (int j = 0; j < numberOfpopulation; j++) {
                    which += population.get(j).between01;
                    if (which > x) {
                        indexF = j;
                        break;
                    }
                }
                newPopulation.add(new Individual(population.get(indexM).word,
                        population.get(indexF).word));
            }
            population = newPopulation;
        }


        System.out.println(population.get(0).word + " " + population.get(0).fit);

    }
}
