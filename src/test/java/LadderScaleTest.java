import domain.LadderScale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderScaleTest {

    @Test
    @DisplayName("너비가 2이상, 높이가 1이상이면 LadderScale 객체를 생성한다.")
    void whenWidthAndHeightIsValid_thenCreateLadderScaleSuccessfully() {
        int width = 2;
        int height = 1;
        assertThatCode(() -> new LadderScale(width, height)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("너비가 2 미만이면 => throws IllegalArgumentException")
    void whenWidthIsLessThenTwo_thenThrowsException() {
        int width = 1;
        int height = 1;
        assertThatThrownBy(() -> new LadderScale(width, height)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 너비는 2이상이어야 합니다.");
    }

    @Test
    @DisplayName("높이가 1 미만이면 => throws IllegalArgumentException")
    void whenHeightIsLessThenOne_thenThrowsException() {
        int width = 2;
        int height = 0;
        assertThatThrownBy(() -> new LadderScale(width, height)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상이어야 합니다.");
    }
}
