package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLadder(Ladder ladder, Participants participants, Rewards rewards) {
        System.out.println("사다리 결과");
        printParticipants(participants.getNames());
        ladder.getLines().forEach(OutputView::printLine);
        printRewards(rewards.getRewards());
    }

    public static void printRewards(List<String> rewards) {
        rewards.forEach(
                reward -> System.out.print(reward + " ".repeat(5 - reward.length()))
        );
        System.out.println();
    }

    public static void printAllResults(Map<String, String> resultMap) {
        System.out.println("\n실행 결과");
        resultMap.forEach((name, result) -> System.out.println(name + " : " + result));
    }

    public static void printResultFor(String reward) {
        System.out.println("실행 결과");
        System.out.println(reward);
    }

    private static void printParticipants(List<String> participants) {
        participants.forEach(
                participant -> System.out.print(participant + " ".repeat(5 - participant.length()))
        );
        System.out.println();
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
