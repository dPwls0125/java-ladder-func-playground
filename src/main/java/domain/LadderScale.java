package domain;

import java.util.Objects;

public class LadderScale {

    private final int width;
    private final int height;

    public LadderScale(final int width, final int height) {
        validateSize(width, height);
        this.width = width;
        this.height = height;
    }

    private void validateSize(final int width, final int height) {

        if (width < 2) {
            throw new IllegalArgumentException("사다리의 너비는 2이상이어야 합니다.");
        }

        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderScale that)) return false;
        return getWidth() == that.getWidth() && getHeight() == that.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWidth(), getHeight());
    }

}

