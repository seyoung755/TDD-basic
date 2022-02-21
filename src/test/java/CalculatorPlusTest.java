
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorPlusTest {
    private CalculatorPlus c;

    @Test
    void NULL_또는_공백을_입력하면_0을_반환하는_함수() {
        c = new CalculatorPlus("");
        assertThat(c.getResult()).isEqualTo(0);
        c = new CalculatorPlus(null);
        assertThat(c.getResult()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 숫자_하나를_문자열로_입력하면_해당_숫자를_반환하는_함수(String text) {
        c = new CalculatorPlus(text);
        assertThat(c.getResult()).isEqualTo(Integer.parseInt(text));
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력하면_두_숫자의_합을_반환하는_함수() {
        String text = "1,2";
        c = new CalculatorPlus(text);
        assertThat(c.getResult()).isEqualTo(3);
        text = "3,4";
        c = new CalculatorPlus(text);
        assertThat(c.getResult()).isEqualTo(7);
        text = "5,6";
        c = new CalculatorPlus(text);
        assertThat(c.getResult()).isEqualTo(11);
    }

    @Test
    void 구분자를_컴마_이외에_콜론을_사용할_수_있는_함수() {
        String text = "1,2:3";
        c = new CalculatorPlus(text);
        assertThat(c.getResult()).isEqualTo(6);
        text = "2:3,5";
        c = new CalculatorPlus(text);
        assertThat(c.getResult()).isEqualTo(10);
        text = "2:3,5:10";
        c = new CalculatorPlus(text);
        assertThat(c.getResult()).isEqualTo(20);
    }
}
