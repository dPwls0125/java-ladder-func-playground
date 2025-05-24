package domain;

import java.util.List;
import java.util.Objects;

public class Participants {
    private static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public Participants(final List<String> names) {
        validateLength(names);
        this.names = names;
    }

    private void validateLength(List<String> names) {
        names.forEach(name -> {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("참여자 이름은 5글자 이하여야 합니다.:" + name);
            }
        });
    }

    public int indexOf(String name) {
        return names.indexOf(name);
    }

    public String nameAt(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return List.copyOf(names);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants that)) return false;
        return Objects.equals(getNames(), that.getNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNames());
    }
}
