package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function addition = Operations.add(new Constant(1d), new Constant(6d)).solve(Collections.emptyMap());
    Double result = addition.value();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function division = Operations.divide(new Constant(12d), new Constant(2d));
    Double result = division.solve(Collections.emptyMap()).value();

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function division = Operations.divide(new Constant(9d), new Constant(2d));
    Function multiplication = Operations.multiply(division, new Constant(3d));
    Double result = multiplication.solve(Collections.emptyMap()).value();

    assertThat(result, equalTo(13.5));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function division = Operations.divide(new Constant(27d), new Constant(6d));
    Function power = Operations.power(division, new Constant(2d));
    Double result = power.solve(Collections.emptyMap()).value();

    assertThat(result, equalTo(20.25));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function sqrt = Operations.sqrt(new Constant(36d));
    Double result = sqrt.solve(Collections.emptyMap()).value();

    assertThat(result, equalTo(6d));

  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function absValue = Operations.module(new Constant(136d));
    Double result = absValue.solve(Collections.emptyMap()).value();

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function absValue = Operations.module(new Constant(-136d));
    Double result = absValue.solve(Collections.emptyMap()).value();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function subtraction = Operations.subtract(new Constant(5d), new Constant(5d));
    Function multiplication = Operations.multiply(subtraction, new Constant(8d));
    Double result = multiplication.solve(Collections.emptyMap()).value();

    assertThat(result, equalTo(0d));
  }
}
