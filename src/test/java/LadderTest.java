import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("정적 팩토리 메서드 create()로 생성된 Ladder 객체의 lines 사이즈는 4이다.")
    void whenCreatedByStaticFactoryMethod_thenHasValidLinesSize() {
        Ladder ladder = Ladder.create();
        assertThat(ladder.getLines()).hasSize(4);
    }

}
