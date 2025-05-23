import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
