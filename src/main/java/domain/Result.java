package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Result {

    private final List<Integer> positions;

    public Result(final List<Integer> result) {
        this.positions = new ArrayList<>(result);
    }

    public List<Integer> getPositions() {
        return Collections.unmodifiableList(positions);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Result result)) return false;
        return Objects.equals(getPositions(), result.getPositions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPositions());
    }
}
