package domain;

import java.util.List;
import java.util.Objects;

public class Rewards {
    private final List<String> rewards;

    public Rewards(final List<String> rewards) {
        this.rewards = rewards;
    }

    public String rewardAt(final int index) {
        return rewards.get(index);
    }

    public List<String> getRewards() {
        return List.copyOf(rewards);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Rewards rewards1)) return false;
        return Objects.equals(getRewards(), rewards1.getRewards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRewards());
    }
}

