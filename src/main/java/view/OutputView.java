package view;

import domain.Ladder;
import domain.Line;
import domain.Result;

import java.util.List;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        System.out.println("실행 결과");
        ladder.getLines().forEach(OutputView::printLine);
    }

    public static void printResult(Result result) {
        List<Integer> ladderResult = result.getResult();
        for (int i = 0; i < ladderResult.size(); i++) {
            System.out.println(String.format("%d -> %d", i, ladderResult.get(i)));
        }
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
