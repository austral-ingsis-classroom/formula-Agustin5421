package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    Function addition = Operations.add(new Constant(1d), new Constant(6d));
    final String expected = "1 + 6";
    final String result = addition.getString();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    Function division = Operations.divide(new Constant(12d), new Constant(2d));
    final String expected = "12 / 2";
    final String result = division.getString();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Function division = Operations.divide(new Constant(9d), new Constant(2d));
    Function multiplication = Operations.multiply(division, new Constant(3d));
    final String expected = "(9 / 2) * 3";
    final String result = multiplication.getString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Function division = Operations.divide(new Constant(27d), new Constant(6d));
    Function power = Operations.power(division, new Constant(2d));
    final String expected = "(27 / 6) ^ 2";
    final String result = power.getString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    Variable value = new Variable("value");
    Function absValue = Operations.module(value);
    Function subtraction = Operations.subtract(absValue, new Constant(8d));
    final String expected = "|value| - 8";
    final String result = subtraction.getString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    Variable value = new Variable("value");
    Function absValue = Operations.module(value);
    Function subtraction = Operations.subtract(absValue, new Constant(8d));
    final String expected = "|value| - 8";
    final String result = subtraction.getString();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    Variable i = new Variable("i");
    Function subtraction = Operations.subtract(new Constant(5d), i);
    Function multiplication = Operations.multiply(subtraction, new Constant(8d));
    final String expected = "(5 - i) * 8";
    final String result = multiplication.getString();

    assertThat(result, equalTo(expected));
  }
}
