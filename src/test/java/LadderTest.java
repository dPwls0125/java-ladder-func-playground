import domain.Ladder;
import domain.LadderScale;
import domain.Line;
import domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("Ladder의 getResult 메서드는 사다리 타기 결과를 전달한다.")
    void testGetResult() {

        List<Line> lines = List.of(
                Line.createWithFixedPoints(List.of(true, false, false)),
                Line.createWithFixedPoints(List.of(true, false, true)),
                Line.createWithFixedPoints(List.of(false, false, false))
        );
        Ladder ladder = Ladder.createWithFixedLines(lines);

        Result expectedResult = new Result(List.of(0, 1, 3, 2));

        assertThat(ladder.getResult()).isEqualTo(expectedResult);

    }

}
