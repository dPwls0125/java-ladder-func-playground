package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Result {

    private final List<Integer> result;

    public Result(final List<Integer> result) {
        this.result = new ArrayList<>(result);
    }

    public List<Integer> getResult() {
        return Collections.unmodifiableList(result);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Result that)) return false;
        return Objects.equals(getResult(), that.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }
}
