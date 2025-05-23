package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int LINE_WIDTH = 4;
    private static final int LINE_CONNECTION = LINE_WIDTH - 1;
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        validateLineWidth(points);
        this.points = new ArrayList<>(points);
    }

    public static Line create() {
        return new Line(RandomBooleansGenerator.generateRandomBooleans(LINE_CONNECTION));
    }

    private void validateLineWidth(final List<Boolean> points) {
        if (points.size() != LINE_CONNECTION) throw new invalidLineWidthException("사다리간 연결 지점은 3이어야 합니다.");
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private static class invalidLineWidthException extends IllegalArgumentException {
        public invalidLineWidthException(final String s) {
            super(s);
        }
    }
}
