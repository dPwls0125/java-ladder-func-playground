package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGame {

    private final Participants participants;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(final Participants participants, final Rewards rewards, final Ladder ladder) {
        this.participants = participants;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public String resultFor(final String name) {
        int start = participants.indexOf(name);
        int end = ladder.getResult().getPositions().get(start);
        return rewards.rewardAt(end);
    }

    public Map<String, String> allResults() {
        Map<String, String> resultMap = new HashMap<>();
        List<Integer> positions = ladder.getResult().getPositions();
        for (int i = 0; i < participants.size(); i++) {
            resultMap.put(participants.nameAt(i), rewards.rewardAt(positions.get(i)));
        }
        return resultMap;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGame that)) return false;
        return Objects.equals(participants, that.participants) && Objects.equals(rewards, that.rewards) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, rewards, ladder);
    }
}
