package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Variable x = new Variable("x");
    Function addition = Operations.add(new Constant(1d), x);

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("x", 3d);

    Double result = addition.solve(variablesMap).value();

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Variable div = new Variable("div");
    Function division = Operations.divide(new Constant(12d), div);

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("div", 4d);

    Double result = division.solve(variablesMap).value();

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Variable x = new Variable("x");
    Variable y = new Variable("y");
    Function division = Operations.divide(new Constant(9d), x);
    Function multiplication = Operations.multiply(division, y);

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("x", 3d);
    variablesMap.put("y", 4d);

    Double result = multiplication.solve(variablesMap).value();

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Variable a = new Variable("a");
    Variable b = new Variable("b");
    Function division = Operations.divide(new Constant(27d), a);
    Function power = Operations.power(division, b);

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("a", 9d);
    variablesMap.put("b", 3d);

    Double result = power.solve(variablesMap).value();

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Variable z = new Variable("z");
    Function sqrt = Operations.sqrt(z);

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("z", 36d);

    Double result = sqrt.solve(variablesMap).value();

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Variable value = new Variable("value");
    Function absValue = Operations.module(value);
    Function subtraction = Operations.subtract(absValue, new Constant(8d));

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("value", 8d);

    Double result = subtraction.solve(variablesMap).value();

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Variable value = new Variable("value");
    Function absValue = Operations.module(value);
    Function subtraction = Operations.subtract(absValue, new Constant(8d));

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("value", 8d);

    Double result = subtraction.solve(variablesMap).value();

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Variable i = new Variable("i");
    Function subtraction = Operations.subtract(new Constant(5d), i);
    Function multiplication = Operations.multiply(subtraction, new Constant(8d));

    Map<String, Double> variablesMap = new HashMap<>();
    variablesMap.put("i", 2d);

    Double result = multiplication.solve(variablesMap).value();

    assertThat(result, equalTo(24d));
  }
}
