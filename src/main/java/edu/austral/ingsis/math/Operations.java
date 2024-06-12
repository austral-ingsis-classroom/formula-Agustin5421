package edu.austral.ingsis.math;

public class Operations {

  public static BinaryOperation add(Function left, Function right) {
    return new BinaryOperation(left, right, Double::sum, "+");
  }

  public static BinaryOperation subtract(Function left, Function right) {
    return new BinaryOperation(left, right, (a, b) -> a - b, "-");
  }

  public static BinaryOperation multiply(Function left, Function right) {
    return new BinaryOperation(left, right, (a, b) -> a * b, "*");
  }

  public static BinaryOperation divide(Function left, Function right) {
    return new BinaryOperation(left, right, (a, b) -> a / b, "/");
  }

  public static ModuleOperation module(Function operand) {
    return new ModuleOperation(operand);
  }

  public static BinaryOperation power(Function left, Function right) {
    return new BinaryOperation(left, right, Math::pow, "^");
  }

  public static UnaryOperation sqrt(Function operand) {
    return new UnaryOperation(operand, Math::sqrt, "√");
  }
}
