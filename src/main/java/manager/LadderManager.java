package manager;

import domain.*;
import view.InputView;
import view.OutputView;

public class LadderManager {
    public LadderGame getAndShowRandomLadder() {
        Participants participants = new Participants(InputView.induceParticipantsToBeEnteredAndReturn());
        Rewards rewards = new Rewards(InputView.induceRewardsToBeEnteredAndReturn());
        int height = InputView.induceLadderHeightToBeEnteredAndReturn();

        LadderScale ladderScale = new LadderScale(participants.size(), height);
        Ladder ladder = Ladder.create(ladderScale);

        OutputView.printLadder(ladder, participants, rewards);
        return new LadderGame(participants, rewards, ladder);
    }

    public void showResult(LadderGame game) {
        while (true) {
            String input = InputView.induceToQueryRewardForParticipant();

            if (input.equalsIgnoreCase("all")) {
                OutputView.printAllResults(game.allResults());
                break;
            }
            String result = game.resultFor(input);
            OutputView.printResultFor(result);
        }
    }

}
