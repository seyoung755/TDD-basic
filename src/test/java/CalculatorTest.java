import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void 문자열이_공백으로_나눠서_연산하는_함수() {
        String text = "2 + 3 * 4 / 2";
        assertThat(Calculator.getResult(Calculator.parse(text))).isEqualTo(10);
        text = "5 + 10 - 3 * 4 / 2";
        assertThat(Calculator.getResult(Calculator.parse(text))).isEqualTo(24);
    }
}
