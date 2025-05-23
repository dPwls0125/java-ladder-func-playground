package manager;

import domain.Ladder;
import domain.LadderScale;
import view.InputView;
import view.OutputView;

public class LadderManager {
    public Ladder getAndPrintRandomLadder() {
        LadderScale ladderScale = InputView.induceLadderScaleToBeEnteredAndReturn();
        Ladder ladder = Ladder.create(ladderScale);
        OutputView.printLadder(ladder);
        return ladder;
    }
}
