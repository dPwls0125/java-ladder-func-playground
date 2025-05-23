import domain.Ladder;
import domain.LadderScale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @Test
    @DisplayName("Ladder는 LoadderScale의 height만큼 line을 만들고, width-1만큼 연결 포인트를 생성한다.")
    void whenCreatedByStaticFactoryMethod_thenHasValidLinesSize() {

        LadderScale ladderScale = new LadderScale(2, 1);
        Ladder ladder = Ladder.create(ladderScale);

        int expectedPointsSize = ladderScale.getWidth() - 1;
        int expectedHeight = ladderScale.getHeight();

        assertAll(
                () -> assertThat(ladder.getLines()).hasSize(expectedHeight),
                () -> assertThat(ladder.getLines().getFirst().getPoints()).hasSize(expectedPointsSize));
    }

}
