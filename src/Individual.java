import java.util.Comparator;
import java.util.Random;

public class Individual {
    public String word;
    public int fit;
    public double between01;

    public void fitness(String idealWord) {
        int f = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == idealWord.charAt(i)) {
                f++;
            }

        }
        fit = f;
    }

    public Individual(String idealWord) {
        Random generator = new Random();
        StringBuilder d = new StringBuilder();
        for (int i = 0; i < idealWord.length(); i++) {
            int x = generator.nextInt(27);
            if (x == 26)
                d.append(" ");
            else
                d.append((char) (x + 'a'));
        }
        word = d.toString();
    }

    public Individual(String mother, String father) {

        Random generator = new Random();
        StringBuilder d = new StringBuilder();
        for (int i = 0; i < mother.length() / 2; i++) {
            int mutation = generator.nextInt(1000);
            if (mutation > 50)
                d.append(mother.charAt(i));
            else {
                int x = generator.nextInt(27);

                if (x == 26)
                    d.append(" ");
                else
                    d.append((char) (x + 'a'));
            }
        }
        for (int i = father.length() / 2; i < father.length(); i++) {
            int mutation = generator.nextInt(1000);
            if (mutation > 50)
                d.append(father.charAt(i));
            else {
                int x = generator.nextInt(27);

                if (x == 26)
                    d.append(" ");
                else
                    d.append((char) (x + 'a'));
            }
        }
        word = d.toString();
    }


    public static Comparator<Individual> comp() {
        return (i1, i2) -> i2.fit - i1.fit;
    }

    public void setBetween01(int sumOfFit) {


        between01 = (double) fit / sumOfFit;

    }
}
