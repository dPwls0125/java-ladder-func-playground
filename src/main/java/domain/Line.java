package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line create(final int width) {
        int lineConnectionNumber = width - 1;
        List<Boolean> points = RandomBooleansGenerator.generateRandomBooleans(lineConnectionNumber);
        validatePointsSize(points, lineConnectionNumber);
        return new Line(points);
    }

    public static Line createWithFixedPoints(final List<Boolean> points) {
        return new Line(points);
    }

    private static void validatePointsSize(final List<Boolean> points, final int expectedSize) {
        if (points.size() != expectedSize) throw new invalidLineWidthException("사다리간 연결 지점은 width-1개여야 합니다.");
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private static class invalidLineWidthException extends IllegalArgumentException {
        public invalidLineWidthException(final String s) {
            super(s);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Line line)) return false;
        return Objects.equals(getPoints(), line.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints());
    }
}
