package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleansGenerator {

    private static final Random random = new Random();

    public static List<Boolean> generateRandomBooleans(final int size) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(random.nextBoolean());
        }
        return result;
    }
}
