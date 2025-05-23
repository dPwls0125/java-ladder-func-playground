package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final LadderScale ladderScale;
    private final List<Line> lines;

    private Ladder(final LadderScale ladderScale, final List<Line> lines) {
        validateLadderHeight(lines);
        this.lines = lines;
        this.ladderScale = ladderScale;
    }

    public static Ladder create(final LadderScale ladderScale) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderScale.getHeight(); i++) {
            lines.add(Line.create(ladderScale.getWidth()));
        }
        return new Ladder(ladderScale, lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private void validateLadderHeight(final List<Line> lines) {
        if (lines.size() != ladderScale.getHeight())
            throw new invalidLadderHeightException("사다리의 높이는 ladderScale.getHeight와 같아야 합니다.");
    }

    private static class invalidLadderHeightException extends IllegalArgumentException {
        public invalidLadderHeightException(final String s) {
            super(s);
        }
    }
}
