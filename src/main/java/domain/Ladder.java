package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final LadderScale ladderScale;
    private final List<Line> lines;

    private Ladder(final LadderScale ladderScale, final List<Line> lines) {
        validateLadderHeight(lines, ladderScale);
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

    public static Ladder createWithFixedLines(final List<Line> lines) {
        LadderScale ladderScale = new LadderScale(lines.get(0).getPoints().size() + 1, lines.size());
        return new Ladder(ladderScale, lines);
    }

    public Result getResult() {
        return new Result(LadderResultCalculator.calculate(this));
    }

    private void validateLadderHeight(final List<Line> lines, final LadderScale ladderScale) {
        if (lines.size() != ladderScale.getHeight())
            throw new invalidLadderHeightException("사다리의 높이는 ladderScale.getHeight와 같아야 합니다.");
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public LadderScale getLadderScale() {
        return ladderScale;
    }

    private static class invalidLadderHeightException extends IllegalArgumentException {
        public invalidLadderHeightException(final String s) {
            super(s);
        }
    }
}
