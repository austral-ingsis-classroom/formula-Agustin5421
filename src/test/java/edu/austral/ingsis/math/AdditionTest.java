package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AdditionTest {

    @Test
    public void shouldResolveFunction1() {
        Variable x = new Variable("x");
        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("x", 3d);

        Function addition = Operations.add(new Constant(1d), x);
        Function solved = addition.solve(variablesMap);

        assertThat(solved.value(), equalTo(4d));
    }

    @Test
    public void shouldResolveFunction2() {
        Variable div = new Variable("div");
        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("div", 4d);

        Function division = Operations.divide(new Constant(12d), div);
        Function solved = division.solve(variablesMap);

        assertThat(solved.value(), equalTo(3d));
    }
}
