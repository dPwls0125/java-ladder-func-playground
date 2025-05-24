import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderGameTest {
    @Test
    @DisplayName("게임 결과에 대해 참가자별 보상 일치 여부 확인")
    void testRewardsMapping() {
        Participants participants = new Participants(List.of("ozzi", "zhang", "kwon", "yejin"));
        Rewards rewards = new Rewards(List.of("3000", "꽝", "2000", "1000"));

        List<Line> lines = List.of(
                Line.createWithFixedPoints(List.of(true, false, false)),
                Line.createWithFixedPoints(List.of(true, false, true)),
                Line.createWithFixedPoints(List.of(false, false, false))
        );
        Ladder ladder = Ladder.createWithFixedLines(lines);

        LadderGame game = new LadderGame(participants, rewards, ladder);

        assertAll(
                () -> assertThat(game.allResults())
                        .isEqualTo(Map.of("ozzi", "3000", "zhang", "꽝", "kwon", "1000", "yejin", "2000")),
                () -> assertThat(game.resultFor("ozzi")).isEqualTo("3000"),
                () -> assertThat(game.resultFor("zhang")).isEqualTo("꽝"),
                () -> assertThat(game.resultFor("kwon")).isEqualTo("1000"),
                () -> assertThat(game.resultFor("yejin")).isEqualTo("2000"));
    }
}
