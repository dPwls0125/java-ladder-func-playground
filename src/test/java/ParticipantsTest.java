import domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    @DisplayName("이름이 5자를 넘어가면 throws IllegalArgumentException")
    void whenNameUpperThenFive_thenThrowsException() {
        assertThatThrownBy(() -> new Participants(List.of("yejin2", "ozzi", "zhang", "kwon")))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("참여자 이름은 5글자 이하여야 합니다.:yejin2");
    }

    @Test
    @DisplayName("5자 이하로 구성된 String 리스트를 넘겨받으면 성공적으로 객체를 생성한다.")
    void testCreateParticipants() {
        assertThatCode(() -> new Participants(List.of("yejin", "ozzi", "zhang", "kwon")))
                .doesNotThrowAnyException();
    }
}
