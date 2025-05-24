import domain.Ladder;
import manager.LadderManager;

public class Main {
    public static void main(String[] args) {
        LadderManager ladderManager = new LadderManager();
        Ladder ladder = ladderManager.getAndPrintRandomLadder();
        ladderManager.getAndPrintResult(ladder);
    }
}
