package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int LADDER_HEIGHT = 4;
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        validateLadderHeight(lines);
        this.lines = lines;
    }

    public static Ladder create() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < LADDER_HEIGHT; i++) {
            lines.add(Line.create());
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private void validateLadderHeight(final List<Line> lines) {
        if (lines.size() != LADDER_HEIGHT) throw new invalidLadderHeightException("사다리의 높이는 4이어야 합니다.");
    }

    private static class invalidLadderHeightException extends IllegalArgumentException {
        public invalidLadderHeightException(final String s) {
            super(s);
        }
    }
}
