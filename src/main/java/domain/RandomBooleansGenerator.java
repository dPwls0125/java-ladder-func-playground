package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleansGenerator {

    private static final Random random = new Random();

    public static List<Boolean> generateRandomBooleans(final int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(random.nextInt(0, 2));
        }
        return convertToBoolean(randomNumbers);
    }

    private static List<Boolean> convertToBoolean(final List<Integer> numbers) {
        List<Boolean> result = new ArrayList<>();
        for (int number : numbers) {
            if (number == 0) result.add(false);
            if (number == 1) result.add(true);
        }
        return result;
    }
}
