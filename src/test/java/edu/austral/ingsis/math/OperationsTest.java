package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OperationsTest {

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

    @Test
    public void shouldResolveFunction3() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("x", 3d);
        variablesMap.put("y", 4d);

        Function division = Operations.divide(new Constant(9d), x);
        Function multiplication = Operations.multiply(division, y);
        Function solved = multiplication.solve(variablesMap);

        assertThat(solved.value(), equalTo(12d));
    }

    @Test
    public void shouldResolveFunction4() {
        Variable a = new Variable("a");
        Variable b = new Variable("b");

        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("a", 9d);
        variablesMap.put("b", 3d);

        Function division = Operations.divide(new Constant(27d), a);
        Function power = Operations.power(division, b);
        Function solved = power.solve(variablesMap);

        assertThat(solved.value(), equalTo(27d));
    }

    @Test
    public void shouldResolveFunction5() {
        Variable z = new Variable("z");
        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("z", 36d);

        Function sqrt = Operations.sqrt(z);
        Function solved = sqrt.solve(variablesMap);

        assertThat(solved.value(), equalTo(6d));
    }

    @Test
    public void shouldResolveFunction6() {
        Variable value = new Variable("value");

        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("value", 8d);

        Function absValue = Operations.add(value, new Constant(0d));
        Function subtraction = Operations.subtract(absValue, new Constant(8d));
        Function solved = subtraction.solve(variablesMap);

        assertThat(solved.value(), equalTo(0d));
    }

    @Test
    public void shouldResolveFunction7() {
        Variable value = new Variable("value");

        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("value", 8d);

        Function absValue = Operations.add(value, new Constant(0d));
        Function subtraction = Operations.subtract(absValue, new Constant(8d));
        Function solved = subtraction.solve(variablesMap);

        assertThat(solved.value(), equalTo(0d));
    }

    @Test
    public void shouldResolveFunction8() {
        Variable i = new Variable("i");

        Map<String, Double> variablesMap = new HashMap<>();
        variablesMap.put("i", 2d);

        Function subtraction = Operations.subtract(new Constant(5d), i);
        Function multiplication = Operations.multiply(subtraction, new Constant(8d));
        Function solved = multiplication.solve(variablesMap);

        assertThat(solved.value(), equalTo(24d));
    }
}
