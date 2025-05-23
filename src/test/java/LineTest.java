import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("정적 팩토리 메서드 create()로 생성된 Line 객체의 points 사이즈는 3이다.")
    void whenCreatedByStaticFactoryMethod_thenHasValidLinesSize() {
        Line line = Line.create();
        assertThat(line.getPoints()).hasSize(3);
    }
}
