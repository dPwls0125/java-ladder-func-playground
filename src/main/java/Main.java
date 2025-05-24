import domain.LadderGame;
import manager.LadderManager;

public class Main {
    public static void main(String[] args) {
        LadderManager ladderManager = new LadderManager();
        LadderGame ladderGame = ladderManager.getAndShowRandomLadder();
        ladderManager.showResult(ladderGame);
    }
}
