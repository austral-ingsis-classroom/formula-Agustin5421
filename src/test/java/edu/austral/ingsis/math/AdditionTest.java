package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;

public class AdditionTest {
    @Test
    void shouldAddTwoNumbers() {
        final Function result = new Addition(new Constant(1.0), new Constant(6.0)).solve();

        assert result.getValue() == 7.0;
    }
}
