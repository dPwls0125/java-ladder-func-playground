package manager;

import domain.Ladder;
import view.OutputView;

public class LadderManager {
    public Ladder getAndPrintRandomLadder() {
        Ladder ladder = Ladder.create();
        OutputView.printLadder(ladder);
        return ladder;
    }
}
