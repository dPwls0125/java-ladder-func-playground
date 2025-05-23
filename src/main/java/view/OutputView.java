package view;

import domain.Ladder;
import domain.Line;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        line.getPoints().forEach(
                point -> {
                    if (point) System.out.print("|----");
                    if (!point) System.out.print("|    ");
                });
        System.out.print("|\n");
    }
}
