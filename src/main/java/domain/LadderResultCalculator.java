package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResultCalculator {

    public static List<Integer> calculate(Ladder ladder) {
        List<Integer> result = new ArrayList<>();
        List<Line> lines = ladder.getLines();
        int width = ladder.getLadderScale().getWidth();
        int height = ladder.getLadderScale().getHeight();

        for (int i = 0; i < width; i++) {
            int position = moveThroughLadder(i, lines, width, height);
            result.add(position);
        }
        return result;
    }

    private static int moveThroughLadder(int start, List<Line> lines, int width, int height) {
        int position = start;
        for (int row = 0; row < height; row++) {
            List<Boolean> points = lines.get(row).getPoints();
            position = moveHorizontally(points, position, width);
        }
        return position;
    }

    private static int moveHorizontally(List<Boolean> points, int position, int width) {
        if (canMoveLeft(points, position)) return position - 1;
        if (canMoveRight(points, position, width)) return position + 1;
        return position;
    }

    private static boolean canMoveLeft(List<Boolean> points, int position) {
        return position > 0 && points.get(position - 1);
    }

    private static boolean canMoveRight(List<Boolean> points, int position, int width) {
        return position < width - 1 && points.get(position);
    }


}
