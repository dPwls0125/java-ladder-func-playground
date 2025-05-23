import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("정적 팩토리 메서드 create()로 생성된 Line 객체의 points 리스트의 길이는 width-1 이다.")
    void whenCreatedByStaticFactoryMethod_thenHasValidLinesSize() {
        int width = 3;
        int expectedPointsSize = width - 1;

        Line line = Line.create(width);

        assertThat(line.getPoints()).hasSize(expectedPointsSize);
    }

    @Test
    @DisplayName("랜덤 Boolean 리스트는 연속된 true를 포함하지 않는다")
    void connectedPointsCannotBeContinuous() {
        int width = 100;
        List<Boolean> points = Line.create(width).getPoints();

        for (int i = 0; i < points.size() - 1; i++) {
            boolean current = points.get(i);
            boolean next = points.get(i + 1);
            assertThat(current && next).isFalse();
        }
    }
}
