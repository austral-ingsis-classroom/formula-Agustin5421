package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function addition = Operations.add(new Constant(1d), new Constant(6d));
    List<String> result = new ArrayList<>(addition.getVariables());

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Variable div = new Variable("div");
    Function division = Operations.divide(new Constant(12d), div);
    List<String> result = new ArrayList<>(division.getVariables());

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Variable x = new Variable("x");
    Variable y = new Variable("y");
    Function division = Operations.divide(new Constant(9d), x);
    Function multiplication = Operations.multiply(division, y);
    List<String> result = new ArrayList<>(multiplication.getVariables());

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Variable a = new Variable("a");
    Variable b = new Variable("b");
    Function division = Operations.divide(new Constant(27d), a);
    Function power = Operations.power(division, b);
    List<String> result = new ArrayList<>(power.getVariables());

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Variable z = new Variable("z");
    Function sqrt = Operations.sqrt(z);
    List<String> result = new ArrayList<>(sqrt.getVariables());

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Variable value = new Variable("value");
    Function absValue = Operations.add(value, new Constant(0d));
    Function subtraction = Operations.subtract(absValue, new Constant(8d));
    List<String> result = new ArrayList<>(subtraction.getVariables());

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Variable value = new Variable("value");
    Function absValue = Operations.add(value, new Constant(0d));
    Function subtraction = Operations.subtract(absValue, new Constant(8d));
    List<String> result = new ArrayList<>(subtraction.getVariables());

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Variable i = new Variable("i");
    Function subtraction = Operations.subtract(new Constant(5d), i);
    Function multiplication = Operations.multiply(subtraction, new Constant(8d));
    List<String> result = new ArrayList<>(multiplication.getVariables());

    assertThat(result, containsInAnyOrder("i"));
  }
}
