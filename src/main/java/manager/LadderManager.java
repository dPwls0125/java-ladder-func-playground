package manager;

import domain.Ladder;
import domain.LadderScale;
import domain.Result;
import view.InputView;
import view.OutputView;

public class LadderManager {
    public Ladder getAndPrintRandomLadder() {
        LadderScale ladderScale = InputView.induceLadderScaleToBeEnteredAndReturn();
        Ladder ladder = Ladder.create(ladderScale);
        OutputView.printLadder(ladder);
        return ladder;
    }

    public void getAndPrintResult(Ladder ladder) {
        Result result = ladder.getResult();
        OutputView.printResult(result);
    }

}
